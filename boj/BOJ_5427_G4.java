// https://www.acmicpc.net/problem/5427
// 불
// BFS
package boj;

import java.io.*;
import java.util.*;

public class BOJ_5427_G4 {
	static class INFO{
		char c;
		int x, y, cnt;
		INFO(int x, int y, char c, int cnt){
			this.x = x;
			this.y = y;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			char[][] map = new char[N][M];
			
			int sx = 0, sy = 0;
			Queue<INFO> q = new LinkedList<>();
			for(int i = 0; i<N; ++i) {
				map[i] = br.readLine().toCharArray();
				for(int j = 0; j<M; ++j) {
					if(map[i][j] == '*') {
						q.offer(new INFO(i, j, '*', 0));
					}
					else if(map[i][j] == '@') {
						sx = i; sy = j;
					}
				}
			}
			// 큐에 불 먼저 넣어주고, 상근이를 넣어줌.
			// 그럼 bfs에서는 불-상근이 순으로 퍼지게 됨
			
			/*
			 * ex) 첫번째 동작 : 불-불-불-상근이
			 * 두번째 : 불-불-불-불-불-불-상근이-상근이-상근이
			 * 세번째 : 불-불-불-불-불-불-불-불-상근이-상근이-상근이-상근이-상근이
			 * 뭐 이런식으로..
			 * 아무튼 불 먼저 퍼진 다음에 상근이가 퍼진다는 규칙만 만족하면 된다는것.
			 */
			
			q.offer(new INFO(sx, sy, '@', 0));
			int ans = bfs(q, map, N, M);
			if(ans==-1) sb.append("IMPOSSIBLE").append('\n');
			else sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	
	static int bfs(Queue<INFO> q, char[][] map, int N, int M) {
		while(!q.isEmpty()) {
			INFO now = q.poll();
			
			for(int i = 0; i<4; ++i) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M) {
					if(now.c == '@') return now.cnt+1;	//맵 바깥으로 상근이가 탈출!
					else continue;
				}
				if(now.c == '*') {	// 불일때
					// 불은 빈칸 or 상근이가 있는 칸으로 움직일 수 있음.
					if(map[nx][ny] == '.' || map[nx][ny] == '@') {
						map[nx][ny] = '*';
						q.offer(new INFO(nx, ny, '*', 0));
					}
				}
				else {	// 상근이일때
					if(map[nx][ny] == '.') {	//상근이는 빈칸으로만 움직일 수 있음.
						map[nx][ny] = '@';
						q.offer(new INFO(nx, ny, '@', now.cnt+1));
					}
				}
			}
			
		}
		return -1;		// 탈출 못하면 -1 return
	}
}