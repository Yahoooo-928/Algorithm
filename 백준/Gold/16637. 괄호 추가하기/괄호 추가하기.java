import java.io.*;
import java.util.*;

public class Main {
	
	static int n,ans;
	static char[] c;
	static String s;
	// 괄호를 적절히 추가해 만들 수 있는 식의 결과의 최댓값 구하기
	// 괄호 갯수 제한 없고, 추가 안해도 됨.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 수식의 길이 n, 항상 홀수
		n = Integer.parseInt(br.readLine());
		s = br.readLine();
		
		c=new char[n];
		for(int i=0; i<n; i++) {
			c[i] = s.charAt(i);
		}
		
		ans = Integer.MIN_VALUE;
		dfs(2,c[0]-'0');
		
		System.out.println(ans);
		
		br.close();
	}
	static void dfs(int cnt, int sum) {
		// 괄호를 추가하는 경우 안하는 경우 두가지로 완탐
		if(cnt >= n) {
			ans = Math.max(ans, sum);
			return;
		}
		
		// 괄호 추가 안하는 경우 
		dfs(cnt+2,calculate(sum,c[cnt]-'0',c[cnt-1]));
		// 괄호 추가하는 경우 // 맨앞에 처음 0,1,2 번째 수식은 괄호 하나 안하나 똑같
		if(cnt+2<n) {
			int s = calculate(c[cnt]-'0',c[cnt+2]-'0',c[cnt+1]);
			int total = calculate(sum, s, c[cnt-1]);
			dfs(cnt+4, total);
		}
		
	}
	static int calculate(int sum, int s2, char sep) {
		if(sep=='+') {
			return sum+s2;
		}else if(sep=='-') {
			return sum-s2;
		}
		return sum*s2;
	}

}