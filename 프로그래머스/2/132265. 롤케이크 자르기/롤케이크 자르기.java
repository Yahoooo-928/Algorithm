import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        int answer = 0;
        
        int l = topping.length;
        
        Map<Integer,Integer> tc1 = new HashMap<>();
        Map<Integer,Integer> tc2 = new HashMap<>();
        
        for(int i=0; i<l; i++){
            if(tc1.containsKey(topping[i])){
                int cnt = tc1.get(topping[i]);
                tc1.replace(topping[i],cnt+1);
            }else{
                tc1.put(topping[i],1);
            }
        }
        
        for(int i=0; i<l-1; i++){
            int tp = tc1.get(topping[i]);
            if(tp-1==0){
                tc1.remove(topping[i]);
            }else{
                tc1.replace(topping[i],tp-1);
            }
            
            if(tc2.containsKey(topping[i])){
                int cnt = tc2.get(topping[i]);
                tc2.replace(topping[i],cnt+1);
            }else{
                tc2.put(topping[i],1);
            }
            
            if(tc1.size()==tc2.size()){
                answer++;
            }
            
            
            
        }
        return answer;
    }
}