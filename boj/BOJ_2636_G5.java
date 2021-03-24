// https://www.acmicpc.net/problem/2636
// 치즈
// BFS
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2636_G5 {

	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		
		int cheeseCount = 0;
		for(int i = 0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheeseCount++;
			}
		}
		
		if(cheeseCount == 0) {
			System.out.println(0);
			System.out.println(0);
			return;
		}
		
		int time = 0;
		while(true) {
			time++;
			int nextCheeseCount = BFS(map, visit, cheeseCount, N, M);
			if(nextCheeseCount == 0) break;
			cheeseCount = nextCheeseCount;
		}
		
		System.out.println(time);
		System.out.println(cheeseCount);
	}
	
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static int BFS(int[][] map, boolean[][] visit, int cheeseCount, int N, int M) {
		Queue<Pair> q = new LinkedList<>();
		Queue<Pair> cheese = new LinkedList<>();
		
		for(int i = 0; i<N; ++i) {
			Arrays.fill(visit[i], false);
		}
		
		q.add(new Pair(0,0));
		visit[0][0] = true;
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			for(int i = 0; i<4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(!isIn(nx, ny, N, M, visit)) continue;
				visit[nx][ny] = true;
				if(map[nx][ny] == 0) q.add(new Pair(nx, ny));
				else cheese.add(new Pair(nx, ny));
			}
		}
		int removedCount = cheese.size();
		while(!cheese.isEmpty()) {
			int x = cheese.peek().x;
			int y = cheese.poll().y;
			map[x][y] = 0;
		}
		
		return cheeseCount - removedCount;
	}
	
	public static boolean isIn(int x, int y, int N, int M, boolean[][] visit) {
		return x>=0&&y>=0&&x<N&&y<M&&!visit[x][y];
	}

}