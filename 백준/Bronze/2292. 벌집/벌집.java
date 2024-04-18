import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int sum=0;
		n = n-1;
		
		int i=0;
		int ans=0;
		while(true) {
			sum+= 6*i;
			
			if(n<=sum) {
				ans=i+1;
				break;
			}
			
			i++;
		}
		
		System.out.println(ans);
		
		
		br.close();
	}

}