import java.io.*;
import java.util.*;

public class Main {

	static final int[] di= {-1,0,1,1};
	static final int[] dj= {1,1,0,1};
	static int[][] map = new int[19][19];
	static int result,answer, r,c;
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("Test5.txt"));
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i<19;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<19; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int check =0;
		flag :for(int q=0; q<19; q++) {
			for(int p=0;p<19;p++) {
				if(map[p][q]!=0) {
					result = search(p,q,map[p][q]);
					if(result!=0) {
						check+=1;
						answer=result;
						r = p+1;
						c = q+1;
						break flag;
					}
				}
			}
		}
		if(check!=0) {
			System.out.println(answer);
			System.out.println(r+" "+c);
		}else {
			System.out.println(0);
		}
		br.close();
	}
	
	static int search(int p, int q, int who) {
		for(int i=0; i<4; i++) {
			int count=1;
			int ni = p;
			int nj = q;
			while(true) {
				ni += di[i];
				nj += dj[i];
				if(ni>=0 && nj>=0 && ni<19 && nj<19) {
					if(map[ni][nj]==who) count++;
					else break;
				}else break;
			}
			ni=p;
			nj=q;
			while(true) {
				ni -= di[i];
				nj -= dj[i];
				if(ni>=0 && nj>=0 && ni<19 && nj<19) {
					if(map[ni][nj]==who) count++;
					else break;
				}else break;
			}
			
			if(count==5) {
				return who;
			}
			
		}
		return 0;
	}
}