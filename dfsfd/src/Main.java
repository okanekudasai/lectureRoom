import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int [] [] data = new int [n] [2];
		long p = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
			p += data[i][1];
		}
		Arrays.sort(data, (o1, o2) -> {
			return o1[0] - o2[0];
		});
		for (int i = 0; i < n; i++) {
			p -= data[i][1] * 2;
			if (p <= 0) {
				System.out.println(data[i][0]);
				break;
			}
		}
	}
}