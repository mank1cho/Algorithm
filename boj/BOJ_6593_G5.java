// https://www.acmicpc.net/problem/6593
// 상범 빌딩
// BFS
package boj;

import java.io.*;
import java.util.*;

public class BOJ_6593_G5 {

	static class INFO {
		int x, y, z, c;

		INFO(int x, int y, int z, int c) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.c = c;
		}
	}

	static final int dx[] = { 0, 0, 0, 0, 1, -1 };
	static final int dy[] = { 0, 0, 1, -1, 0, 0 };
	static final int dz[] = { 1, -1, 0, 0, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if(L == 0 && R == 0 && C == 0) break;
			
			Queue<INFO> q = new LinkedList<>();
			
			char[][][] map = new char[L][R][C];
			for (int i = 0; i < L; ++i) {
				for (int j = 0; j < R; ++j) {
					map[i][j] = br.readLine().toCharArray();
					for(int k = 0; k<C; ++k) {
						if(map[i][j][k] == 'S') {
							q.offer(new INFO(j,k,i,0));
							map[i][j][k] = '#';
						}
					}
				}
				br.readLine();
			}
			
			boolean f = false;
			a:while(!q.isEmpty()) {
				int x = q.peek().x;
				int y = q.peek().y;
				int z = q.peek().z;
				int c = q.poll().c+1;
				for(int i = 0; i<6; ++i) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					int nz = z+dz[i];
					if(nx<0||ny<0||nz<0||nx>=R||ny>=C||nz>=L||map[nz][nx][ny] == '#') continue;
					if(map[nz][nx][ny] == 'E') {
						sb.append("Escaped in "+c+" minute(s).").append('\n');
						f = true;
						break a;
					}
					map[nz][nx][ny] = '#';
					q.offer(new INFO(nx, ny, nz, c));
				}
			}
			
			if(!f) sb.append("Trapped!").append('\n');
			
		}
		System.out.println(sb);
	}
}