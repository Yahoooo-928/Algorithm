import java.io.*;
import java.util.*;
public class Solution {
    
    static int n, w, h, ans;
    static int[][] map;
    static int[] di= {1,-1,0,0};
    static int[] dj= {0,0,1,-1};
    static int[] b;
    public static void main(String[] args)throws Exception {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<T+1; tc++) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            b= new int[n];
            map = new int[h][w];
            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine()," ");
                // 0은 빈공간 나머지 숫자는 벽돌
                for(int j=0; j<w; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            // 남은 벽돌의 갯수가 최소인 경우를 구하라
            // 최대한 많은 벽돌을 제거하는 경우
            ans = Integer.MAX_VALUE;
            
            perm(0); 
            
            sb.append("#").append(tc).append(" ").append(ans);
            System.out.println(sb.toString());
        }
        br.close();
    }

    static void perm(int cnt) {
        if(cnt==n) { // 구술을 n번 다 쳤을 때 남은 벽돌 수를 return 
        	int[][] t = CopyOf(map);
        	for(int p=0; p<n; p++) {
        		for(int q=0; q<h; q++) {
        			if(t[q][b[p]]!=0) {
        				t= CopyOf(removeWall(q,b[p],t));
//        				if(b[0]==2 && b[1]==2 && b[2]==6) {
//        					for(int[] a:t)System.out.println(Arrays.toString(a));
//        					System.out.println();
//        				}
        				break;
        			}
        		}
        	}
        	
        		
        	int bw = leftb(t);
        
            ans = Math.min(ans,bw);
            return;
        }
        
       for(int i=0; i<w; i++) {
    	   b[cnt]=i;
    	   perm(cnt+1);
       }
    }

    static int[][] CopyOf(int[][] temp) {
        int[][] b = new int[h][w];
        
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                b[i][j]=temp[i][j];
            }
        }
        return b;
    }

    static int leftb(int[][] new_temp) {
        int count=0;
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(new_temp[i][j]!=0) count++;
            }
        }
        return count;
    }

    static int[][] removeWall(int i, int j, int[][] temp) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[] {i,j,temp[i][j]});
        temp[i][j]=0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int k=1; k<cur[2]; k++) {
                for(int d=0; d<4; d++) {
                    int nx = cur[0]+di[d]*k;
                    int ny = cur[1]+dj[d]*k;
                    if(nx>=0 && nx<h && ny>=0 && ny<w && temp[nx][ny]!=0) {
                        q.offer(new int[] {nx,ny,temp[nx][ny]});
                        temp[nx][ny]=0; // 터진 부분 0으로 바꾸기 
                    }
                }
            }
        }
       
        //빈 부분 아래로 다 내려주기 
        for(int b=0; b<w; b++) {
            int zero = 0;
            for(int a=h-1; a>=0; a--) {
                if(temp[a][b]==0) {
                    zero++;
                }else{
                    int g = temp[a][b];
                    temp[a+zero][b] =g;
//                    temp[a][b]=0;
                }
            }
            for(int k=0; k<zero; k++) { // 밀려서 빈부분은 0으로 채워주기 
            	temp[k][b]=0;
            }
        }
//        for(int[] a:temp) System.out.println(Arrays.toString(a));
        return temp;
    }

}