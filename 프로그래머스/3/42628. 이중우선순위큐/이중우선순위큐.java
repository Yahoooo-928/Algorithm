import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(String[] operations) throws Exception{
        int n = operations.length;
        
        PriorityQueue<Integer> qmax = new PriorityQueue<>((o1,o2)->{return o2-o1;});
        PriorityQueue<Integer> qmin = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            String a = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            
            if(a.equals("I")){
                qmax.offer(b);
                qmin.offer(b);
            }else if(a.equals("D")&&!qmin.isEmpty()&&!qmax.isEmpty()){
                if(b==1){
                    int max = qmax.poll();
                    qmin.remove(max);
                }else if(b==-1){
                    int min=qmin.poll();
                    qmax.remove(min);
                }
            }
        }
        int[] answer=new int[2];
        if(!qmax.isEmpty()){
            answer[0]=qmax.poll();
            answer[1]=qmin.poll();
        }
        
        
        return answer;
    }
}