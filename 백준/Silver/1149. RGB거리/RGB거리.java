import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] r = new int[1001];
		int[] g = new int[1001];
		int[] b = new int[1001];
		for(int i=1; i<n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			r[i]=Integer.parseInt(st.nextToken());
			g[i]=Integer.parseInt(st.nextToken());
			b[i]=Integer.parseInt(st.nextToken());
		}
		
		int[][] d = new int[1001][3];
		d[1][0]=r[1];
		d[1][1]=g[1];
		d[1][2]=b[1];
		
		for(int i=2; i<n+1; i++) {
			d[i][0] = Math.min(d[i-1][1], d[i-1][2])+r[i];
			d[i][1] = Math.min(d[i-1][0], d[i-1][2])+g[i];
			d[i][2] = Math.min(d[i-1][0], d[i-1][1])+b[i];
		}
		int min = d[n][0];
		for(int i=1; i<3; i++) {
			if(d[n][i]<min) {
				min = d[n][i];
			}
		}
		
		System.out.println(min);
		br.close();
		
	}

}
