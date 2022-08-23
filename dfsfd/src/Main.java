import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int finding (char [] data, int start, int end) {
		char selected = '\0';
		int temp = -1;
		for (int i = start; i <= end; i++) {
			if (selected < data[i]) {
				selected = data[i];
				temp = i + 1;
			}
		}
		System.out.print(selected);
		return temp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		char [] data = br.readLine().toCharArray();
		int s = 0, e = k;
		for (int i = 0; i < n-k; i++) {
			s = finding(data, s, e++);
		}
	}
}