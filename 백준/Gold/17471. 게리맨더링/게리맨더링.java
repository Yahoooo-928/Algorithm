import java.io.*;
import java.util.*;

public class Main {
	
	static int n, ans, result,t,f;
	static int[] people,b;
	static int[][] matrix;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());
		
		people = new int[n];
		StringTokenizer st =  new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			people[i]=Integer.parseInt(st.nextToken()); // 구역의 인구 수 받기
		}
		
		matrix = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int t = Integer.parseInt(st.nextToken());
			for(int j=0; j<t; j++) {
				int c = Integer.parseInt(st.nextToken());
				matrix[i][c-1]=1;
			}
		}
		ans = Integer.MAX_VALUE;
		
		for(int i=1; i<=n/2; i++) {
			b = new int[i];
			comb(0,0,i);
		}
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
		
		br.close();
	}

	static void comb(int cnt, int start, int r) {
		if(cnt == r) {
			result = Integer.MAX_VALUE;
			v = new boolean[n];
			for(int k=0; k<r; k++) {
				v[b[k]]=true; // t,f로 정점들을 둘로 나눈다.
			}
			// 정점들이 서로 연결되어 있는지 확인
			if(bfs()) { // 연결되어 있다면
				// 인구 수 구하기
				// 인구 차이 업데이트 
				ans = Math.min(result, ans);
			}
			
			return;
		}
		
		
		for(int i=start; i<n; i++) {
			b[cnt] = i;
			comb(cnt+1,i+1,r);
		}
	}

	static boolean bfs() {
		int r1=0;
		int r2=0; // 인구수 저장할 변수
		int t_cnt=0;
		int f_cnt=0;
		for(int k=0; k<n; k++) {
			if(v[k]) {
				t=k;
				t_cnt++;
			}
			else {
				f=k;
				f_cnt++;
			}
		}
		// true인 것들 연결되어있는지 확인 
		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n];
		visited[t]=true;
		q.offer(t);
		r1+=people[t];
		int count=0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			count++;
			for(int i=0; i<n; i++) {
				if(matrix[cur][i]==1 && v[i] &&!visited[i]) {
					visited[i]=true;
					q.offer(i);
					r1+=people[i];
				}
			}
		}
		if(count==t_cnt) { //ture가 모두 연결되어 있다면
			//false가 연결되어있는지 확인
			ArrayDeque<Integer> q2 = new ArrayDeque<>();
			boolean[] visited2 = new boolean[n];
			visited2[f]=true;
			q2.offer(f);
			r2+=people[f];
			int count2=0;
			while(!q2.isEmpty()) {
				int cur = q2.poll();
				count2++;
				for(int i=0; i<n; i++) {
					if(matrix[cur][i]==1 && !v[i] &&!visited2[i]) {
						visited2[i]=true;
						q2.offer(i);
						r2+=people[i];
					}
				}
			}
			if(count2!=f_cnt) return false;
		}else {
			return false;
		}
		
		
		result = Math.abs(r1-r2);
		return true;
	}

}