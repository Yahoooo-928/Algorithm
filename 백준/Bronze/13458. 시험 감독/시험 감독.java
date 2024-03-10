import java.io.*;
import java.util.*;
public class Main {
	static long result =0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			arr[i]=arr[i]-b;
			result++;
			if(arr[i]>0) {
				if(arr[i]%c==0) result+=arr[i]/c;
				else result+=(arr[i]/c)+1;
			}
		}
		System.out.println(result);
		br.close();
	}

}