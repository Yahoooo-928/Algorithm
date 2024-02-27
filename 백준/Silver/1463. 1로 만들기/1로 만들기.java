import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		
		int[] d = new int[1000005];
		d[1]=0;
		for(int i =2; i<=x; i++) {
			d[i]=d[i-1]+1;
			if(i%2==0) d[i] = Math.min(d[i], d[i/2]+1);
			if(i%3==0) d[i] = Math.min(d[i], d[i/3]+1);
		}
//		System.out.println(Arrays.toString(d));
		System.out.println(d[x]);
		
		br.close();
	}

}
