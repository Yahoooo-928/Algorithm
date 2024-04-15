import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		s=s.toUpperCase();
		
		char[] alpa = new char[26];
		alpa[0]='A';
		for(int i=1; i<26; i++) {
			alpa[i]=(char) (alpa[i-1]+1);
		}
		
		int[] arr = new int[26];
		int max = 0;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			for(int j=0; j<26; j++) {
				if(c==alpa[j]) {
					arr[j]++;
					max = Math.max(max, arr[j]);
					break;
				}
			}
		}
		
		char ans = 0;
		int cnt =0;
		for(int i=0; i<26; i++) {
			if(arr[i]==max) {
				cnt++;
				ans = alpa[i];
			}
		}
		
		if(cnt>1) System.out.println('?');
		else System.out.println(ans);
		
		br.close();
	}

}