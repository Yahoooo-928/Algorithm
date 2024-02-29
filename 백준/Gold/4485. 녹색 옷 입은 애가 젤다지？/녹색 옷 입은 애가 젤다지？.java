import java.io.*;
import java.util.*;

public class Main {
	
	static int[] di= {0,0,1,-1};
	static int[] dj= {1,-1,0,0};
	static int tc=1;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			
			int[][] arr = new int[n][n];
			int[][] dist = new int[n][n];
			boolean[][] v = new boolean[n][n];
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<n ;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					dist[i][j]=Integer.MAX_VALUE;
				}
			}
			// 시작 위치 0,0
			dist[0][0] = arr[0][0];
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{return o1[2]-o2[2];});
			pq.offer(new int[] {0,0,arr[0][0]});
			
			while(!pq.isEmpty()) {
				int[] cur = pq.poll();
				
				int minx = cur[0];
				int miny = cur[1];
				int min = cur[2];
				
				if(v[minx][miny]) continue;
				v[minx][miny] = true;
				if(minx ==n-1 && miny==n-1) break;
				
				for(int d = 0; d<4; d++) {
					int nx = minx + di[d];
					int ny = miny + dj[d];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n && !v[nx][ny] && dist[nx][ny]>min+arr[nx][ny]) {
						dist[nx][ny] = min + arr[nx][ny];
						pq.offer(new int[] {nx,ny, dist[nx][ny]});
					}
				}
				
			}
			
			
			System.out.println("Problem "+(tc++)+": "+dist[n-1][n-1]);
		}
		
		
		br.close();
	}

}
