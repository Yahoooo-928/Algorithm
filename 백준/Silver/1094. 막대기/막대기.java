import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		
		int ans=0;
		for(int i=0; i<7; i++) {
			if((x&(1<<i))>0) ans++;
		}
		
		System.out.println(ans);
		br.close();
	}

}