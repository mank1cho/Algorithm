// https://www.acmicpc.net/problem/2615
// 오목
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2615 {
	
	static final int dx[] = {-1,0,1,1};
	static final int dy[] = {1,1,1,0};
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[19][19];
		
		for(int i = 0; i<19; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<19; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] ans = func();
		if(ans[0] == -1) System.out.println(0);
		else {
			System.out.println(ans[0]);
			System.out.println(ans[1]+" "+ans[2]);
		}
	}
	
	static int[] func() {
		for(int j = 0; j<19; ++j) {
			for(int i = 0; i<19; ++i) {
				if(map[i][j] == 0) continue;
				for(int k = 0; k<4; ++k) {
					int bx = i-dx[k];
					int by = j-dy[k];
					if(bx>=0&&by>=0&&bx<19&&by<19) {
						if(map[bx][by] == map[i][j]) continue;
					}
					int cnt = 1;
					int nx = i+dx[k];
					int ny = j+dy[k];
					while(nx>=0&&ny>=0&&nx<19&&ny<19&&map[nx][ny]==map[i][j]) {
						++cnt;
						nx+=dx[k];
						ny+=dy[k];
					}
					if(cnt == 5) {
						return new int[] {map[i][j], i+1, j+1};
					}
				}
			}
		}
		
		return new int[] {-1,-1,-1};
	}
	
}