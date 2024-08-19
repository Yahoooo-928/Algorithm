import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
	static int n,m;
	static int[][] map;
	static int[][] direction;
	static ArrayList<int[]> cloud;
	static int[] di = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dj = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		direction = new int[m][2];

		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++){
				direction[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 구름의 위치
		cloud=new ArrayList<>();
		cloud.add(new int[]{n-1,0});
		cloud.add(new int[]{n-1,1});
		cloud.add(new int[]{n-2,0});
		cloud.add(new int[]{n-2,1});

		for(int i=0;i<m;i++){
			// for(int[] r:cloud){
			// 	System.out.print(r[0]+" "+r[1] +", ");
			// }
			// System.out.println("!!!!!!!!!!!!");
			// 방향
			int d = direction[i][0];
			// 칸 수
			int num = direction[i][1];

			boolean[][] visted;
			// 구름 이동 및 물의 양 1씩 증가 & 대각선 확인 후 물의 양 증가
			visted = move(d, num);
			// for(int[] r:nc){
			// 	System.out.print(r[0]+" "+r[1] +", ");
			// }
			//System.out.println("!ncncncnc");


			for(int a=0;a<n;a++){
				for(int b=0;b<n;b++){
					if(!visted[a][b] && map[a][b]>=2){
						cloud.add(new int[]{a,b});
						map[a][b]-=2;
					}
				}
			}

		}
		int answer = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				answer+=map[i][j];
			}
		}

		System.out.println(answer);
		br.close();
	}

	private static boolean[][] move(int d, int num) {
		boolean[][] v = new boolean[n][n];
		ArrayList<int[]> next = new ArrayList<>();

		for(int[] l: cloud){
			int nx = l[0] + (di[d] * num);
			int ny = l[1] + (dj[d] * num);

			if (nx < 0) {
				int nn = (nx*(-1))/n;
				nx = nx + (n*(nn+1));
				if(nx == n) nx =0;
			} else if (nx >= n) nx = nx % n;
			if (ny < 0) {
				int nn = (ny*(-1))/n;
				ny = ny + (n*(nn+1));
				if(ny == n) ny =0;
			} else if (ny >= n) ny = ny % n;

			map[nx][ny] +=1;
			v[nx][ny] = true;
			next.add(new int[]{nx,ny});
		}
		cloud = new ArrayList<>();
		// 대각선 확인
		for(int[] l:next){
			int xx = l[0];
			int yy = l[1];

			if(xx-1>=0 && xx-1<n && yy-1>=0 && yy-1<n){
				if(map[xx-1][yy-1]>0) map[xx][yy]++;
			}
			if(xx+1>=0 && xx+1<n && yy-1>=0 && yy-1<n){
				if(map[xx+1][yy-1]>0) map[xx][yy]++;
			}
			if(xx-1>=0 && xx-1<n && yy+1>=0 && yy+1<n){
				if(map[xx-1][yy+1]>0) map[xx][yy]++;
			}
			if(xx+1>=0 && xx+1<n && yy+1>=0 && yy+1<n){
				if(map[xx+1][yy+1]>0) map[xx][yy]++;
			}
		}

		return v;
	}
}