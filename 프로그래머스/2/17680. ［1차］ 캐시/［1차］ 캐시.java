import java.io.*;
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayDeque<String> q = new ArrayDeque<>();
        int answer = 0;
        
        int l = cities.length;
        for(int i=0; i<l; i++){
            String city = cities[i].toUpperCase();
            if(q.contains(city)){
                q.remove(city);
                q.offer(city);
                answer+=1;
            }else{
                q.offer(city);
                answer+=5;
            }
            
            if(q.size()>cacheSize){
                q.poll();
            }
        }
        return answer;
    }
}