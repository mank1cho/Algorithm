// https://www.acmicpc.net/problem/19236
// 청소년 상어
// 시뮬레이션 백트래킹
package boj;

import java.io.*;
import java.util.*;

public class BOJ_19236_G3 {
	
	static class INFO{
		class POSITION{
			int x, y, d;
			boolean alive;
			POSITION(){}
			POSITION(int x, int y, int d, boolean alive){
				this.x = x;
				this.y = y;
				this.d = d;
				this.alive = alive;
			}
			POSITION(POSITION pos){
				this.x = pos.x;
				this.y = pos.y;
				this.d = pos.d;
				this.alive = pos.alive;
			}
			
			void set(int x, int y, int d) {
				this.x = x;
				this.y = y;
				this.d = d;
			}
		}
		
		//
		POSITION[] fishes = new POSITION[17];
		POSITION shark;
		int[][] map = new int[4][4];
		int score;
		//
		
		INFO() {}
		INFO(INFO info){		// for copy
			for(int i = 1; i<17; ++i) {
				this.fishes[i] = new POSITION(info.fishes[i]);
			}
			
			this.shark = new POSITION(info.shark);
			
			for(int i = 0; i<4; ++i) {
				this.map[i] = info.map[i].clone();
			}
			
			this.score = info.score;
		}
		
		boolean sharkMove(int x) {
			int nx = shark.x + dx[shark.d] * x;
			int ny = shark.y + dy[shark.d] * x;
			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || map[nx][ny] == 0) return false;
			int num = map[nx][ny];
			map[nx][ny] = -1;
			map[shark.x][shark.y] = 0;
			
			score += num;
			fishes[num].alive = false;
			
			shark.set(nx, ny, fishes[num].d);
			if (score > ans) ans = score;
			return true;
		}
		
		void fishMove() {
			for (int i = 1; i < 17; i++) {
				if (fishes[i].alive == false) continue;
				int x = fishes[i].x;
				int y = fishes[i].y;
				int d = fishes[i].d;
				for (int j = 0; j < 8; j++) {
					int nd = (d + j) % 8;
					int nx = x + dx[nd];
					int ny = y + dy[nd];
					if (nx < 0 || ny < 0 || nx == 4 || ny == 4 || map[nx][ny] == -1) continue;
					fishes[i].set( nx, ny, nd );
					if (map[nx][ny] == 0) {
						map[x][y] = 0;
						map[nx][ny] = i;
					}
					else {
						int now = map[nx][ny];
						map[x][y] = now;
						map[nx][ny] = i;
						fishes[now].x = x;
						fishes[now].y = y;
					}
					break;
				}
			}
		}
		
		public void print() {
			System.out.println("========map=======");
			for(int i = 0; i<4; ++i) {
				for(int j = 0; j<4; ++j) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}

	}
	
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,-1,-1,-1,0,1,1,1};
	static int ans;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		INFO info = new INFO();
		
		for(int i = 0; i<4; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<4; ++j) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				info.map[i][j] = num;
				info.fishes[num] = info.new POSITION(i, j, dir-1, true);
			}
		}

		int num = info.map[0][0];
		info.map[0][0] = -1;		// 상어
		info.score = num;
		info.fishes[num].alive = false;
		
		info.shark = info.new POSITION(0,0,info.fishes[num].d, true);
		
		
		dfs(info);
		System.out.println(ans);
	}
	
	static void dfs(INFO info) {
		info.fishMove();
		
		for(int i = 1; i<4; ++i) {
			
			INFO next = new INFO(info);
			if(next.sharkMove(i)) {
				dfs(next);
			}
			
		}
	}
	
}
