import java.io.*;
import java.util.*;
public class Main {
	
	static int n,m,ans;
	static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		//mxn 크기의 보드임!
		map = new char[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j]=s.charAt(j);
			}
		}
		
		// 다시 칠해야하는 정사각형 개수의 최솟값 찾기
		ans = Integer.MAX_VALUE;
		
		// 8X8 크기를 떼와서 색 다시 칠하는 판 갯수 계속 업데이트 해주기 
		for(int i=0; i<=n-8; i++) {
			for(int j=0; j<=m-8; j++) {
				search(i,j);
			}
		}
		
		System.out.println(ans);
		
		br.close();
	}
	
	static void search(int x, int y) {
		// 맨 왼쪽 위 체스판 색깔
		char color = map[x][y];
		
		int cnt = 0;
		// ex, 짝수는 검흰검흰 홀수는 흰검흰검
		for(int i=x; i<x+8; i+=2) {
			for(int j=y; j<y+8; j+=2) {
				if(map[i][j]!=color) cnt++;
			}
			for(int j=y+1; j<y+8; j+=2) {
				if(map[i][j]==color) cnt++;
			}
		}
		
		for(int i=x+1; i<x+8; i+=2) {
			for(int j=y; j<y+8; j+=2) {
				if(map[i][j]==color) cnt++;
			}
			for(int j=y+1; j<y+8; j+=2) {
				if(map[i][j]!=color) cnt++;
			}
		}
		
		ans = Math.min(cnt, ans);
		
		cnt = 0;
		// ex, 짝수는 검흰검흰 홀수는 흰검흰검
		for(int i=x; i<x+8; i+=2) {
			for(int j=y; j<y+8; j+=2) {
				if(map[i][j]==color) cnt++;
			}
			for(int j=y+1; j<y+8; j+=2) {
				if(map[i][j]!=color) cnt++;
			}
		}
		
		for(int i=x+1; i<x+8; i+=2) {
			for(int j=y; j<y+8; j+=2) {
				if(map[i][j]!=color) cnt++;
			}
			for(int j=y+1; j<y+8; j+=2) {
				if(map[i][j]==color) cnt++;
			}
		}
		
		ans = Math.min(cnt, ans);
	}
}