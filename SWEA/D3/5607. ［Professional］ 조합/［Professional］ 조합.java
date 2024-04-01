import java.io.*;
import java.util.*;
public class Solution {
	
	static int n,r;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<T+1; tc++) {
			StringBuilder sb = new StringBuilder();
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			long ans = nCr(n,r,1234567891);
			
			sb.append("#").append(tc).append(" ").append(ans);
			System.out.println(sb.toString());
		}
		br.close();
	}
	
	static long nCr(int n, int r, int p) {
		if(r==0) return 1L;
		
		long[] fac = new long[n+1];
		fac[0]=1;
		
		for(int i=1; i<=n; i++) {
			fac[i]=fac[i-1]*i%p;
		}
		
		return (fac[n]* power(fac[r],p-2,p)% p* power(fac[n-r],p-2,p)%p)%p;
	}

	static long power(long x, int y, int p) {
		long res = 1L;
		while(y>0){
			if(y%2==1) {
				res = (res*x)%p;
			}
			y= y>>1; //y, y/2
			x=(x*x)%p;
		}
		return res;
	}
}