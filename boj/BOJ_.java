// https://www.acmicpc.net/problem/
// 
// 

package boj;

import java.io.*;
import java.util.*;

public class BOJ_ {

	static int N, M;
	static boolean[] check;
	static int[][] map;
	static int[][] zoneNum;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		input();
		manki();
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		zoneNum = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; ++i) {
			String s = br.readLine();
			for (int j = 0; j < M; ++j) {
				char c = s.charAt(j);
				if (c == '1')
					map[i][j] = -1;
				else
					map[i][j] = 0;
			}
		}
	}

	public static void manki() {
		int num = 1;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == 0) {
					bfs(i, j, num++);
				}
			}
		}

		check = new boolean[num + 1];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == -1) {
					int cnt = 1;
					for (int k = 0; k < 4; ++k) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (!isIn(nx, ny) || map[nx][ny] == -1) continue;
						if (check[zoneNum[nx][ny]]) continue;
						check[zoneNum[nx][ny]] = true;
						cnt+=map[nx][ny];
					}
					sb.append(cnt%10);
					for (int k = 0; k < 4; ++k) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (!isIn(nx, ny)) continue;
						check[zoneNum[nx][ny]] = false;
					}
				}
				else sb.append(0);
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	static final int[] dx = { 0, 0, 1, -1 };
	static final int[] dy = { 1, -1, 0, 0 };

	public static void bfs(int x, int y, int num) {
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> memo = new LinkedList<>();

		int dis = 1;
		q.add(new int[] { x, y });
		memo.add(new int[] { x, y });
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; ++i) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (!isIn(nx, ny) || map[nx][ny] != 0 || visit[nx][ny])
					continue;
				dis++;
				visit[nx][ny] = true;
				q.add(new int[] { nx, ny });
				memo.add(new int[] { nx, ny });
			}
		}

		while (!memo.isEmpty()) {
			int nx = memo.peek()[0];
			int ny = memo.poll()[1];
			map[nx][ny] = dis;
			zoneNum[nx][ny] = num;
		}

	}

	public static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

}