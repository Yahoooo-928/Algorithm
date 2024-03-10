import java.io.*;
import java.util.*;
public class Main {
	static int result = 0;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] matrix = new int[n+1][n+1];
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			matrix[a][b]=1;
			matrix[b][a]=1;
		}
		boolean[] v = new boolean[n+1];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[1]=true;
		q.offer(1);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=1; i<n+1; i++) {
				if(matrix[cur][i]==1 && !v[i]) {
					v[i]=true;
					q.offer(i);
					result++;
				}
			}
		}
		System.out.println(result);
		br.close();
	}

}