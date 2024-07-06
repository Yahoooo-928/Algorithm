import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb;
        for(int tc=0; tc<t; tc++){
            sb = new StringBuilder();
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Long> maxq = new PriorityQueue<>(Comparator.comparingLong(o -> -o));
            PriorityQueue<Long> minq = new PriorityQueue<>();
            Map<Long, Integer> map = new HashMap<>();
            for(int i=0; i<k; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String c = st.nextToken();
                long num = Long.parseLong(st.nextToken());

                if(c.equals("I")){
                	map.put(num, map.getOrDefault(num, 0)+1);
                    maxq.offer(num);
                    minq.offer(num);
                }else{
                	if (map.size() == 0) continue;

                    PriorityQueue<Long> que = num == 1 ? maxq : minq;
                    removeMap(que, map);
                }
            }
            if(map.size()==0) sb.append("EMPTY");
            else{
                long a = removeMap(maxq, map);
                long b = map.size() > 0 ? removeMap(minq, map) : a;
                sb.append(a).append(" ").append(b);
            }

            System.out.println(sb.toString());
        }

        br.close();
    }
    
    static long removeMap(PriorityQueue<Long> que, Map<Long, Integer> map) {
        long num;
        while (true) {
            num = que.poll();
            int cnt = map.getOrDefault(num, 0);

            if (cnt == 0)
                continue;

            if (cnt == 1)
                map.remove(num);
            else
                map.put(num, cnt - 1);

            break;
        }

        return num;
    }

}