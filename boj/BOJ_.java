// https://www.acmicpc.net/problem/
// 
// 

package boj;

import java.io.*;
import java.util.*;

public class BOJ_ {

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static List<Pair>[][] list;
	static boolean isTurnOn[][];
	static boolean visit[][];

	public static void main(String[] args) throws Exception {
		input();
		bfs();
		System.out.println(getAnswer());
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1][N + 1];
		isTurnOn = new boolean[N + 1][N + 1];
		visit = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				list[i][j] = new ArrayList<>();
			}
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[x][y].add(new Pair(a, b));

		}

	}

	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0 };

	public static void bfs() {

		Queue<Pair> q = new LinkedList<>();

		q.add(new Pair(1, 1));
		isTurnOn[1][1] = true;
		visit[1][1] = true;

		while (!q.isEmpty()) {
			Pair now = q.poll();
			int x = now.x;
			int y = now.y;
			
			for (Pair p : list[x][y]) {
				isTurnOn[p.x][p.y] = true;	//불켜줌.
			}
			
			for (Pair p : list[x][y]) {
				// 4방향중 방문한곳이 있는데 새롭게 불이 켜졌다면
				for(int i = 0; i<4; ++i) {
					int nx = p.x+dx[i];
					int ny = p.y+dy[i];
					if(!isIn(nx, ny)) continue;
					if(!visit[p.x][p.y] && visit[nx][ny]) {		
						visit[p.x][p.y] = true;
						q.add(new Pair(p.x, p.y));
						break;
					}
				}
				
				// 4방향중 불은 켜졌지만 아직 방문하지 않은 곳이 있다면
				for(int i = 0; i<4; ++i) {
					int nx = p.x+dx[i];
					int ny = p.y+dy[i];
					if(!isIn(nx, ny)) continue;
					if(isTurnOn[nx][ny] && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.add(new Pair(nx, ny));
					}
				}
			}
		}

	}

	static boolean isIn(int x, int y) {
		return x > 0 && y > 0 && x <= N && y <= N;
	}
	
	static int getAnswer() {
		int count = 0;
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				if (isTurnOn[i][j])
					count++;
			}
		}
		return count;
	}

}