import java.io.*;
import java.util.*;
class Solution {
    
    public int[] solution(int[] fees, String[] records) throws Exception{
        List<Integer> answer = new ArrayList<>();
        StringTokenizer st;
        int n = records.length;
        
        Map<String,String> hm = new HashMap<>();
        Map<String,Integer> parking = new HashMap<>();
        
        for(int i=0; i<n; i++){
            String s = records[i];
            st = new StringTokenizer(s," ");
            
            String time = st.nextToken();
            String cnum = st.nextToken();
            String inout = st.nextToken();
            
            if(inout.equals("IN")){
                hm.put(cnum,time);
            }else{
                String in_time=hm.get(cnum);
                st = new StringTokenizer(in_time,":");
                
                int hour = Integer.parseInt(st.nextToken());
                int minute=Integer.parseInt(st.nextToken());
                int it = hour*60+minute;
                
                st = new StringTokenizer(time,":");
                
                int ohour = Integer.parseInt(st.nextToken());
                int ominute=Integer.parseInt(st.nextToken());
                int ot = ohour*60+ominute;
                
                int parking_time=ot-it;
                
                if(!parking.containsKey(cnum)){
                    parking.put(cnum,parking_time);
                }else{
                    int t = parking_time+parking.get(cnum);
                    parking.remove(cnum);
                    parking.put(cnum,t);
                }
                
                hm.remove(cnum);
            }
        }
        
        if(hm.size()>0){
            List<String> list = new ArrayList<>(hm.keySet());
            for(String key:list){
                String time=hm.get(key);
                st = new StringTokenizer(time,":");
                
                int hour = Integer.parseInt(st.nextToken());
                int minute=Integer.parseInt(st.nextToken());
                int it = hour*60+minute;
                
                int t = (23*60+59)-it;
                if(!parking.containsKey(key)){
                    parking.put(key,t);
                }else{
                    int t2 = t+parking.get(key);
                    parking.remove(key);
                    parking.put(key,t2);
                }
            }
        }
        
        List<String> pf = new ArrayList<>(parking.keySet());
        Collections.sort(pf);
        
        for(String key:pf){
            int time = parking.get(key);
            if(time<=fees[0]){// 기본시간보다 적게 주차한 경우
                answer.add(fees[1]);
            }else{
                double nt = Math.ceil((double)(time-fees[0])/(double)fees[2])*fees[3];
                answer.add(fees[1]+(int)nt);
            }
        }
        int[] answer2 = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            answer2[i]=answer.get(i);
        }
        return answer2;
    }
}