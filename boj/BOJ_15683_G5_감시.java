// https://www.acmicpc.net/problem/15683
// 감시
// 완전탐색 시뮬레이션


package boj;

import java.io.*;
import java.util.*;

public class BOJ_15683_G5_감시 {

	static class CCTV {
		int x, y, type;

		CCTV(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	static final int EMPTY = 0, WALL = -1, CCTV = 1;
	static int N, M, ANSWER = Integer.MAX_VALUE;
	static int[][] MAP;
	static List<CCTV> CCTVLIST;

	static int[][] CCTVDirection = new int[][] { {}, { 0 }, { 0, 2 }, { 0, 3 }, { 0, 2, 3 }, { 0, 1, 2, 3 } };
	static final int[] dx = { 0, 1, 0, -1 };
	static final int[] dy = { 1, 0, -1, 0 };

	public static void main(String args[]) throws IOException {
		input();
		CCTV5On();
		int blindSpotCount = getBlindSpotCount();
		backTracking(0, 0, blindSpotCount);
		System.out.println(ANSWER);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		MAP = new int[N][M];
		CCTVLIST = new ArrayList<>();

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
				if (isCCTV(MAP[i][j])) {
					CCTVLIST.add(new CCTV(i, j, MAP[i][j]));
					MAP[i][j] = CCTV;
				} else if (MAP[i][j] == 6) {
					MAP[i][j] = WALL;
				}
			}
		}
	}

	static void CCTV5On() {
		for (CCTV cctv : CCTVLIST) {
			if(cctv.type == 5) {
				CCTVOn(cctv, 0);
			}
		}
	}

	static int getBlindSpotCount() {
		int cnt = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (MAP[i][j] == EMPTY) {
					++cnt;
				}
			}
		}
		return cnt;
	}

	static void backTracking(int depth, int deletedBlindSpotCount, int blindSpotCount) {
		if (depth == CCTVLIST.size()) {
			ANSWER = Math.min(ANSWER, blindSpotCount - deletedBlindSpotCount);
			return;
		}

		CCTV nowCCTV = CCTVLIST.get(depth);
		if (nowCCTV.type == 5) {
			backTracking(depth + 1, deletedBlindSpotCount, blindSpotCount);
			return;
		}
		
		for (int i = 0; i < 4; ++i) {
			if (i > 1 && nowCCTV.type == 2) return;
			backTracking(depth + 1, deletedBlindSpotCount + CCTVOn(nowCCTV, i), blindSpotCount);
			CCTVOff(nowCCTV, i);
		}
	}

	static boolean isCCTV(int x) {
		if (x > 0 && x < 6)
			return true;
		return false;
	}

	static void CCTVOff(CCTV cctv, int dir) {
		int x = cctv.x;
		int y = cctv.y;
		int type = cctv.type;
		
		for(int direction : CCTVDirection[type]) {
			int d = (dir+direction)%4;
			int nx = x+dx[d];
			int ny = y+dy[d];
			while(isIn(nx, ny)) {
				MAP[nx][ny]--;
				nx+=dx[d];
				ny+=dy[d];
			}
		}
	}

	static int CCTVOn(CCTV cctv, int dir) {
		int x = cctv.x;
		int y = cctv.y;
		int type = cctv.type;
		
		int blindSpotCount = 0;
		for(int direction : CCTVDirection[type]) {
			int d = (dir+direction)%4;
			int nx = x+dx[d];
			int ny = y+dy[d];
			while(isIn(nx, ny)) {
				if(MAP[nx][ny]==EMPTY) {
					blindSpotCount++;
				}
				MAP[nx][ny]++;
				nx+=dx[d];
				ny+=dy[d];
			}
		}
		
		return blindSpotCount;
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M && MAP[x][y] != WALL;
	}

}