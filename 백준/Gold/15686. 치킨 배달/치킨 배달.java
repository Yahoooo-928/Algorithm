import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M,min;
	static int[][] home,chicken;
	static int[] b;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
//		city = new int[N][N];
		chicken = new int[13][2];
		home = new int[2*N][2];
		min = Integer.MAX_VALUE;
		
		int idx=0;
		int idx1=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				int city =Integer.parseInt(st.nextToken());
				if(city==2) {
					chicken[idx][0]=i;
					chicken[idx][1]=j;
					idx++;
				}else if(city==1) {
					home[idx1][0]=i;
					home[idx1][1]=j;
					idx1++;
				}
			}
		}
		chicken = Arrays.copyOf(chicken, idx);
		home = Arrays.copyOf(home, idx1);
		
		b = new int[M];
		comb(0,0);
		
		System.out.println(min);
//		for(int[] a:chicken)System.out.println(Arrays.toString(a));
//		for(int[] a:home)System.out.println(Arrays.toString(a));
		br.close();
	}

	static void comb(int cnt, int start) {
		if(cnt == M) {
			int street =0;
			for(int i=0; i<home.length; i++) {
				int x = home[i][0];
				int y = home[i][1];
				int cs = Integer.MAX_VALUE;
				for(int j=0; j<b.length; j++) {
					int x1 = chicken[b[j]][0];
					int y1 = chicken[b[j]][1];
					
					cs = Math.min(cs,Math.abs(x1-x)+Math.abs(y1-y));
				}
				street+=cs;
			}
			min = Math.min(min, street);
			
			return;
		}
		
		for(int i=start; i<chicken.length; i++) {
			b[cnt]=i;
			comb(cnt+1,i+1);
		}
	}

}
