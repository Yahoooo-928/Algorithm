import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] day = new int[366];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int start=Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			for(int s=start; s<=end; s++) {
				day[s]++;
			}
		}
		
		int sum =0;
		int w =0;
		int h=0;
		for(int i=1; i<366; i++) {
			if(day[i]!=0) {
				w++;
				h=Math.max(h, day[i]);
			}else {
				sum+=w*h;
				w=0;
				h=0;
			}
		}
		//마지막 날에 일정이 있고 끝나면 남은 일정들 값을 추가로 더해주어야한다. 
		sum+=w*h;
		System.out.println(sum);
		
		br.close();
	}

}