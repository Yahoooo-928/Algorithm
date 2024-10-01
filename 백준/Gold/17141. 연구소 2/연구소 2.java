import java.io.*;
import java.util.*;
public class Main {
	static int n,m,answer;
	static int[][] map,temp;
	static ArrayList<Integer> virus;
	static int[] b,bb;
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	static boolean[][] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		int cnt = 0;
		virus = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					virus.add(cnt);
				}
				cnt++;
			}
		}
		
		answer = Integer.MAX_VALUE;
		b = new int[m];
		comb(0,0);
		
		if(answer == Integer.MAX_VALUE) answer = -1;
		
		System.out.println(answer);
		
		br.close();
	}
	
	static void comb(int cnt, int start) {
		if(cnt == m) {
			temp = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]==1) temp[i][j] = -1;
					else if(map[i][j]==0) temp[i][j] = -3; 
					else temp[i][j] = -2; 
				}
			}
			bb = new int[m];
			for(int i=0; i<m; i++) {
				bb[i] = b[i];
			}
			
			int result = bfs(temp, bb);
			if(result!=-1) answer = Math.min(answer, result);
			return;
		}
		
		for(int i=start; i<virus.size(); i++) {
			b[cnt] = virus.get(i);
			comb(cnt+1,i+1);
		}
	}
	
	static int bfs(int[][] temp2, int[] bb2) {
		v = new boolean[n][n];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		for(int i=0; i<m ; i++) {
			int x = bb2[i]/n;
			int y = bb2[i]%n;
			
			temp2[x][y] = 0;
			q.offer(new int[] {x,y,0});
			v[x][y] = true;
		}
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			int cnt = current[2];
			
			for(int d=0; d<4; d++) {
				int nx = x + di[d];
				int ny = y + dj[d];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n && !v[nx][ny]) {
					if(map[nx][ny]==0 || map[nx][ny]==2) {
						q.offer(new int[] {nx,ny,cnt+1});
						v[nx][ny] = true;
						temp2[nx][ny] = cnt+1;
					}
				}
			}
		}
		int result = -1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(temp2[i][j]!=-1 && temp2[i][j]<0) {
					return -1;
				}
				if(temp2[i][j]>=0) {
					result = Math.max(result, temp2[i][j]);
				}
			}
		}
		return result;
	}

	

}