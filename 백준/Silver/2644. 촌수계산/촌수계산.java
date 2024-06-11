import java.io.*;
import java.util.*;
public class Main {
	static int n,b,answer;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 촌수를 계산해야하는 서로 다른 두사람의 번호
		int a =Integer.parseInt(st.nextToken()); 
		b =Integer.parseInt(st.nextToken()); 
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			arr[s][p]= 1;
			arr[p][s]= 1;
		}
		visited = new boolean[n+1];
		bfs(a);
		
		System.out.println(answer);
		br.close();
	}
	
	static void bfs(int a) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {a,0});
		visited[a]=true;

		answer = 0;
		while(!q.isEmpty()) {
			int[] num = q.poll();
			if(num[0]==b) {
				answer = num[1];
			}
			
			for(int i=1; i<=n; i++) {
				if(arr[num[0]][i]==1 && !visited[i]) {
					q.offer(new int[] {i,num[1]+1});
					visited[i]=true;
				}
			}
			
		}
		
		if(answer==0) answer=-1;
	}

}