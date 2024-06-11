import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if(order.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				queue.offer(num);
			}else if(order.equals("pop")){
				if(queue.isEmpty()) System.out.println(-1);
				else {
					int num = queue.poll();
					System.out.println(num);
				}
			}else if(order.equals("size")) {
				int size = queue.size();
				System.out.println(size);
			}else if(order.equals("empty")) {
				if(queue.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}else if(order.equals("front")) {
				if(queue.isEmpty()) System.out.println(-1);
				else {
					int num = queue.peek();
					System.out.println(num);
				}
			}else if(order.equals("back")) {
				if(queue.isEmpty()) System.out.println(-1);
				else {
					int num = queue.peekLast();
					System.out.println(num);
				}
			}
		}
		
		
		
		br.close();
	}

}