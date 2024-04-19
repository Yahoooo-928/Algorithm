import java.io.*;
import java.util.*;
public class Main {

	static int n,k,l;
	static int[][] map;
	static char[] game;
	static int[] di= {0,0,1,-1};
	static int[] dj= {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//보드 크기 n
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		// 사과 갯수
		k = Integer.parseInt(br.readLine());
		
		// 사과의 위치들 map에서 2로 표현
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x-1][y-1]=2;
		}
		
		//뱀의 방향 변환 정보
		l = Integer.parseInt(br.readLine());
		// x 초가 끝난 뒤 오른쪽 아님 왼쪽으로 90도 방향 회전시킨다는 뜻 
		// x는 10,000이하 
		game = new char[10001];
		for(int i=0; i<l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			String y = st.nextToken();
			game[x] = y.charAt(0);
		}
		
		int answer = bfs(0,0,0,0,0,0); // 시작 x,y,방향,시간
		
		System.out.println(answer);
		br.close();
	}
	
	static int bfs(int i, int j,int x, int y, int d, int t) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		ArrayDeque<int[]> tail = new ArrayDeque<>();
		//뱀이 현재 있는 위치는 1로 표시한다. 
		// 벽이나 자기 자신의 몸과 부딪히면 게임 끝
		map[i][j]=1;
		q.offer(new int[] {i,j,d,t});
		tail.offer(new int[] {x,y});
		
		int ans = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int direction=cur[2];
			
			int nx = cur[0]+di[direction];
			int ny = cur[1]+dj[direction];
			// 이동칸이 범위를 벗어나거나 자기 자신과 만나는지 check
			if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny]!=1) {
				// 이동칸에 사과가 없으면
				if(map[nx][ny]==0) {
					//몸길이 줄여서 꼬리가 위치한 칸을 비워준다.
					int[] t_xy = tail.poll();
					map[t_xy[0]][t_xy[1]]=0;
				}
				map[nx][ny]=1;
				int time= cur[3]+1;
				if(game[time]=='L') {
					if(direction==0)direction=3;
					else if(direction==1) direction=2;
					else if(direction==2) direction=0;
					else if(direction==3) direction=1;
				}else if(game[time]=='D') {
					if(direction==0)direction=2;
					else if(direction==1) direction=3;
					else if(direction==2) direction=1;
					else if(direction==3) direction=0;
				}
				
				q.offer(new int[] {nx,ny,direction,time});
				tail.offer(new int[] {nx,ny});
			}else {
				ans = cur[3]+1;
			}
			
		}
		return ans;
		
	}

}