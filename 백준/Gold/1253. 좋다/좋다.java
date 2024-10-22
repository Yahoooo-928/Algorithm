import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int ans = 0;
		// N은 최대 2000, 총 시간복잡도는 O(N^2) => 통과!
		for(int i=0; i<N; i++) { // O(N)
			int left = 0; // 왼쪽 포인터는 첫번째 값
			int right = N-1; // 오른쪽 포인터는 마지막 값 (음수값이 존재할 수 있으므로)
			while(true) { // 투 포인터 => O(N)

				// 두 숫자의 합으로 나타내야 하므로, 현재 숫자를 가리킨다면 포인터를 이동시킨다.
				if (i == left) left++;
				else if (right == i) right--;

				if (left >= right)	break; // 두 숫자의 합으로 나타낼 수 없다.

				if (arr[left] + arr[right] > arr[i]) right--;
				else if (arr[left] + arr[right] < arr[i]) left++;
				else { // 두 숫자의 합으로 나타낼 수 있다면 ? 좋다~!
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}