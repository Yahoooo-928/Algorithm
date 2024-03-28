import java.io.*;
import java.util.*;
public class Solution {
	
	static int n,m,ans;
	static char[][] map;
	static int[] di= {0,0,1,-1};
	static int[] dj= {1,-1,0,0};
	static boolean[][] v;
	static ArrayDeque<int[]> devil; // 악마손아귀 좌표값 저장할 dq
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<T+1; tc++) {
			sb= new StringBuilder();
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new char[n][m];
			v=new boolean[n][m];
			int x=0;
			int y=0;
			
			devil = new ArrayDeque<>();
			for(int i=0; i<n; i++) {
				String s = br.readLine();
				for(int j=0; j<m; j++) {
					map[i][j]=s.charAt(j);
					if(map[i][j]=='S') {// 수연이의 위치 
						x = i;
						y = j;
					}
					if(map[i][j]=='*') {// 악마의 위치
						devil.offer(new int[] {i,j});
						v[i][j]=true;
					}
				}
				
			}
			
			
			// 수연 위치 s, 여신 공간 d, 돌 x, 악마는 *, 평범한 지역은 .(수연이가 이동도 할 수 있고 악마의 손아귀 스킬이 확장가능한 곳)
			// 수연이가 악마의 손아귀를 벗어나면서 안전지역에 가기위한 최소 시간 출력 
			// 불가능 game over
			
			
			ans = Integer.MAX_VALUE;
			
			bfs(x,y,0);
			
			if(ans==Integer.MAX_VALUE) {
				sb.append("#").append(tc).append(" ").append("GAME OVER");
			}else {
				sb.append("#").append(tc).append(" ").append(ans);
			}
			System.out.println(sb.toString());
		}
		
		
		br.close();
	}
	static void bfs(int x, int y, int count) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x,y,count});
		v[x][y]=true;
		while(!q.isEmpty()) {
			
			// 악마의 손아귀 영역을 표시해준다. 
			// 수연이는 악마의 손아귀 영역에 포함되면 안되기 때문에 
			// 악마가 부식시킬 영역들을 먼저 표시해준다. 
			int size = devil.size();
			for(int a=0; a<size; a++) {
				int[] now = devil.poll();
				for(int d=0; d<4; d++) {
					int nx = now[0]+di[d];
					int ny = now[1]+dj[d];
					if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]=='.' && !v[nx][ny]) {
						map[nx][ny]='*';
						devil.offer(new int[] {nx,ny});
						v[nx][ny]=true;
					}
				}
			}
						
			int Ssize = q.size();
			for(int b =0; b<Ssize; b++) {
				int[] cur = q.poll();
				if(map[cur[0]][cur[1]]=='D') {
					ans = Math.min(ans, cur[2]);
				}
				for(int d=0; d<4; d++) {
					int nx = cur[0]+di[d];
					int ny = cur[1]+dj[d];
					if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]!='*' && map[nx][ny]!='X' && !v[nx][ny]) {
						q.offer(new int[] {nx,ny,cur[2]+1});
						v[nx][ny]=true;
					}
				}
			}
			
		}
	}
	
	
}