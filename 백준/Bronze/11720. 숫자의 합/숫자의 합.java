import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		String s = br.readLine();
		for(int i=0; i<n; i++) {
			int a = s.charAt(i)-'0';
			ans+=a;
		}
		
		System.out.println(ans);
		
		br.close();
	}

}