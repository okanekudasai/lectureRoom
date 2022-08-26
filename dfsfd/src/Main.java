import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int r;
	int c;
	int weight;
	public Node(int r, int c, int weight) {
		this.r = r;
		this.c = c;
		this.weight = weight;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int [] [] map = new int [n] [n];
		int [] [] delta = {{0,1},{1,0},{0,-1},{-1,0}};
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int [] [] answer = new int [n] [n];
		for (int i = 0; i < n; i++) Arrays.fill(answer[i], -1);
		answer[0][0] = map[0][0];
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {return o1.weight - o2.weight;});
		pq.offer(new Node(0,0,map[0][0]));
		while (pq.size() > 0) {
			Node now = pq.poll();
			for (int [] delt : delta) {
				int next_r = now.r+delt[0];
				int next_c = now.c+delt[1];
				if (next_r < 0 || next_r >= n || next_c < 0 || next_c >= n) continue;
				if (answer[next_r][next_c] != -1) continue;
				answer[next_r][next_c] = answer[now.r][now.c] + map[next_r][next_c];
				pq.offer(new Node(next_r, next_c, answer[next_r][next_c]));
			}
		}
	}
}