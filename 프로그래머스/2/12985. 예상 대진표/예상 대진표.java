import java.io.*;
import java.util.*;
class Solution
{
    public int solution(int n, int a, int b) throws Exception
    {
        int answer = 0;
        
        while(true){
            answer++;
            if(Math.abs(a-b)==1) {
                if(a%2==0 && a>b){
                    break;
                }else if(b%2==0 && b>a){
                    break;
                } 
            } 
            if(a%2==0){
                a=a/2;
            }else{
                a=(a+1)/2;
            }
            if(b%2==0){
                b=b/2;
            }else{
                b=(b+1)/2;
            }
            
        }
        // // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");

        return answer;
    }
}