import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		//오영식이 이미 가지고 있는 랜선의 개수 
		int k = Integer.parseInt(st.nextToken());
		//필요한 랜선의 개수
		int n = Integer.parseInt(st.nextToken());
		// 오영식이 가지고 있는 랜선의 길이 저장 배열
		int[] lan = new int[k];
		
		// 오영식이 가지고 있는 랜선 중 가장 긴 것을 구한다. 
		int max = Integer.MIN_VALUE;
		for(int i=0; i<k; i++) {
			int l = Integer.parseInt(br.readLine());
			lan[i]=l;
			max=Math.max(max, l);
		}
		
		// 짧은 랜선을 기준으로 이분탐색 
		long s = 1;
		long e = max;
		// 랜선이 하나이고 필요한 랜선 개수도 1개일 경우 
		long ans = max;
		while(s<=e) {
			long mid = (s+e)/2;
			
			long sum = 0; // mid 길이의 랜선으로 만들수 있는 랜선의 개수 
			for(int i=0; i<k; i++) {
				sum+=(lan[i]/mid);
			}
			if(sum<n) {
				e=mid-1;
			}else {
				s=mid+1;
				ans = mid;
			}
		}
		
		System.out.println(ans);
		br.close();
	}

}