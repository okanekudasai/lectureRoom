import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int next;
	int weight;
	Node(int next, int weight) {
		this.next = next;
		this.weight = weight;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		PriorityQueue<Node> [] pq = new PriorityQueue [v+1];
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (pq[a] == null) pq[a] = new PriorityQueue<Node>((o1, o2) -> {return o1.weight - o2.weight;});
			pq[a].offer(new Node(b, c));
		}
		int [] answer = new int [v+1];
		Arrays.fill(answer, -1);
		answer[k] = 0;
		while (pq[k].size() > 0) {
			Node temp = pq[k].poll();
			if (answer[temp.next] != -1) continue;
			answer[temp.next] = temp.weight;
			if (pq[temp.next] == null) continue;
			for (Node node : pq[temp.next]) {
				pq[k].offer(new Node(node.next, temp.weight + node.weight));
			}
		}
		for (int i = 1; i <= v; i++) {
			if (answer[i] == -1) System.out.println("INF");
			else System.out.println(answer[i]);
		}
	}
}