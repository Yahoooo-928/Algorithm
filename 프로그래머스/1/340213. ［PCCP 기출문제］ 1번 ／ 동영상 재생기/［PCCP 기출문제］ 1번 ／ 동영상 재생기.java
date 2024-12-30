import java.io.*;
import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int video = StringtoInt(video_len);
        int p = StringtoInt(pos);
        int start = StringtoInt(op_start);
        int end = StringtoInt(op_end);
        
        int l = commands.length;
        
        for(int i=0; i<l; i++){
            // 현재 오프닝 구간일 때 
            // 오프닝 끝나는 시점으로 이동해서 시작한다. 
            if(start<=p && p<=end){
                p = end;
            }
            
            String comm = commands[i];
            if(comm.equals("next")){
                p += 10;
                if(p>video){
                    p = video;
                }
            }else{//prev일때
                p -=10;
                if(p<0){
                    p = 0;
                }
            }
        }
        
        if(start<=p && p<=end){
            p = end;
        }
        
        int m = p / 60;
        int n = p % 60;
    
        String answer = "";
        
        if(m>10){
            answer = m + ":";
        }else if(m>0){
            answer = "0" + m + ":";
        }else{
            answer = "00:";
        }
        
        if(n>10){
            answer += n;
        }else if(n>0){
            answer += "0" + n;
        }else{
            answer += "00";
        }
        
        
        return answer;
    }
    
    // String 시간을 초로 바꾸어서 int로 변환
    public int StringtoInt(String str){
        StringTokenizer st = new StringTokenizer(str,":");
        
        int m = Integer.parseInt(st.nextToken()) * 60;
        int n = Integer.parseInt(st.nextToken());
        
        return m+n;
        
    }
}