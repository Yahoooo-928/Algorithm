import java.io.*;
import java.util.*;

public class Main {
	
	static int k,w,h,ans;
	static int[][] map;
	static boolean[][][] v;
	static int[] di= {-2,-2,-1,-1,1,1,2,2};
	static int[] dj= {-1,1,-2,2,-2,2,-1,1};
	
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 원숭이는 k번만 말같이 움직일 수 있고 그외에느 그냥 인접한 칸만으로만 움직일 수 있다용.
		
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<w; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		v = new boolean[h][w][k+1];
		ans = Integer.MAX_VALUE; // 원숭이 동작수 -> 최솟값 출력해야함. 
		bfs(0,0,0,0); // x,y좌표, 동작수, 원숭이가 말처럼 움직인 횟수 
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
		
		br.close();
	}

	static void bfs(int i, int j, int cnt, int kcnt) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j][kcnt]=true;
		q.offer(new int[] {i,j,cnt,kcnt});
		
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0]==h-1 && cur[1]==w-1) {
				ans = Math.min(ans,cur[2]);
			}
			
			// 원숭이가 말처럼 움직일 때
			if(cur[3]<k) {
				for(int a=0; a<8; a++) {
					int nx = cur[0] + di[a];
					int ny = cur[1] + dj[a];
					if(nx>=0 && nx<h && ny>=0 && ny<w && !v[nx][ny][cur[3]+1] && map[nx][ny]!=1) {
						v[nx][ny][cur[3]+1]=true;
						q.offer(new int[] {nx,ny,cur[2]+1,cur[3]+1});
					}
				}
			}
			
			// 그냥 원숭이로 움직일 때
			for(int b=0; b<4; b++) {
				int nx = cur[0] + dx[b];
				int ny = cur[1] + dy[b];
				if(nx>=0 && nx<h && ny>=0 && ny<w && !v[nx][ny][cur[3]] && map[nx][ny]!=1) {
					v[nx][ny][cur[3]]=true;
					q.offer(new int[] {nx,ny,cur[2]+1,cur[3]});
				}
			}
			
		}
	}

}