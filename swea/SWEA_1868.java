// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LwsHaD1MDFAXc
// 1868. 파핑파핑 지뢰찾기
// 구현, BackTracking

package swea;

import java.io.*;
import java.util.*;

public class SWEA_1868 {

	static final int[] dx = {-1,-1,-1,0,0,1,1,1};
	static final int[] dy = {-1,0,1,-1,1,-1,0,1};
	static char[][] map;
	static boolean[][] visit;
	static int N;
	
	// 1. 0인 곳을 먼저 찾아야함. +1
	// 2. 0인 곳을 먼저 클릭해야함.
	// 3. 0이 아닌곳, 그리고 표시가 안된곳들을 클릭함.
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visit = new boolean[N][N];
			
			for(int i = 0; i<N; ++i) {
				map[i] = br.readLine().toCharArray();
			}
			
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					if(map[i][j] != '.') continue;
					int cnt = 0;
					for(int k = 0; k<8; ++k) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx<0||ny<0||nx>=N||ny>=N||map[nx][ny]!='*') continue;
						++cnt;	// 주변에 지뢰가 있을 때
					}
					map[i][j] = (char) (cnt + '0');
				}
			}
			// 맵에 별과 숫자로만 채웠어
			
			
			
			int ans = 0;
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					if(map[i][j] != '0' || visit[i][j]) continue;
					// 아직 방문하지 않은 0.
					++ans;
					dfs(i,j);
				}
			}
			
			
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					if(map[i][j] != '*' && !visit[i][j]) {
						++ans;
						// 아직 방문하지 않았고, 지뢰가 아닌곳.
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		if(map[x][y] != '0') return;
		for(int k = 0; k<8; ++k) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			if(nx<0||ny<0||nx>=N||ny>=N||visit[nx][ny]) continue;
			dfs(nx,ny);
			// 이 새로운 좌표에 있는 값이 0이면, 계속 dfs
			// 0이 아니라면? 숫자.
		}
	}
	
}