import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		ArrayList<int []> [] graph = new ArrayList [v+1];
		int [] answer = new int [v+1];
		Arrays.fill(answer, 2000000);
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (graph[a] == null) graph[a] = new ArrayList<int []>();
			int [] temp = {b, c}; graph[a].add(temp);
		}
		boolean [] visit = new boolean [v+1];
		answer[k] = 0;
		int min_point = 0;
		int min_value;
		int cnt = 0;
		while (min_point != -1 && graph[k] != null) {
			cnt++;
			visit[k] = true;
			min_point = -1;
			min_value = Integer.MAX_VALUE;
			for (int [] i : graph[k]) {
				answer[i[0]] = Math.min(answer[i[0]], answer[k] + i[1]);
				if (visit[i[0]] == false && min_value > answer[i[0]]) {
					min_value = answer[i[0]];
					min_point = i[0];
				}
			}
			System.out.println(Arrays.toString(answer));
			k = min_point;
			System.out.println(k);
			if (cnt >= 4) break;
		}
//		for (int i = 1; i <= v; i++) {
//			if (answer[i] >= 2000000) System.out.println("INF");
//			else System.out.println(answer[i]);
//		}
	}
}