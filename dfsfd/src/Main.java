import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Pair {
	int x, y;
	Pair (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int n, shark_x, shark_y, shark_size = 2, shark_eat = 0;
	static int [] [] map, step, delta = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int [n] [n];
		step = new int [n] [n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark_x = i;
					shark_y = j;
					map[i][j] = 0;
				}
			}
		}
		int answer = 0;
		while (true) {
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < n; j++) 
					step[i][j] = -1;
			int min_x = 0, min_y = 0, min_distance = Integer.MAX_VALUE;
			LinkedList<Pair> q = new LinkedList<>();
			q.offer(new Pair(shark_x, shark_y));
			step[shark_x][shark_y] = 0;
			while (q.size() > 0) {
				Pair now = q.poll();
				if (step[now.x][now.y] > min_distance) break;
				if (0 < map[now.x][now.y] && map[now.x][now.y] < shark_size) {
					if (min_distance > step[now.x][now.y] || (min_distance == step[now.x][now.y] && (min_x > now.x || (min_x==now.x && min_y > now.y)))) {
						min_x = now.x;
						min_y = now.y;
						min_distance = step[now.x][now.y];
					}
				}
				for (int [] delt : delta) {
					int next_x = now.x + delt[0];
					int next_y = now.y + delt[1];
					if (0 > next_x || next_x >= n || 0 > next_y || next_y >= n) continue;
					if (0 <= step[next_x][next_y] || map[next_x][next_y] > shark_size) continue;
					step[next_x][next_y] = step[now.x][now.y] + 1;
					q.offer(new Pair(next_x, next_y));
				}
			}
			
			if (min_distance == Integer.MAX_VALUE) {
				break;	
			}
						
			map[min_x][min_y] = 0;
			answer += min_distance;
			shark_x = min_x;
			shark_y = min_y;
			shark_eat++;
			if (shark_eat >= shark_size) {
				shark_eat = 0;
				shark_size++;
			}
		}
		
		System.out.println(answer);
	}
}
