import java.io.*;
import java.util.*;
public class Main {
	static int n,r,c,answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		// r행 c열을 몇번째로 방문했는지 출력
		// 분할정복
		// r,c 가 몇 사분면에 존재하는지 확인하고 그 부분만 재귀 
		int num = (int)Math.pow(2, n);
		answer = 0;
		dfs(r,c,num);
		System.out.println(answer);
		br.close();
	}
	static void dfs(int x, int y, int size) {
		if(size==1) {
			return;
		}
		
		int nsize = size/2;
		
		// 호출해 줄때 r과 c의 위치를 0,0에서 시작한 것처럼 호출한다. 
		// 각각을 또 다시 나누었을 때 위치를 파악하기 위해서
		if(x<nsize && y<nsize) {
			dfs(x,y,nsize);
		}else if(x<nsize && y>=nsize) {
			answer += (nsize*nsize);
			dfs(x,y-nsize,nsize);
		}else if(x>=nsize && y<nsize) {
			answer += (nsize*nsize)*2;
			dfs(x-nsize,y,nsize);
		}else if(x>=nsize && y>=nsize) {
			answer += (nsize*nsize)*3;
			dfs(x-nsize,y-nsize,nsize);
		}
		
	}
}