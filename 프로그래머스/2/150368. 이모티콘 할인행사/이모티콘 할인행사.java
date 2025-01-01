import java.io.*;
import java.util.*;
class Solution {
    static int n,m;
    static int[] discount = {10,20,30,40};
    static int[] etc,b;
    static PriorityQueue<int[]> pq;
    static int[][] ur;
    static boolean[] v;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        n = users.length;
        m = emoticons.length;
        
        etc = new int[m];
        
        for(int i=0; i<m; i++){
            etc[i] = emoticons[i];
        }
        
        ur = new int[n][2];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                ur[i][j] = users[i][j];
            }
        }
        
        b = new int[m];
        pq = new PriorityQueue<>((o1,o2)->{
            if(o1[0]==o2[0]){
                return o2[1] - o1[1];
            }else{
                return o2[0] - o1[0];
            }
        });
        v = new boolean[4];
        perm(0);
    
        
        return pq.poll();
    }
    
    public void perm(int cnt){
        if(cnt == m){
            //System.out.println(Arrays.toString(b));
            
            // 이모티콘 플러스 사는 사람의 수 
            int people = 0;
            // 이모티콘 판매액
            int money = 0;
            // 이모티콘 할인율
            int[] dc = new int[m];
            for(int i=0; i<m; i++){
                dc[i] = b[i];
            }
            
            for(int i=0; i<n; i++){
                int balance = ur[i][0];
                int pay = ur[i][1];
                // 총 구입비용
                int total = 0;
                for(int j=0; j<m; j++){
                    if(balance<=dc[j]){ // 이모티콘 구매 하는 경우 
                        total += (etc[j]*((100-dc[j])*0.01));
                        //System.out.println(total);
                    }
                }
                
                if(total >= pay){ // 이모티콘 플러스 서비스에 가입하는 경우 
                    people += 1;
                }else{
                    money += total;
                }
            }
            
            //System.out.println(people+":"+money);
            pq.offer(new int[]{people, money});
            return;
        }
        
        for(int i=0; i<4; i++){
            
            b[cnt] = discount[i];
            perm(cnt+1);
            
        }
    }
}