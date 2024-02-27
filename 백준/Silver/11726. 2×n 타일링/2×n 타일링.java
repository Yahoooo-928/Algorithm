import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] d = new int[1001];
		d[1]=1;
		d[2]=2;
		
		for(int i=3; i<n+1; i++) {
			d[i]=(d[i-2]+d[i-1])%10007;
		}
		
		System.out.println(d[n]);
		br.close();
	}

}
