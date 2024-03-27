import java.io.*;
import java.util.*;
public class Main {
	
	static int[][] map=new int[9][9];
	static boolean flag;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			String s = br.readLine();
			for(int j=0; j<9; j++) {
				map[i][j]= s.charAt(j)-'0';
			}
		}
		
		dfs(0);
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	
		br.close();
	}
	static void dfs(int depth) {
		if(depth==81) {
			flag = true;
			return;
		}
	
		int r = depth/9;
		int c = depth%9;
		
		if(map[r][c]!=0)
			dfs(depth+1);
		else {
			for(int i=1;i<10;i++) {
				if(!isValid(r,c,i))continue;
				map[r][c] = i;
				dfs(depth+1);
				
		
				if(flag) return;
				map[r][c]=0;
				
			}
		}
	}
	
	private static boolean isValid(int r, int c, int n) {
		
		for(int i=0;i<9;i++) {
			if(map[i][c]==n || map[r][i]==n) return false;
		}

		int sr = r/3 * 3;
		int sc = c - c%3;
		for(int row=sr;row<sr+3;row++) {
			for(int col=sc;col<sc+3;col++) {
				if(map[row][col]==n) return false;
			}
		}
		
		
		return true;
		
	}
}