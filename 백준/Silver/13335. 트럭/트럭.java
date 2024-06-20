import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 트럭의 수 
		int n = Integer.parseInt(st.nextToken());
		// 다리의 길이
		int w = Integer.parseInt(st.nextToken());
		// 다리의 최대 하중
		int l = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Integer> truck = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			truck.offer(Integer.parseInt(st.nextToken()));
		}
		
		int time=0;
		int weight=0;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i=0; i<w; i++) {
			q.offer(0);
		}
		while(!q.isEmpty()) {
			time++;
			weight-=q.poll();

			if(!truck.isEmpty()) {
				if(weight+truck.peek()<=l) {
					weight+=truck.peek();
					q.offer(truck.poll());
				}else {
					q.offer(0);
				}
			}
			
		}
		
		System.out.print(time);
		br.close();
	}

}