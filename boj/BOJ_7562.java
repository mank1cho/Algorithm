// https://www.acmicpc.net/problem/7562
// 나이트의 이동
// BFS
package boj;

import java.io.*;
import java.util.*;

public class BOJ_7562 {
	static class POS{
		int x, y;
		POS(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static final int[] dx = {-1,-2,-2,-1,1,2,2,1};
	static final int[] dy = {-2,-1,1,2,2,1,-1,-2};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			boolean[][] visit = new boolean[N][N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int gx = Integer.parseInt(st.nextToken());
			int gy = Integer.parseInt(st.nextToken());
			
			Queue<POS> q = new LinkedList<>();
			q.offer(new POS(sx,sy));
			visit[sx][sy] = true;
			
			int cnt = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				while(size-->0) {
					POS now = q.poll();
					if(now.x == gx && now.y == gy) {
						sb.append(cnt).append('\n');
						q.clear();
						break;
					}
					for(int i = 0; i<8; ++i) {
						int nx = now.x+dx[i];
						int ny = now.y+dy[i];
						if(nx<0||ny<0||nx>=N||ny>=N||visit[nx][ny]==true) continue;
						q.offer(new POS(nx,ny));
						visit[nx][ny] = true;
					}
				}
				++cnt;
			}	
		}
		
		System.out.print(sb);
	}
}