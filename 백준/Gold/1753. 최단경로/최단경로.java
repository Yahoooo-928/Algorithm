import java.io.*;
import java.util.*;

// 다익스트라 => 인접리스트로 풀어봄
public class Main {
	
	static List<int[]>[] list;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(br.readLine());
		
		list = new List[v+1];
		for(int i=1; i<v+1; i++) list[i]=new ArrayList<>();
		int[] dist = new int[v+1];
		// 최소경로 저장 배열 => 최댓값으로 초기화해주기 
		for(int i=1; i<v+1; i++) dist[i] = Integer.MAX_VALUE;
		
		// 정점 방문 표시 배열 
		boolean[] visited = new boolean[v+1];
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new int[] {b,c});
		}
		
		// 시작 정점 k
		dist[k] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{return o1[1]-o2[1];});
		
		pq.offer(new int[] {k,0});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int minVertex = cur[0];
			int min = cur[1];
			
			if(visited[minVertex]) continue;
			visited[minVertex] = true;
			
			for(int[] now: list[minVertex]) {
				if(!visited[now[0]] && dist[now[0]]>min+now[1]) {
					dist[now[0]] = min+now[1];
					pq.offer(new int[] {now[0],dist[now[0]]});
				}
			}
			
		}
		
		for(int i=1; i<v+1; i++) {
			if(dist[i]!=Integer.MAX_VALUE) {
				System.out.println(dist[i]);
			}else System.out.println("INF");
		}
		
		br.close();
	}

}
