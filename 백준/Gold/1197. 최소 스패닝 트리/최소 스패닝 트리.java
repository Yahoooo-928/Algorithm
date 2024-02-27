import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parent;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int[][] g = new int[e][3];
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			g[i] = new int[] {a,b,c};
		}
		// 가중치가 낮은 것 부터 오름차순 정렬한다.
		Arrays.sort(g,(o1,o2)->{return o1[2]-o2[2];});
		
		parent = new int[v+1];
		for(int i=1; i<v+1; i++) {
			parent[i] = i;
		}
		long result = 0;
		for(int i=0; i<e; i++) {
			int[] t = g[i];
			if(!union(t[0],t[1])) continue;
			result+=t[2];
		}
		
		System.out.println(result);
		br.close();
	}
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	
	static boolean union(int i, int j) {
		if(find(i)==find(j)) return false;
		parent[find(j)] = find(i);
		return true;
	}

}
