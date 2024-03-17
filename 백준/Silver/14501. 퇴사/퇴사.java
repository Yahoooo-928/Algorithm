import java.io.*;
import java.util.*;

public class Main {
	
	static int n,ans;
	static int[][] arr;
	static boolean[] v;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		v=new boolean[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			arr[i]=new int[] {t,p};
		}
		ans = Integer.MIN_VALUE;
		powerset(0);
		
		System.out.println(ans);
		br.close();
	}

	static void powerset(int cnt) {
		if(cnt == n) {
			int sum = 0;
			int day = 0;
			int check = 0;
			for(int i=0; i<n; i++) {
				if(v[i] && day==0) {
					day = arr[i][0]+i-1;
					sum+=arr[i][1];
				}else if(v[i] && day<i) {
					day = arr[i][0]+i-1;
					sum+=arr[i][1];
				}else if(v[i] && day>=i) {
					check++;
					break;
				}
				if(day>=n) {
					check++;
					break;
				}
			}
			if(check==0) {
				ans = Math.max(sum, ans);
			}
			
			return;
		}
		
		v[cnt]=true;
		powerset(cnt+1);
		
		v[cnt]=false;
		powerset(cnt+1);
	}

}