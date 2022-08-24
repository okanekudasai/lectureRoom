import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Pair {
	int x, y, step;
	Pair(int x, int y, int step) {
		this.x = x;
		this.y = y;
		this.step = step;
	}
}

public class Main {
	static int n, sharkx, sharky, sharkeat = 0, sharksize = 2, fishCnt = 0;
	static int [] [] delta = {{-1,0},{0,-1},{0,1},{1,0}};
	
	static boolean confirming(int x, int y, int dx, int dy) {
		if (x+dx>=0 && x+dx < n && y+dy>=0 && y+dy<n) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		int [] [] map = new int [n] [n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sharkx = i;
					sharky = j;
				} else if (map[i][j] > 0) {
					fishCnt++;
				}
			}
		}
		int answer = 0;
		boolean [] [] visit = new boolean [n] [n];
		Loop1:
		while (fishCnt > 0) {
			LinkedList<Pair> q = new LinkedList<>();
			q.offer(new Pair(sharkx, sharky, 0));
			visit[sharkx][sharky] = true;
			while (q.size() > 0) {
				Pair tpair = q.poll();
				if (map[tpair.x][tpair.y] < sharksize) {
					fishCnt--;
					map[sharkx][sharky] = 0;
					sharkx = tpair.x; sharky = tpair.y;
					answer += tpair.step;
					map[sharkx][sharky] = 9;
					sharkeat++;
					if (sharkeat == sharksize) {
						sharkeat = 0;
						sharksize++;
					}
					for (int [] i : map) System.out.println(Arrays.toString(i));
					System.out.println();
					continue Loop1;
				}
				for (int [] delt : delta) {
					if (confirming(tpair.x, tpair.y, delt[0], delt[1]) && visit[tpair.x+delt[0]][tpair.y+delt[1]] == false && map[tpair.x+delt[0]][tpair.y+delt[1]] <= sharksize && map[tpair.x+delt[0]][tpair.y+delt[1]] > 0) {
						visit[tpair.x+delt[0]][tpair.y+delt[1]] = true;
						q.offer(new Pair(tpair.x+delt[0], tpair.y+delt[1], tpair.step+1));
					}
				}
			}
			break;
		}
		System.out.println(" 끝");
	}
}
