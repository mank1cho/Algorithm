// https://www.acmicpc.net/problem/16236
// 아기상어
// BFS
package boj;

import java.io.*;
import java.util.*;

public class BOJ_16236_G4 {
	
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int x = 0, y = 0;
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					x = i;
					y = j;
					map[i][j] = 0;
				}
			}
		}
		
		int sharksize = 2;
		int fishCnt = 0;
		int ans = 0;
		boolean visit[][] = new boolean[N][N];
		
		while(true) {
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {x,y});
			visit[x][y] = true;
			int dis = 0, mx = 999, my = 999;
			while(!q.isEmpty()) {
				++dis;
				int size = q.size();
				while(size-->0) {
					int xx = q.peek()[0];
					int yy = q.poll()[1];
					for(int i = 0; i<4; ++i) {
						int nx = xx+dx[i];
						int ny = yy+dy[i];
						if (nx < 0 || ny<0 || nx == N || ny == N || map[nx][ny]>sharksize || visit[nx][ny]) continue;
						if (map[nx][ny]>0 && map[nx][ny] < sharksize) {
							if (nx < mx) {mx = nx; my = ny;}
							else if (nx == mx && ny < my) {mx = nx; my = ny;}
						}
						q.offer(new int[] {nx,ny});
						visit[nx][ny] = true;
					}
				}
				if(mx != 999) {
					ans+=dis;
					x = mx;
					y = my;
					map[x][y] = 0;
					fishCnt++;
					if(sharksize==fishCnt) {
						sharksize++;
						fishCnt=0;
					}
					break;
				}
			}
			if(mx == 999) break;
			for(int i = 0; i<N; ++i) Arrays.fill(visit[i], false);
		}
		
		System.out.println(ans);
	}
}
