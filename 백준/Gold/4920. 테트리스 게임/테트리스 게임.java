import java.io.*;
import java.util.*;
public class Main {
	
	static int n, ans;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		
		int idx =1;
		while(true) {
			st=new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			if(n==0) break;
			sb = new StringBuilder();
			
			map = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<n; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			ans = Integer.MIN_VALUE;
			
			search1();
			search2();
			search3();
			search4();
			search5();
			
			sb.append(idx).append(". ").append(ans);
			idx++;
			System.out.println(sb.toString());
		}
		
		br.close();
	}
	
	static void search1() {
		// 1번째 블럭 1번째 모양
		int[] di = {0,0,0,0};
		int[] dj = {0,1,2,3};
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int total = 0;
				boolean check = true;
				for(int k=0; k<4; k++) {
					int nx = i+di[k];
					int ny = j+dj[k];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n) { //범위안에 있으면
						total+=map[nx][ny];
					}else {//범위 탈출하면
						check=false;
						break;
					}
				}
				if(check) {
					ans = Math.max(ans, total);
				}
			}
		}
		// 1번째 블럭 2번째 모양
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int total = 0;
				boolean check = true;
				for(int k=0; k<4; k++) {
					int nx = i+dj[k];
					int ny = j+di[k];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n) { //범위안에 있으면
						total+=map[nx][ny];
					}else {//범위 탈출하면
						check=false;
						break;
					}
				}
				if(check) {
					ans = Math.max(ans, total);
				}
			}
		}
		
	}
	static void search2() {
		// 2번째 블럭 1번째 모양
		int[] di = {0,0,1,1};
		int[] dj = {0,1,1,2};
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int total = 0;
				boolean check = true;
				for(int k=0; k<4; k++) {
					int nx = i+di[k];
					int ny = j+dj[k];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n) { //범위안에 있으면
						total+=map[nx][ny];
					}else {//범위 탈출하면
						check=false;
						break; 
					}
				}
				if(check) {
					ans = Math.max(ans, total);
				}
			}
		}
		// 1번째 블럭 2번째 모양
		int[] di2 = {0,1,1,2};
		int[] dj2 = {0,0,-1,-1};
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int total = 0;
				boolean check = true;
				for(int k=0; k<4; k++) {
					int nx = i+di2[k];
					int ny = j+dj2[k];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n) { //범위안에 있으면
						total+=map[nx][ny];
					}else {//범위 탈출하면
						check=false;
						break;
					}
				}
				if(check) {
					ans = Math.max(ans, total);
				}
			}
		}
	}
	static void search3() {
		// 3번째 블럭 1번째 모양
		int[] di = {0,0,0,1};
		int[] dj = {0,1,2,2};
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int total = 0;
				boolean check = true;
				for(int k=0; k<4; k++) {
					int nx = i+di[k];
					int ny = j+dj[k];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n) { //범위안에 있으면
						total+=map[nx][ny];
					}else {//범위 탈출하면
						check=false;
						break; 
					}
				}
				if(check) {
					ans = Math.max(ans, total);
				}
			}
		}
		// 3번째 블럭 2번째 모양
		int[] di2 = {0,1,2,2};
		int[] dj2 = {0,0,0,-1};
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int total = 0;
				boolean check = true;
				for(int k=0; k<4; k++) {
					int nx = i+di2[k];
					int ny = j+dj2[k];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n) { //범위안에 있으면
						total+=map[nx][ny];
					}else {//범위 탈출하면
						check=false;
						break;
					}
				}
				if(check) {
					ans = Math.max(ans, total);
				}
			}
		}
		// 3번째 블럭 3번째 모양
		int[] di3 = {0,1,1,1};
		int[] dj3 = {0,0,1,2};
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int total = 0;
				boolean check = true;
				for(int k=0; k<4; k++) {
					int nx = i+di3[k];
					int ny = j+dj3[k];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n) { //범위안에 있으면
						total+=map[nx][ny];
					}else {//범위 탈출하면
						check=false;
						break;
					}
				}
				if(check) {
					ans = Math.max(ans, total);
				}
			}
		}
		// 3번째 블럭 4번째 모양
		int[] di4 = {0,0,1,2};
		int[] dj4 = {0,1,0,0};
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int total = 0;
				boolean check = true;
				for(int k=0; k<4; k++) {
					int nx = i+di4[k];
					int ny = j+dj4[k];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n) { //범위안에 있으면
						total+=map[nx][ny];
					}else {//범위 탈출하면
						check=false;
						break;
					}
				}
				if(check) {
					ans = Math.max(ans, total);
				}
			}
		}
	}
	
	static void search4() {
		// 3번째 블럭 1번째 모양
		int[] di = {0,0,0,1};
		int[] dj = {0,1,2,1};
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int total = 0;
				boolean check = true;
				for(int k=0; k<4; k++) {
					int nx = i+di[k];
					int ny = j+dj[k];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n) { //범위안에 있으면
						total+=map[nx][ny];
					}else {//범위 탈출하면
						check=false;
						break; 
					}
				}
				if(check) {
					ans = Math.max(ans, total);
				}
			}
		}
		// 3번째 블럭 2번째 모양
		int[] di2 = {0,1,2,1};
		int[] dj2 = {0,0,0,-1};
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int total = 0;
				boolean check = true;
				for(int k=0; k<4; k++) {
					int nx = i+di2[k];
					int ny = j+dj2[k];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n) { //범위안에 있으면
						total+=map[nx][ny];
					}else {//범위 탈출하면
						check=false;
						break;
					}
				}
				if(check) {
					ans = Math.max(ans, total);
				}
			}
		}
		// 3번째 블럭 3번째 모양
		int[] di3 = {0,1,1,1};
		int[] dj3 = {0,0,-1,1};
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int total = 0;
				boolean check = true;
				for(int k=0; k<4; k++) {
					int nx = i+di3[k];
					int ny = j+dj3[k];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n) { //범위안에 있으면
						total+=map[nx][ny];
					}else {//범위 탈출하면
						check=false;
						break;
					}
				}
				if(check) {
					ans = Math.max(ans, total);
				}
			}
		}
		// 3번째 블럭 4번째 모양
		int[] di4 = {0,1,1,2};
		int[] dj4 = {0,1,0,0};
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int total = 0;
				boolean check = true;
				for(int k=0; k<4; k++) {
					int nx = i+di4[k];
					int ny = j+dj4[k];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n) { //범위안에 있으면
						total+=map[nx][ny];
					}else {//범위 탈출하면
						check=false;
						break;
					}
				}
				if(check) {
					ans = Math.max(ans, total);
				}
			}
		}
	}
	static void search5() {
		// 5번째 블럭 1번째 모양
		int[] di = {0,0,1,1};
		int[] dj = {0,1,0,1};
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int total = 0;
				boolean check = true;
				for(int k=0; k<4; k++) {
					int nx = i+di[k];
					int ny = j+dj[k];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n) { //범위안에 있으면
						total+=map[nx][ny];
					}else {//범위 탈출하면
						check=false;
						break;
					}
				}
				if(check) {
					ans = Math.max(ans, total);
				}
			}
		}
		
		
	}
}