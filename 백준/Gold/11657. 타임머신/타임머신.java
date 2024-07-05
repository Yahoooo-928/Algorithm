import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        // 벨만포드알고리즘
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도시의 갯수
        int n = Integer.parseInt(st.nextToken());
        // 버스 노선의 개수
        int m = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[m][3];

        // 버스 노선의 정보
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            matrix[i][0] = a;
            matrix[i][1] = b;
            matrix[i][2] = c;
        }

        // 도시끼리의 거리
        long[] distance = new long[n+1];
        for(int i=0; i<n+1; i++){
            // 최대로 초기화
            distance[i] = Integer.MAX_VALUE;
        }

        distance[1] = 0;
        boolean cycle = false;

        for(int i=1; i<n+1; i++){
            for(int j=0; j<m; j++){
                int start = matrix[j][0];
                int end = matrix[j][1];
                int time = matrix[j][2];
                // 현재 간선을 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (distance[start] != Integer.MAX_VALUE && distance[end] > distance[start]+time){
                    distance[end] = distance[start] + time;
                    if(i == n) cycle =true;
                }
            }
        }

        if(cycle) System.out.println(-1);
        else{
            for(int i=2; i<n+1; i++){
                if(distance[i]==Integer.MAX_VALUE) System.out.println(-1);
                else System.out.println(distance[i]);
            }
        }



        br.close();
    }
}