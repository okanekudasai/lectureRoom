import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
<<<<<<< HEAD
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	
	static boolean confirming(int x, int y, int dx, int dy) {
		if (x+dx >= 0 && x+dx < r && y+dy >=0 && y+dy < c) return true;
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		char [] [] map = new char [r] [c];
		ArrayList<Integer> sx = new ArrayList<>();
		ArrayList<Integer> sy = new ArrayList<>();
		int [] d = new int [2];
		int [] [] delta = {{0,1}, {1,0}, {0,-1}, {-1,0}}; 
		ArrayList<Integer> waterx = new ArrayList<>();
		ArrayList<Integer> watery = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			String tempString = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] =
						tempString.charAt(j);
				if (map[i][j] == 'S') {
					sx.add(i); sy.add(j);
				} else if (map[i][j] == 'D') {
					d[0] = i; d[1] = j;
				} else if (map[i][j] == '*') {
					waterx.add(i); watery.add(j);
				}
			}
		}
//		for (char [] i : map) System.out.println(Arrays.toString(i));
		int c = 0;
		String answer = "KAKTUS";
		Loop1:
		while (waterx.size() > 0 || sx.size() > 0) {
			c++;
//			System.out.println("---");
//			System.out.println(c);
			ArrayList<Integer> tx = new ArrayList<>();
			ArrayList<Integer> ty = new ArrayList<>();
			for (int i = 0; i < waterx.size(); i++) {
				for (int [] del : delta) {
					if (confirming(waterx.get(i), watery.get(i), del[0], del[1]) && (map[waterx.get(i) + del[0]][watery.get(i) + del[1]] == '.' || map[waterx.get(i) + del[0]][watery.get(i) + del[1]] == 'S')) {
						tx.add(waterx.get(i) + del[0]);
						ty.add(watery.get(i) + del[1]);
						map[waterx.get(i) + del[0]][watery.get(i) + del[1]] = '*';
					}
				}
			}
			waterx = tx; watery = ty;
			ArrayList<Integer> tsx = new ArrayList<>();
			ArrayList<Integer> tsy = new ArrayList<>();
			for (int i = 0; i < sx.size(); i++) {
				for (int [] del : delta) {
					if (confirming(sx.get(i), sy.get(i), del[0], del[1]) && (map[sx.get(i) + del[0]][sy.get(i) + del[1]] == '.' || map[sx.get(i) + del[0]][sy.get(i) + del[1]] == 'D')) {
						if(map[sx.get(i) + del[0]][sy.get(i) + del[1]] == 'D') {
							answer = String.valueOf(c);
							break Loop1;
						}
						tsx.add(sx.get(i) + del[0]);
						tsy.add(sy.get(i) + del[1]);
						map[sx.get(i) + del[0]][sy.get(i) + del[1]] = 'S';
					}
				}
			}
			sx =tsx; sy = tsy;
//			System.out.println(waterx);
//			System.out.println(watery);
//			System.out.println(sx);
//			System.out.println(sy);
//			for (char [] i : map) System.out.println(Arrays.toString(i));
		}
		System.out.println(answer);
=======
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
>>>>>>> d66f643af1bdff4ddc0c9a474859d43e4bbf06cb
	}
}
