import java.util.*;

public class Solution {
    public int solution(int n) {
        
        int answer = 0;
        
        String st = n+"";
        
        String[] num = st.split("");
       
        for(int i=0; i<num.length; i++){
            int plus = Integer.parseInt(num[i]);
            answer += plus;
        }
        

        return answer;
    }
}