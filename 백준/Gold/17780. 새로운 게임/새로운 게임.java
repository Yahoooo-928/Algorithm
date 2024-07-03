import java.io.*;
import java.util.*;
public class Main {
    static int[] di ={0,0,0,-1,1};
    static int[] dj ={0,1,-1,0,0};
    static int n,k,answer;
    static int[][] map;
    static ArrayList<int[]>[][] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 체스판의 크기
        n = Integer.parseInt(st.nextToken());
        //말의 개수
        k = Integer.parseInt(st.nextToken());

        // 체스판 정보
        map = new int[n+2][n+2];
        // 0 흰색, 1 빨간색, 2 파란색, -1 바깥

        // -1으로 초기화
        for(int i=0; i<=n+1; i++){
            for(int j=0; j<=n+1; j++){
                map[i][j] = -1;
            }
        }
        // 체스판 정보 업데이트
        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<n+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new ArrayList[n+1][n+1];
        // 체스 말들 정보 저장할 arraylist 만들기
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                list[i][j] = new ArrayList<>();
            }
        }
        // 체스 말 정보 받기
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[a][b].add(new int[]{i+1,d});
        }
        answer=0;
        // 체스 돌려
        gamestart();
        if(answer>1000) answer =-1;
        System.out.println(answer);
        br.close();
    }

    static void gamestart(){
        // 턴 진행 중 말이 4개 이상 쌓이면 게임종료
        // 턴 값이 1000보다 크면 종료 x -1 출력
        boolean check = false;
        while(answer<=1000){

            // 말이 쌓여있는 갯수 확인
            for(int i=1; i<n+1; i++){
                for(int j=1; j<n+1; j++){
                    if(list[i][j].size()>=4) check=true;
                }
            }

            if(check) break;

            //턴수
            answer++;
            for(int kk=1; kk<k+1; kk++){
                flag:for(int i=1; i<n+1; i++){
                    for(int j=1; j<n+1; j++){
                        if(!list[i][j].isEmpty()){
                            int[] now = list[i][j].get(0);
                            if(now[0]==kk){
                                gameing(i,j);
                                break flag;
                            }
                        }
                    }
                }
            }

        }
    }

    static void gameing(int a, int b){
        int[] now = list[a][b].get(0);
        int d = now[1];
        int nx = a + di[d];
        int ny = b + dj[d];
        //System.out.println(nx+":"+ny);
        // 범위 벗어날 때 or 파랑일때
        if(map[nx][ny]==-1 || map[nx][ny]==2){
            int newd = changeD(d);
            int nnx = a + di[newd];
            int nny = b + dj[newd];
            //System.out.println("!!!");
            //System.out.println(nnx+":"+nny);
            // 이동하려는 곳이 파랑이면
            list[a][b].remove(0);
            // 방향만 바꾸기
            list[a][b].add(0,new int[]{now[0],newd});
            if(map[nnx][nny]==0) { // 아니면 한칸 이동 // 그냥 이동
                for(int[] ex : list[a][b]){
                    list[nnx][nny].add(ex);
                }
                list[a][b].clear();
            }else if(map[nnx][nny]==1){ // 빨강이면
                // 순서 반대로 하기
                Collections.reverse(list[a][b]);
                for(int[] ex : list[a][b]){
                    list[nnx][nny].add(ex);
                }
                list[a][b].clear();
            }
        }else{// 범위 벗어나지 않을 때
            if(map[nx][ny]==0){//흰색
                for(int[] ex : list[a][b]){
                    list[nx][ny].add(ex);
                }
                list[a][b].clear();
            }else if(map[nx][ny]==1) { //빨강
                // 순서 반대로 하기
                Collections.reverse(list[a][b]);
                for(int[] ex : list[a][b]){
                    list[nx][ny].add(ex);
                }
                list[a][b].clear();
            }
        }
    }

    static int changeD(int d){
        if(d==1) d=2;
        else if(d==2) d=1;
        else if(d==3) d=4;
        else d=3;
        return d;
    }
}