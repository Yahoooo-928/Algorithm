import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int l1 = s1.length();
		int l2 = s2.length();
		
		int[][] arr = new int[l1+1][l2+1];
		
		int answer = 0;
		for(int i=0; i<l1; i++){
			char a = s1.charAt(i);
			for(int j=0; j<l2; j++){
				char b = s2.charAt(j);
				if(a==b) {
					arr[i+1][j+1] = arr[i][j] + 1;
					answer = Math.max(answer, arr[i+1][j+1]);
				}
			}
			
		}
		
		System.out.println(answer);
		
		br.close();
	}

}