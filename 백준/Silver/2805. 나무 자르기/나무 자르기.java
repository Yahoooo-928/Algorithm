import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        // 나무의 수 
        int n = Integer.parseInt(st.nextToken());
        // 상근이가 집으로 가져가려고 하는 나무의 길이 
        int m = Integer.parseInt(st.nextToken());
        
        int[] tree = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        // 제일 긴 나무를 구하자 
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            tree[i]=Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }
        
        //제일 긴 나무 기준 절단기 높이 이분탐색 하자 
        long s =1;
        long e = max;
        long ans = 0;
        
        while(s<=e) {  
            long mid = (s+e)/2;
            
            long sum = 0;
            for(int i=0; i<n; i++) {
                if(tree[i]>mid) {
                    sum+=tree[i]-mid;
                }
            }
            
            if(sum<m) {
                e=mid-1;
            }else {
            	s=mid+1;
                ans=mid;
            }
        }
        
        System.out.println(ans);
        br.close();
    }

}