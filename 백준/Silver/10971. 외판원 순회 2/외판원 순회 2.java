import java.io.*;
import java.util.*;

public class Main{
	
	static int n,ans;
	static int[][] map;
	static int[] b;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			b = new int[n-1];
			v = new boolean[n];
//			System.out.println("start"+i);
			perm(0,i);
		}
		
		System.out.println(ans);
		
		br.close();
	}

	private static void perm(int cnt,int start) {
		if(cnt == n-1) {
			if(isValid(start,b)!=Integer.MAX_VALUE){
				ans = Math.min(ans, isValid(start,b));
			}
			
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(i==start) continue;
			if(v[i]) continue;
			v[i] = true;
			b[cnt] = i;
			perm(cnt+1,start);
			v[i] = false;
		}
	}

	static int isValid(int start, int[] arr) {
		int sum = 0;
		int s = start;
		for(int a:arr) {
			if(map[s][a]!=0) sum+=map[s][a]; 
			else return Integer.MAX_VALUE;
			s=a;
		}
		// 마지막에 다시 start로 돌아갈 수 있는지
		if(map[s][start]!=0) sum+=map[s][start];
		else return Integer.MAX_VALUE;
		return sum;
	}

}
