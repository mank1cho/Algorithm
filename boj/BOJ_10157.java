// https://www.acmicpc.net/problem/10157
// 자리배정
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_10157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		if(K>C*R) {
			System.out.println(0);
			return;
		}
		
		int[][] map = new int[R][C];
		int x = R-1;
		int y = 0;
		int d = 0;
		int num = 1;
		int dx[] = {-1,0,1,0};
		int dy[] = {0,1,0,-1};
		while(num<=R*C) {
			map[x][y] = num++;
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx<0||ny<0||nx==R||ny==C||map[nx][ny]!=0) {
				d = ++d%4;
				x+=dx[d];
				y+=dy[d];
				continue;
			}
			x=nx; y=ny;
		}

		for(int i = 0; i<R; ++i) {
			for(int j = 0; j<C; ++j) {
				if(map[i][j] == K) {
					System.out.println((j+1) + " " + (R-i));
					return;
				}
			}
		}
	}
}