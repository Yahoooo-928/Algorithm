import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String name = st.nextToken();
			String inout = st.nextToken();
			if(inout.equals("enter")) {
				hm.put(name, 1);
			}else {
				hm.remove(name);
			}
		}
		
		ArrayList<String> list = new ArrayList<String>(hm.keySet());
		Collections.sort(list,Collections.reverseOrder());
		
		for(String s:list) {
			System.out.println(s);
		}
		
		br.close();
	}

}