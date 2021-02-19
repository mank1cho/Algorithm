// https://www.acmicpc.net/problem/2842
// 집배원 한상덕
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2842_P5 {

	static final int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static final int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static String[] map;
	static int[][] godo;
	static boolean[][] visit;
	static int N, sx, sy, ck, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new String[N];
		godo = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; ++i) {
			map[i] = br.readLine();
		}

		int max = Integer.MIN_VALUE;
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				godo[i][j] = Integer.parseInt(st.nextToken());
				char c = map[i].charAt(j);
				if (c == 'P') {
					max = Math.max(max, godo[i][j]);
					sx = i;
					sy = j;
				} else if (c == 'K') {
					max = Math.max(max, godo[i][j]);
					++ck;
				}
				set.add(godo[i][j]);
			}
		}

		Iterator<Integer> iter = set.iterator();
		ArrayList<Integer> arr = new ArrayList<>();
		cnt = 0;
		int left = 0, right = 0;
		while (iter.hasNext()) {
			int x = iter.next();
			if (x == max)
				right = cnt;
			arr.add(x);
			++cnt;
		}

		int ans = Integer.MAX_VALUE;
		while (left <= right && right < arr.size()) {
			for (int i = 0; i < N; ++i)
				Arrays.fill(visit[i], false);
			cnt = 0;
			dfs(arr.get(left), arr.get(right), sx, sy);
			if (cnt >= ck) {
				ans = Math.min(ans, arr.get(right) - arr.get(left));
				++left;
			} else {
				++right;
			}
		}

		System.out.println(ans);
	}

	static void dfs(int min, int max, int x, int y) {
		visit[x][y] = true;
		if (cnt == ck)
			return;
		for (int i = 0; i < 8; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N || godo[nx][ny] < min || godo[nx][ny] > max || visit[nx][ny])
				continue;
			if (map[nx].charAt(ny) == 'K')
				++cnt;
			dfs(min, max, nx, ny);
		}
	}
}