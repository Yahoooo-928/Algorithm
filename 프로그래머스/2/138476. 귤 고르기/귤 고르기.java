import java.io.*;
import java.util.*;

class Solution {
    
        public int solution(int k, int[] tangerine) throws Exception {
        //귤의 총 갯수
        int N = tangerine.length;
        int answer = 0;
        Arrays.sort(tangerine);
        
        int[] arr = new int[tangerine[N-1]];
        for(int i=0; i<N; i++){
            arr[tangerine[i]-1]++;
        }
        
        //System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        int index = arr.length-1;
        while(true){
            k = k - arr[index];
            answer++;
            index--;
            
            if(k<=0) break;
        }
        
        return answer;
    }
    
    
}