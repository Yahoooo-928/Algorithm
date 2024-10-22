import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String m = st.nextToken();

            if (n == 1) {
                sb.append(v8toNumber(m)).append("\n");
            } else if (n == 2) {
                sb.append(numberToV8(m)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static String v8toNumber(String s) {
        String[] tokens = s.split("\\.");

        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            int value = Integer.parseInt(token);
            String binary = Integer.toBinaryString(value);
            while (binary.length() < 8) {
                binary = "0" + binary;
            }
            sb.append(binary);
        }

        return Long.toUnsignedString(Long.parseUnsignedLong(sb.toString(), 2));
    }

    private static String numberToV8(String s) {
        long value = Long.parseUnsignedLong(s);
        StringBuilder binaryString = new StringBuilder(Long.toBinaryString(value));

        while (binaryString.length() < 64) {
            binaryString.insert(0, "0");
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 64; i += 8) {
            String part = binaryString.substring(i, i + 8);
            result.append(Integer.parseInt(part, 2)).append(".");
        }
        return result.substring(0, result.length() - 1);
    }
}