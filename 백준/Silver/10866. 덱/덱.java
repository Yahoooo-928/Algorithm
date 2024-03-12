import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String s = st.nextToken();
			if(s.equals("push_front")) {
				int num = Integer.parseInt(st.nextToken());
				q.offerFirst(num);
			}else if(s.equals("push_back")) {
				int num = Integer.parseInt(st.nextToken());
				q.offer(num);
			}else if(s.equals("pop_front")) {
				if(q.size()==0) System.out.println(-1);
				else {
					System.out.println(q.poll());
				}
			}else if(s.equals("pop_back")) {
				if(q.size()==0) System.out.println(-1);
				else {
					System.out.println(q.pollLast());
				}
			}else if(s.equals("size")) {
				System.out.println(q.size());
			}else if(s.equals("empty")) {
				if(q.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}else if(s.equals("front")) {
				if(q.size()==0) System.out.println(-1);
				else {
					System.out.println(q.peek());
				}
			}else if(s.equals("back")) {
				if(q.size()==0) System.out.println(-1);
				else {
					System.out.println(q.peekLast());
				}
			}
		}
		
		br.close();
	}

}