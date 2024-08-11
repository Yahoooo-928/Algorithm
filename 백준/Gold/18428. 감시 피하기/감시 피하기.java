import java.io.*;
import java.util.*;
public class Main {
	
	static int n;
	static String[][] map;
	static ArrayList<Integer> list;
	static int r; // 장애물을 놓을 수 있는 모든 칸의 수
	static int[] b;
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	static boolean answer;
	static boolean[][] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map= new String[n][n];
		int c=0;
		list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j]=st.nextToken();
				c++;
				if(map[i][j].equals("X")) list.add(c);
			}
		}
		
		r = list.size();
		// r개 중에 3개를 고르는 경우 -> 조합
		b = new int[3];
		answer = false;
		comb(0,0);
		
		if(answer) System.out.println("YES");
		else System.out.println("NO");
		br.close();
	}
	
	static void comb(int cnt, int start) {
		if(cnt==3) {
			String[][] temp = new String[n][n];
			int teacher = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					temp[i][j]=map[i][j];
					if(temp[i][j].equals("T")) teacher++;
				}
			}
			
			// 기존 내용 temp에 복사 
			for(int k=0; k<3; k++) {
				
				int x = (b[k]-1)/n;
				int y = (b[k]-1)%n;
				
				temp[x][y] = "O";
				// 장애물 세우기
			}
			
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<n; j++) {
//					System.out.print(temp[i][j]+" ");
//				}
//				System.out.println();
//			}
//			
			// 이제 temp 돌면서 선생님의 사방에 학생이 있는지 없는지 검사 
			int result =0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(temp[i][j].equals("T")) {
						int count =0;
						for(int d=0; d<4; d++) {
							v = new boolean[n][n];
							boolean flag = check(temp,i,j,d);
							
							if(flag) count++;
						}
//						System.out.println(count);
						if(count==4) result++;
					}
				}
			}
			
			if(result == teacher) answer = true;
			return;
		}
		
		for(int i=start; i<r; i++) {
			b[cnt] = list.get(i);
			comb(cnt+1,i+1);
		}
	}

	static boolean check(String[][] temp, int x, int y, int d) {
		v[x][y]=true;
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int i = current[0];
			int j = current[1];
			
			if(temp[i][j].equals("S")){
				return false;
			}
			
			int nx = i+di[d];
			int ny = j+dj[d];
			if(nx>=0 && nx<n && ny>=0 && ny<n && !v[nx][ny]) {
				if(!(temp[nx][ny].equals("O"))) {
					v[nx][ny]=true;
					q.offer(new int[] {nx, ny});
				}
			}
			
		}
		
		return true;
	}

}