// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_ {
	
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	static int N, sharkSize = 2, sharkEatFishCount, time;
	static int[][] map;
	static int sharkX, sharkY;

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input(br);

		// BFS를 얼마나 돌려야 할까???
		while(BFS());
		
		System.out.println(time);
	}
	
	static void input(BufferedReader br) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
				}
			}
		}
	}
	
	static boolean BFS() {
		boolean sharkEatFish = false;
		Queue<Pair> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		visited[sharkX][sharkY] = true;
		q.add(new Pair(sharkX, sharkY));
		
		int fishX = INF, fishY = INF;
		int sharkMove = 0;	// 상어의 이동 거리
		
		while(!q.isEmpty()) {
			sharkMove++;
			
			int size = q.size();
			while(size-->0){
				Pair now = q.poll();
				
				for(int i = 0; i<4; ++i) {
					int nx = now.x+dx[i];
					int ny = now.y+dy[i];
					if(!babySharkCanGo(nx, ny, visited)) continue;
					
					visited[nx][ny] = true;
					
					if(babySharkCanEatFish(nx, ny)) {
						sharkEatFish = true;
						if(futherUpOrLeft(nx, ny, fishX, fishY)) {
							fishX = nx;
							fishY = ny;
						}
					}
					else {
						q.add(new Pair(nx, ny));
					}
				}
			}
			
			if(sharkEatFish) {
				update(fishX, fishY, sharkMove);
				return true;
			}
		}
		
		return false;
	}
	
	static boolean futherUpOrLeft(int nx, int ny, int fishX, int fishY){
		return nx<fishX || (nx == fishX && ny<fishY);
	}
	
	// 아기상어 위치를 바꿔줘야겠죠?
	// 맵도 바꿔줘야겠죠?
	// 상어 크기도 바꿔줘야겠죠? 상어는 사이즈만큼 물고기를 먹으면 사이즈가 커짐
	// 걸린 시간도 더해줍니다.
	static void update(int fishX, int fishY, int sharkMove) {
		sharkX = fishX;
		sharkY = fishY;
		map[sharkX][sharkY] = 0;
		sharkEatFishCount++;
		if(sharkEatFishCount == sharkSize) {
			sharkSize++;
			sharkEatFishCount = 0;
		}
		time+=sharkMove;
	}
	
	static boolean babySharkCanEatFish(int nx, int ny) {
		if(map[nx][ny]>0 && map[nx][ny] < sharkSize) return true;
		return false;
	}
	
	static boolean babySharkCanGo(int x, int y, boolean[][] visited) {
		return x>=0&&y>=0&&x<N&&y<N&&map[x][y]<=sharkSize&&!visited[x][y];
	}
	
	static void printmap() {
		System.out.println();
		System.out.println("====debug=====");
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<N; ++j) {
				System.out.print(map[i][j]);
			}System.out.println();
		}
	}
	
}
