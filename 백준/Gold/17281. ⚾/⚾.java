import java.io.*;
import java.util.*;
public class Main {
	
	static int n,score;
    static int[][] baseball;
    static int[] b;
    static boolean[] v;
    // 얻을 수 있는 최대 점수 출력하기 
    // 1번 선수는 4번타자로 미리 결정되어 있음. 
    // 다른 선수들의 타순을 결정해야한다. 
    // 가장 많은 득점을 하는 타순 찾기 
    public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
         
         baseball = new int[n][9];
         
         for(int i=0; i<n; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine()," ");
             for(int j=0; j<9; j++) {
                 baseball[i][j]= Integer.parseInt(st.nextToken());
             }
         }
         
         b = new int[9];
         v = new boolean[9];
         v[3]=true;
         score = Integer.MIN_VALUE;
         perm(1);
//         b = new int[] {1,2,3,0,4,5,6,7,8};
//         int result = startbaseball(b);
         System.out.println(score);
         
         br.close();
    }
    static void perm(int cnt) {
        if(cnt == 9) {
        	// b 배열에 든 타자의 타순으로 n번의 이닝을 진행한다.
        	int result = startbaseball();
        	score = Math.max(result, score);
            return;
        }
        
        for(int i=0; i<9; i++) {
            if(v[i]) continue;
            v[i] = true;
            
            b[i]=cnt;
            perm(cnt+1);
            
            v[i]=false;
        }
    }
	static int startbaseball() {
		int s = 0; // 이닝 횟수
		int score = 0;// 점수
		int i =0;
		while(s<n) {
			int zero = 0; //아웃된 수 3아웃이면 이닝 종료
			int[] ru = new int[3]; // 진루한 위치 
			while(zero<3) {
				int[] update = new int[3]; // 새로 움직인 위치
				if(baseball[s][b[i]]==0) { //아웃
					zero++;
				}else if(baseball[s][b[i]]==1) {//안타
					update[0]++;
					for(int j=0; j<3; j++) {
						if(ru[j]!=0) {
							if(j+1>=3) score++;
							else update[j+1]++;
						}
					}
					ru=update;
				}else if(baseball[s][b[i]]==2) {//2루타
					update[1]++;
					for(int j=0; j<3; j++) {
						if(ru[j]!=0) {
							if(j+2>=3) score++;
							else update[j+2]++;
						}
					}
					ru=update;
				}else if(baseball[s][b[i]]==3) {//3루타
					update[2]++;
					for(int j=0; j<3; j++) {
						if(ru[j]!=0) {
							score++;
						}
					}
					ru=update;
				}else if(baseball[s][b[i]]==4) {//홈런
					score++;
					for(int j=0; j<3; j++) {
						if(ru[j]!=0) {
							score++;
						}
					}
					ru=new int[3];
				}
				
				i++;
				if(i==9) i=0;
				
			}
			s++;
		}
		
		return score;
	}

}