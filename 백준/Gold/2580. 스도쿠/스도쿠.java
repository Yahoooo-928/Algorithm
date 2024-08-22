import java.io.*;
import java.util.*;
public class Main {
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		
		StringTokenizer st;
		
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		start(0,0);
		
		br.close();
	}
	static void start(int i, int j) {
		// 한 행에 모든 열을 검사 했다면
		// 다음 행으로 넘어가도록
		if(j==9) {
			start(i+1,0);
			return;
		}
		// 모든 행열을 다 검사했다면 !!
		// 출력하고 끝내자 
		if(i==9) {
			StringBuilder sb = new StringBuilder();
			
			for(int p=0; p<9; p++) {
				for(int q=0; q<9; q++) {
					sb.append(map[p][q]).append(" ");
				}
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
			System.exit(0);
		}
		
		if(map[i][j]==0) {
			for(int a=1; a<=9; a++) {
				// a 숫자가 빈칸에 들어갈 수 있다면
				if(isPossible(i,j,a)) {
					map[i][j] = a;
					start(i,j+1);
				}
			}
			map[i][j]=0;
			return;
		}
		start(i,j+1);
	}
	
	static boolean isPossible(int i, int j, int a) {
		// 같은 행에 겹치는 숫자가 있는지 검사
		for(int p=0; p<9; p++) {
			if(map[i][p]==a) return false;
		}
		// 같은 열에 겹치는 숫자가 있는지 검사
		for(int q=0; q<9; q++) {
			if(map[q][j]==a) return false;
		}
		
		// 3x3 칸에 숫자가 있는지 검사 
		int x = (i/3)*3;
		int y = (j/3)*3;
		
		
		for(int xx=x; xx<x+3; xx++) {
			for(int yy=y; yy<y+3; yy++) {
				if(map[xx][yy]==a) {
					return false; 
				}
			}
		}
			
		
		return true;
	}

}