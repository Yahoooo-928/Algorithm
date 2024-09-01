import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 자신보다 키가 큰 여자와 춤추고 싶은 남자
		ArrayList<Integer> man_tallerwoman = new ArrayList<>();
		// 자신보다 키가 작은 여자와 춤추고 싶은 남자
		ArrayList<Integer> man_smallerwoman = new ArrayList<>();
		// 자신보다 키가 큰 남자와 춤추고 싶은 여자 
		ArrayList<Integer> woman_tallerman = new ArrayList<>();
		// 자신보다 키가 작은 남자와 춤추고 싶은 여자 
		ArrayList<Integer> woman_smallerman = new ArrayList<>();
		
		// 남자 키 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num>0) man_tallerwoman.add(num);
			else {
				num = Math.abs(num);
				man_smallerwoman.add(num);
			}
		}
		
		// 여자 키 입력받기
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num>0) woman_tallerman.add(num);
			else {
				num = Math.abs(num);
				woman_smallerman.add(num);
			}
		}
		
		// 그룹들의 키를 정렬해준다. 
		Collections.sort(man_tallerwoman);
		Collections.sort(man_smallerwoman);
		Collections.sort(woman_tallerman);
		Collections.sort(woman_smallerman);
		
		// 상근이가 만들어 줄 수 있는 쌍의 수
		int total = 0;
		
		// 키작은 남자와 키큰 여자 
		int man = 0;
		int woman = 0;
		
		while(man<man_tallerwoman.size() && woman<woman_smallerman.size()) {
			if(man_tallerwoman.get(man) < woman_smallerman.get(woman)) {
				total++;
				man++;
				woman++;
			}else {
				woman++;
			}
		}
		
		// 키 큰 남자와 키 작은 여자 
		man = 0;
		woman = 0;
		
		while(man<man_smallerwoman.size() && woman<woman_tallerman.size()) {
			if(man_smallerwoman.get(man) > woman_tallerman.get(woman)) {
				total++;
				man++;
				woman++;
			}else {
				man++;
			}
		}
		
		System.out.println(total);
		
		br.close();
	}

}