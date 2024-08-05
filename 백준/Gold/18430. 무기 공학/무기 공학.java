import java.io.*;
import java.util.*;
public class Main {
	static int n,m,answer;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 나무재료의 세로, 가로 n,m
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		v = new boolean[n][m];
		answer = Integer.MIN_VALUE;
		
		boomerang(0,0);
		
		System.out.println(answer);
		
		br.close();
	}
	
	static void boomerang(int index, int result) {
		// 부메랑 만들 수 있는 모든 경우 완탐.
		// 모든 인덱스를 다 돌았을 때, 강도의 합을 비교한다. 
		if(index==n*m) {
			answer = Math.max(result, answer);
			return;
		}
		
		int x = index/m;
		int y = index%m;
		
		if(!v[x][y]) {
			if(y-1>=0 && x+1<n && !v[x][y-1] && !v[x+1][y]) {
				v[x][y]=true;
				v[x][y-1]=true;
				v[x+1][y]=true;
				boomerang(index+1,result+(map[x][y]*2)+map[x][y-1]+map[x+1][y]);
				v[x][y]=false;
				v[x][y-1]=false;
				v[x+1][y]=false;
			}
			if(x-1>=0 && y-1>=0 && !v[x-1][y] && !v[x][y-1]) {
				v[x][y]=true;
				v[x-1][y]=true;
				v[x][y-1]=true;
				boomerang(index+1,result+(map[x][y]*2)+map[x-1][y]+map[x][y-1]);
				v[x][y]=false;
				v[x-1][y]=false;
				v[x][y-1]=false;
			}
			if(x-1>=0 && y+1<m && !v[x-1][y] && !v[x][y+1]) {
				v[x][y]=true;
				v[x][y+1]=true;
				v[x-1][y]=true;
				boomerang(index+1,result+(map[x][y]*2)+map[x][y+1]+map[x-1][y]);
				v[x][y]=false;
				v[x][y+1]=false;
				v[x-1][y]=false;
			}
			if(y+1<m && x+1<n && !v[x][y+1] && !v[x+1][y]) {
				v[x][y]=true;
				v[x][y+1]=true;
				v[x+1][y]=true;
				boomerang(index+1,result+(map[x][y]*2)+map[x][y+1]+map[x+1][y]);
				v[x][y]=false;
				v[x][y+1]=false;
				v[x+1][y]=false;
			}
		}
		boomerang(index+1,result);
	}
	
	
}