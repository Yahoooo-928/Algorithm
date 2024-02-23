import java.io.*;
import java.util.*;

public class Main {
	
	static int n,d,k,c,ans;
	static int[] rice; // 회전초밥 벨트에 있는 초밥들
	static int[] v; // 초밥 종류 배열 , 초밥먹었는지 안먹었는지 확인
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		rice = new int[n];
		for(int i=0; i<n; i++) {
			rice[i] = Integer.parseInt(br.readLine());
		}
		v = new int[d+1];
		ans =1;// 쿠폰으로 초밥은 무조건 먹으니까 최솟값 1
		v[c]++;
		for(int i=0; i<k; i++) {// 처음 k개
			v[rice[i]]++; // 먹은 초밥 갯수 표시
			if(v[rice[i]]==1) ans++; // 1개일때 갯수 count
		}
		
		int result = Integer.MIN_VALUE;
		for(int i=1; i<n; i++) {
			// 지나간 초밥 빼기 
			v[rice[i-1]]--;
			if(v[rice[i-1]]==0) ans--;
			
			// 새로운 초밥 추가
			v[rice[(i+(k-1))%n]]++;
			if(v[rice[(i+(k-1))%n]]==1) ans++;
			
			result = Math.max(ans, result);
		}
		
		System.out.println(result);
		br.close();
	}

}
