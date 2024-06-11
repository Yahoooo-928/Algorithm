import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if(order.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			}else if(order.equals("pop")){
				if(stack.isEmpty()) System.out.println(-1);
				else {
					int num = stack.pop();
					System.out.println(num);
				}
			}else if(order.equals("size")) {
				int size = stack.size();
				System.out.println(size);
			}else if(order.equals("empty")) {
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}else if(order.equals("top")) {
				if(stack.isEmpty()) System.out.println(-1);
				else {
					int num = stack.peek();
					System.out.println(num);
				}
			}
		}
		
		
		
		br.close();
	}

}