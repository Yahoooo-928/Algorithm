import java.io.*;
import java.util.*;


class Solution {
    
    private int ban_cnt,user_cnt,answer;
    private String[] users;
    private String[] ban_user;
    private boolean[] v;
    private String[] choice;
    private ArrayList<String>[] list;
    
    public int solution(String[] user_id, String[] banned_id) {
        
        answer = 0;
        
        user_cnt = user_id.length;
        ban_cnt = banned_id.length;
        
        this.ban_user = banned_id;
        this.users = user_id;
        
        v = new boolean[user_cnt];
        choice = new String[ban_cnt];
        
        list = new ArrayList[100];
        for(int i=0; i<100; i++){
            list[i] = new ArrayList<String>();
        }
        perm(0);
        
        for(int i=0; i<100; i++){
            if(list[i].size()>0) answer++;
            else break;
        }
        return answer;
    }
    
    public void perm(int cnt){
        
        if(cnt == ban_cnt){
            String[] temp = new String[ban_cnt];
            for(int t=0; t<ban_cnt; t++){
                temp[t] = choice[t];
            }
            
            int result = 0;
            for(int b=0; b<ban_cnt; b++){
                if(temp[b].length()==ban_user[b].length()){
                    int l = temp[b].length();
                    int count = 0;
                    for(int d=0; d<l; d++){
                        if(ban_user[b].charAt(d)!='*'){
                            if(ban_user[b].charAt(d)==temp[b].charAt(d)) count++;
                        }else{
                            count++;
                        }
                    }
                    
                    if(count == l){
                        result++;
                    }
                }
            }
            
            if(result == ban_cnt){
                //System.out.println(Arrays.toString(choice));
                for(int k=0; k<100; k++){
                    if(list[k].size()==0){
                        for(int c=0; c<ban_cnt; c++){
                            list[k].add(temp[c]);
                        }
                        break;
                    }else{
                        int ccnt = 0;
                        for(int n=0; n<ban_cnt; n++){
                            if(list[k].contains(temp[n])){
                                ccnt++;
                            }
                        }
                        
                        if(ccnt == ban_cnt) break;
                    }
                }
                
            }
            return;
        }
        
        for(int i=0; i<user_cnt; i++){
            if(v[i]) continue;
            v[i] = true;
            choice[cnt] = users[i];
            perm(cnt+1);
            v[i] = false;
        }
    }
}