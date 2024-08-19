import java.io.*;
import java.util.*;
public class Main {
	static int n,c;
	static long[] home;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 집의 개수
		n=Integer.parseInt(st.nextToken());
		// 공유기의 개수
		c=Integer.parseInt(st.nextToken());

		home = new long[n];

		for(int i=0;i<n;i++){
			home[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(home);

		long max = home[n-1] - home[0];
		long min = 1;

		long answer = 0;
		while(min<=max){
			long mid = (min+max)/2;

			long count = install(mid);
			if(count>=c) {
				answer = Math.max(answer,mid);
				min = mid+1;
			}else{
				max = mid-1;
			}
		}

		System.out.println(answer);
		br.close();
	}

	private static long install(long mid) {
		long count = 1;
		long now = home[0];
		for(int i=1;i<n;i++){
			if(home[i]-now>=mid) {
				count++;
				now = home[i];
			}
		}
		return count;
	}
}