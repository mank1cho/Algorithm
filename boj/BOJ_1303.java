// https://www.acmicpc.net/problem/1303
// 전쟁-전투
// dfs
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1303 {
	static char[][] map;
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for(int i = 0; i<N; ++i) {
			map[i] = br.readLine().toCharArray();
		}
		
		int w = 0, b = 0;
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<M; ++j) {
				if(map[i][j]=='W') {
					int x = dfs(i,j, map[i][j]);
					w+=x*x;
				}
				else if(map[i][j] == 'B') {
					int x = dfs(i,j, map[i][j]);
					b+=x*x;
				}
			}
		}
		
		System.out.println(w + " " + b);
	}
	
	static int dfs(int x, int y, char c) {
		map[x][y] = '.';
		int cnt = 1;
		for(int i = 0; i<4; ++i) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx==N||ny==M||map[nx][ny]!=c) continue;
			map[nx][ny] = '.';
			cnt+=dfs(nx, ny, c);
		}
		return cnt;
	}
}
