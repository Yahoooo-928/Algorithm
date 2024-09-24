import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	static boolean[][] v;
	static int n, answer;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		// 아기상어는 자신보다 큰 물고기 있는 칸 지나갈 수 없음 나머지 다 가능
		// 아기상어는 자신보다 작은 물고기만 먹을 수 있다.
		// 처음 아기상어의 크기는 2

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		int x = -1;
		int y = -1;
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9){ // 아기상어의 위치
					x = i;
					y = j;
				}else if(map[i][j] !=0 && map[i][j] < 2){
					// 상어가 먹을 수 있는 물고기 좌표를 저장한다.
					list.add(new int[]{i,j});
				}
			}
		}
		// 아기상어의 초기 크기
		// 물고기 2마리(상어의 크기와 같은)를 먹으면 크기가 +1 된다.
		int sharkSize = 2;
		answer = -1;
		// 아기상어의 초기 위치와 초, 상어 사이즈, 먹은 물고기 갯수, 물고기 좌표
		start(x, y,0, sharkSize, 0, list);

		System.out.println(answer);

	}

	static void start(int x,int y,int cnt, int size, int eat, ArrayList<int[]> list){
		if(list.isEmpty()){
			answer = cnt;
			return;
		}

		// 상어가 먹을 수 있는 물고기 정보를 저장할 pq
		PriorityQueue<int[]> pq = new PriorityQueue<>(
			(a, b) -> {
				if (a[0] != b[0]) {
					return Integer.compare(a[0], b[0]); // num이 작은 순
				} else if (a[1] != b[1]) {
					return Integer.compare(a[1], b[1]); // nx가 작은 순
				} else {
					return Integer.compare(a[2], b[2]); // ny가 작은 순
				}
			}
		);
		// 물고기 좌표를 돌면서 가능한 물고기를 찾는다.
		for(int i = 0;i < list.size();i++){
			int[] current = list.get(i);
			int nx = current[0];
			int ny = current[1];

			// 상어가 먹을 수 있는 물고기를 찾아 지나야하는 칸의 갯수를 찾는다.
			v = new boolean[n][n];
			int num = FindNum(x,y,nx,ny,size);
			if(num != -1) {
				pq.offer(new int[] {num, nx, ny});
			}
		}
		// 먹을 수 있는 물고기가 있다면 계속 진행
		if(!pq.isEmpty()){
			// 먹어야 할 물고기
			int[] fish = pq.poll();
			// 먹으면 빈칸으로 만들기
			map[x][y] = 0;
			map[fish[1]][fish[2]] = 9;
			int eatNum = eat + 1;
			int newSize = size;
			if(eatNum == size){
				newSize = size+1;
				eatNum = 0;
			}

			ArrayList<int[]> temp = new ArrayList<>();
			for(int i=0; i<n; i++){
				for(int j=0;j<n;j++){
					if(map[i][j] != 9 && map[i][j] != 0 && map[i][j] < newSize){
						temp.add(new int[]{i,j});
					}
				}
			}

			start(fish[1],fish[2],fish[0]+cnt,newSize, eatNum, temp);
		}else{// 먹을 수 있는 물고기가 없다면 엄마 도와줘
			list.clear();
			start(x,y,cnt,size, eat, list);
		}


	}

	static int FindNum(int x,int y,int nx,int ny,int size){
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{x,y,0});
		v[x][y] = true;

		while(!q.isEmpty()){
			int[] cur = q.poll();

			if(cur[0]==nx && cur[1]==ny){
				return cur[2];
			}

			for(int d=0; d<4; d++){
				int nnx = cur[0] + di[d];
				int nny = cur[1] + dj[d];

				if(nnx>=0 && nnx<n && nny>=0 && nny<n && !v[nnx][nny]){
					if(map[nnx][nny]<=size){
						int newNum = cur[2] + 1;
						q.offer(new int[]{nnx,nny,newNum});
						v[nnx][nny] = true;
					}
				}
			}

		}

		return -1;
	}
}