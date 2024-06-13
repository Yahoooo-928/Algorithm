import java.io.*;
import java.util.*;
class Solution {
    static int row,column,R,answer;
    static int[] b,c;
    static ArrayList<int[]> right;
    static ArrayList<String[]> list;
    static String[][] rel;
    static boolean[] isSelected;
    static boolean ch;
    public int solution(String[][] relation) throws Exception{
        column = relation[0].length;
        row = relation.length;
        answer = 0;
        
        right = new ArrayList<>();
        rel = new String[row][column];
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                rel[i][j]=relation[i][j];
            }
        }
        
        for(int j=0; j<column; j++){
            R=j+1;
            b = new int[R];
            comb(0,0);
        }
        
        return answer;
    }
    
    static void comb(int cnt, int start){
        if(cnt==R){
            list = new ArrayList<>();
            int l = b.length;
           
            for(int i=0; i<row; i++){
                String[] can = new String[l];
                for(int j=0; j<l; j++){
                    can[j]=rel[i][b[j]];
                }
                
                if(list.size()>0){
                    boolean check=true;
                    for(String[] aaa:list){
                        int count=0;
                        for(int k=0; k<l; k++){
                            if(aaa[k].equals(can[k])){
                                count++;
                            }
                        }
                        if(count==l) check=false;
                    }
                    if(check) list.add(can);
                }else{
                    list.add(can);
                }
                
            }
            
            
            int[] insert = new int[b.length];
            for(int i=0; i<b.length; i++){
                insert[i]=b[i];
            }
            
            if(list.size()==row && notcontain(insert)){
                answer++;
                right.add(insert);
            }
            
            
            return;
        }
        
        for(int i=start; i<column; i++){
            b[cnt]=i;
            comb(cnt+1,i+1);
        }
    }
    
    
    static boolean notcontain(int[] arr){
        int l = arr.length;
        isSelected= new boolean[l];
        c = new int[l];
        for(int i=0; i<l; i++){
            c[i]=arr[i];
        }
        ch=false;
        power(0,l);
        //System.out.println(ch);
        if(ch) return false;
        return true;
    }
    static void power(int cnt, int length){
        if(cnt==length){
            ArrayList<Integer> last = new ArrayList<>();
            for(int i=0; i<length; i++){
                if(isSelected[i]){
                    last.add(c[i]);
                }
            }
            //System.out.println(last);
            //ch=false;
            if(last.size()>0 && right.size()>0){
                for(int[] aaa:right){
                    int count=0;
                    if(aaa.length==last.size()){
                        for(int k=0; k<last.size(); k++){
                            if(aaa[k]==last.get(k)){
                                count++;
                            }
                        }
                    }
                    if(count==last.size()) {ch=true; break;}
                }
            }
            //System.out.println(ch);
            return;
        }
        isSelected[cnt]=true;
        power(cnt+1,length);
        isSelected[cnt]=false;
        power(cnt+1,length);
    }
}
    
