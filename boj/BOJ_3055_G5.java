// https://www.acmicpc.net/problem/3055
// 탈출
// BFS
package boj;

import java.io.*;
import java.util.*;

public class BOJ_3055_G5 {
	
	static class INFO{
		int x, y;
		char c;
		INFO(int x, int y, char c){
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		Queue<INFO> q = new LinkedList<>();
		char[][] map = new char[R][C];
		int sx = 0, sy = 0;
		for(int i = 0; i<R; ++i) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j<C; ++j) {
				if(map[i][j] == '*') {
					q.offer(new INFO(i, j, '*'));
				}
				else if(map[i][j] == 'S') {
					sx = i; sy = j;
				}
			}
		}
		
		q.offer(new INFO(sx,sy,'S'));
		
		int cnt = 0;
		boolean f = false;
		b: while(!q.isEmpty()) {
			++cnt;
			int size = q.size();
			while(size-->0) {
				INFO now = q.poll();
				for(int i = 0; i<4; ++i) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					if(nx<0||ny<0||nx==R||ny==C) continue;
					if(now.c=='S') {
						if(map[nx][ny] == 'D') {f = true; break b;}
						else if(map[nx][ny] != '.') continue;
					}
					else if(now.c == '*') {
						if(map[nx][ny]!='.'&& map[nx][ny]!='S') continue;
					}
					map[nx][ny] = now.c;
					q.offer(new INFO(nx, ny, now.c));
				}
			}
		}
		if(f) System.out.println(cnt);
		else System.out.println("KAKTUS");
	}
} 
