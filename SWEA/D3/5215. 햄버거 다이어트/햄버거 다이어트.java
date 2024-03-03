import java.io.*;
import java.util.*;

public class Solution {
	
	static int n,l,ans;
	static int[][] g;
	static int[] b;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<t+1; tc++) {
			sb = new StringBuilder();
			// 재료의 수 n, 제한 칼로리 l 이 주어진다. 
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			// n개의 줄에 재료에 대한 민기의 맛에 대한 점수와 칼로리가 주어짐.
			g = new int[n][2];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int score = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				
				g[i]=new int[] {score, k};
			}
			
			// 주어진 제한 칼로리 이하의 조합 중에서 가장 맛에 대한 점수가 높은 햄버거의 점수 출력하기
			ans = Integer.MIN_VALUE;
			// 햄버거 조합을 찾아보자 
			// power set 이용해서 모든 조합을 봐야한다. 
			powerset(-1,0,0);
			
			sb.append("#").append(tc).append(" ").append(ans);
			System.out.println(sb.toString());
		}
		
		br.close();
	}

	static void powerset(int cnt,int score, int k) {
		if(cnt == n-1) {// 모든 조합을 다 보았을 때,
			if(k<=l) {//제한 칼로리 이하의 조합 중 햄버거 점수 최댓값으로 업데이트 
				ans = Math.max(ans, score);
			}
			return;
		}
		
		// 재료 추가 할때
		powerset(cnt+1, score+g[cnt+1][0], k+g[cnt+1][1]);
		
		// 재료 추가 안할 때
		powerset(cnt+1, score, k);
		
	}

}