// https://www.acmicpc.net/problem/
// 
// 

package boj;

import java.io.*;
import java.util.*;

public class BOJ_11967_G4_불켜기 {

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, ans = 1;
	static List<Pair> switches[][];
	static boolean lightOn[][];
	static boolean visit[][];

	public static void main(String args[]) throws IOException {
		input();
		changwoo();
		System.out.println(ans);
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		switches = new ArrayList[N][N];
		lightOn = new boolean[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				switches[i][j] = new ArrayList<>();
			}
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			switches[a-1][b-1].add(new Pair(x-1, y-1));
		}

	}

	static final int dx[] = { 0, 0, 1, -1 };
	static final int dy[] = { 1, -1, 0, 0 };

	public static void changwoo() {
		visit[0][0] = true;
		lightOn[0][0] = true;

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0));

		while (!q.isEmpty()) {
			Pair now = q.poll();

			for (Pair p : switches[now.x][now.y]) {

				if (visit[p.x][p.y])
					continue;
				
				if (!lightOn[p.x][p.y]) {
					lightOn[p.x][p.y] = true;
					++ans;
				}
				
				for (int i = 0; i < 4; ++i) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (!isIn(nx, ny) || !visit[nx][ny])
						continue;
					visit[p.x][p.y] = true;
					q.add(p);
					break;
				}

			}

			for (int i = 0; i < 4; ++i) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (!isIn(nx, ny) || visit[nx][ny] || !lightOn[nx][ny])
					continue;
				visit[nx][ny] = true;
				q.add(new Pair(nx, ny));
			}

		}

	}

	public static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

}