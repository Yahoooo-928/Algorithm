import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] g = new int[n+1][n+1];
		

        for(int i =1; i<n+1; i++) {
            for(int j = 1; j<n+1; j++){
                if(i == j) {
                    g[i][j] = 0;
                    continue;
                }

                g[i][j] = Integer.MAX_VALUE;
            }
        }
		
		
		int[] dist = new int[n+1];
		boolean[] v = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			g[a][b]=Math.min(g[a][b], c);
		}
		
		for(int i=1; i<n+1; i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dist[start] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		pq.offer(new int[] {start,0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int minVertex = cur[0];
	        int min = cur[1];
	        if(v[minVertex]) continue;
	        
	        v[minVertex] = true;
	        if(minVertex == end) break;
	        
			for(int j=1; j<n+1; j++) {
				if(!v[j]&& g[minVertex][j]!=Integer.MAX_VALUE && dist[j] > min+g[minVertex][j]) {
					dist[j] = min+g[minVertex][j];
					pq.offer(new int[] {j,dist[j]});
				}
			}
//			System.out.println(Arrays.toString(dist));
//			System.out.println();
			
		}
		
		System.out.println(dist[end]);
			
		br.close();
	}

}
