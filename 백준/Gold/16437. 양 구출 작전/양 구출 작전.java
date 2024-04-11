import java.io.*;
import java.util.*;
public class Main {
    static int n,sheep;
    static int[] in, ms;
    static long[][] s_cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        s_cnt = new long[n+1][3];
        //위상정렬
        // 진입차수 구하기
        in = new int[n+1];
        for(int i=2; i<=n; i++){
            st = new StringTokenizer(br.readLine()," ");
            String s = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            
            if(s.equals("S")) {
                s_cnt[i] = new long[] {cnt,0, node};
            }else {
                s_cnt[i] = new long[] {0,cnt,node};
            }
            // 양은 1 늑대는 0으로 저장해 준다. 
            in[node]++;
        }
        
        search();
        
        System.out.println(s_cnt[1][0]);
        
        br.close();
    }
    static void search() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=2; i<=n; i++) {
            if(in[i]==0) {
            	q.offer(i);
            }
        }
        
        while(!q.isEmpty()) {
            int cur = q.poll(); 
            long[] in_node = s_cnt[cur]; // 양, 늑대, 다음 섬 
            
            long result = Math.max(in_node[0]-in_node[1], 0);
//            System.out.println(result);
            s_cnt[(int) in_node[2]][0] += result;
            
            in[(int) in_node[2]]--;
            
            if(in[(int) in_node[2]]==0 && in_node[2]!=1) {
                q.offer((int) in_node[2]);
            }
            
        }
        
        
    }

}