import java.io.*;
import java.util.*;
public class Solution {
	
	static int v,e;
	static int[] parent;
	static int[][] g;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<T+1; tc++) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine()," ");
			
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			g = new int[e][3];
			for(int i=0; i<e; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				g[i] = new int[] {a,b,weight};
			}
			// weight 기준 오름차순 정렬하기
			Arrays.sort(g,(o1,o2)->Integer.compare(o1[2], o2[2]));
			// 부모 root 셋팅해주기
			parent = new int[v+1];
			for(int i=1; i<v+1; i++) {
				parent[i]=i;
			}
			
			long result =0; 
			int cnt = 0;
			for(int[] edge:g) {
				if(union(edge[0],edge[1])) { // union가능하다면
					result+=edge[2];
					if(++cnt == v-1) break; // 모든 정점을 연결했다면 break
				}
			}
			sb.append("#").append(tc).append(" ").append(result);
			System.out.println(sb.toString());
		}
		br.close();
	}

	static boolean union(int i, int j) {
		if(find(i)==find(j)) return false;
		
		parent[find(j)]=find(i);
		return true;
	}
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x]= find(parent[x]);
	}
}

