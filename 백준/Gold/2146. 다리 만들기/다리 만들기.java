import java.io.*;
import java.util.*;
public class Main {
	static int n, answer;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		answer = Integer.MAX_VALUE;
		// map에서 섬을 나눠서 표시해주자
		visited = new boolean[n][n];
		int num = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					bfs(i,j,num);
					num++;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]!=0) {
					visited = new boolean[n][n];
					start(i,j,map[i][j]);
				}
			}
		}
		
		System.out.println(answer);
		
		br.close();
	}
	
	private static void start(int i, int j, int num) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited[i][j] = true;
		q.offer(new int[] {i,j,0});
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			int c = current[2];
			
//			System.out.println(x+" " +y+" "+c);
			if(map[x][y]!=0 && map[x][y]!=num) {
				answer = Math.min(answer, c-1);
//				System.out.println(answer+"!");
				break;
			}
			
			
			for(int d=0; d<4; d++) {
				int nx = x+di[d];
				int ny = y+dj[d];
				if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny]) {
						if(map[nx][ny]!=num) {
							visited[nx][ny]=true;
							q.offer(new int[] {nx,ny,c+1});
						}
					}
				}
			}	
	}
	

	private static void bfs(int i, int j, int num) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited[i][j] = true;
		q.offer(new int[] {i,j});
		map[i][j]=num;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			
			for(int d=0; d<4; d++) {
				int nx = x+di[d];
				int ny = y+dj[d];
				if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny]) {
					if(map[nx][ny]==1) {
						visited[nx][ny]=true;
						q.offer(new int[] {nx,ny});
						map[nx][ny]=num;
					}
				}
			}
		}
		
	}

}