import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			int j = Integer.parseInt(br.readLine());
			list.add(j);
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i:list) {
			sb.append(i);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}

}