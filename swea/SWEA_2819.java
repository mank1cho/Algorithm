// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7I5fgqEogDFAXB&categoryId=AV7I5fgqEogDFAXB&categoryType=CODE
// 격자판의 숫자 이어붙이기

package swea;

import java.io.*;
import java.util.*;

public class SWEA_2819 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int ans;
	static int[] visit;
	static int[][] map;
	static int[] combi;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t<=T; ++t) {
			ans = 0;
			visit = new int[10000000];
			combi = new int[7];
			map = new int[4][4];
			
			for(int i = 0; i<4; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<4; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i<4; ++i) {
				for(int j = 0; j<4; ++j) {
					dfs(i,j,0);
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");			
		}
		
		System.out.print(sb);
	}
	
	public static void dfs(int x, int y, int depth) {
		if(depth == 7) {
			StringBuilder s = new StringBuilder();
			for(int i = 0; i<7; ++i) {
				s.append(combi[i]);
			}
			int num = Integer.parseInt(s.toString());
			if(visit[num] == 0) {
				visit[num] = 1;
				++ans;
			}
			return;
		}
		
		for(int i = 0; i<4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0||ny<0||nx>3||ny>3) continue;
			combi[depth] = map[nx][ny];
			dfs(nx,ny,depth+1);
		}
	}
}
