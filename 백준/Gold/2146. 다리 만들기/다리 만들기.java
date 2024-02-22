import java.io.*;
import java.util.*;

public class Main {
	
	static int n, ans;
	static int[][] map;
	static boolean[][] v;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬이 모두 1로 표시되어 구분이 어려우므로 
		// 각각 다른 숫자로 표시해준다. 2부터 시작
		int idx = 2;
		v = new boolean[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++) {
				if(map[i][j]==1 && !v[i][j]) {
					bfs(i,j,idx);
					idx++;
				}
			}
		}
		// 다리를 놓을 수 있는 경우를 구한다.
		ans = Integer.MAX_VALUE;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++) {
				if(map[i][j]>1) {
					v = new boolean[n][n];
					search(i,j,0);
				}
			}
		}
		
		System.out.println(ans);
		
		br.close();
	}

	static void search(int i, int j, int cnt) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j,cnt});
		v[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			
			for(int d=0; d<4; d++) {
				int nx = ij[0]+di[d];
				int ny = ij[1]+dj[d];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n && !v[nx][ny]) {
					if(map[nx][ny]>1 && map[nx][ny]!=map[i][j]) {
						ans = Math.min(ans, ij[2]);
					}else if(map[nx][ny]==0) {
						v[nx][ny]=true;
						if(ij[2]+1<=ans) {
							q.offer(new int[] {nx,ny,ij[2]+1});
						}
					}
				}
			}
			
		}
		
		
	}

	static void bfs(int i, int j, int idx) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		map[i][j]= idx;
		
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			
			for(int d=0; d<4; d++) {
				int nx = ij[0]+di[d];
				int ny = ij[1]+dj[d];
				if(nx>=0 && nx<n && ny>=0 && ny<n && !v[nx][ny] && map[nx][ny]==1) {
					map[nx][ny]=idx;
					v[nx][ny]=true;
					q.offer(new int[] {nx,ny});
				}
			}
			
		}
	}

}
