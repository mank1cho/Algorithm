// https://www.acmicpc.net/problem/3109
// 빵집
// dfs, 그리디
package boj;

import java.io.*;
import java.util.*;

public class BOJ_3109_G2 {
	static boolean flag = false;
	static char[][] map;
	static int R, C, ans;
	static final int dx[] = {-1,0,1};	//위 대각선위 오른쪽 대각선아래 아래
	static final int dy[] = {1,1,1};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		for(int i = 0; i<R; ++i) {
			map[i] = br.readLine().toCharArray();
			map[i][0] = 'x';
		}
		
		for(int i = 0; i<R; ++i) {
			flag = false;
			dfs(i,0);
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int x, int y) {
		if(flag) return;
		for(int i = 0; i<3; ++i) {
			if(flag) return;
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<1||nx>=R||map[nx][ny]!='.') continue;
			map[nx][ny] = '*';
			if(ny==C-1) {
				flag = true;
				++ans;
				return;
			}
			dfs(nx,ny);
		}
	}
}