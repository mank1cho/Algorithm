// https://www.acmicpc.net/problem/1194
// 달이 차오른다, 가자.
// BFS, Bit Masking
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1194_G1 {
	
	static class Pair{
		int x, y, bit, cnt;
		Pair(int x, int y, int bit, int cnt){
			this.x = x;
			this.y = y;
			this.bit = bit;
			this.cnt = cnt;
		}
	}
	
	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		
		int x = 0, y = 0;
		for(int i = 0; i<N; ++i) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j<M; ++j) {
				if(map[i][j] == '0') {
					x = i; y = j; map[i][j] = '.';
				}
			}
		}
		
		boolean[][][] visit = new boolean[N][M][1<<6];
		
		visit[x][y][0] = true;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y, 0, 0));
		while(!q.isEmpty()){
			x = q.peek().x;
			y = q.peek().y;
			int bit = q.peek().bit;
			int cnt = q.poll().cnt;
			//System.out.println(x + " " + y + " " + bit + " " + cnt);
			//System.out.println(Arrays.toString(visit[0]));
			
			for(int i = 0; i<4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0||ny<0||nx==N||ny==M||map[nx][ny]=='#'||visit[nx][ny][bit]==true) continue;
				char c = map[nx][ny];
				
				if(c == '1') {
					System.out.println(cnt+1);
					return;
				}
				else if(c>='a' && c<='z') {
					visit[nx][ny][bit|1<<map[nx][ny]-'a'] = true;
					q.offer(new Pair(nx, ny, bit|1<<map[nx][ny]-'a', cnt+1));
					continue;
				}
				else if(c>='A' && c<='Z'){
					char shift = Character.toLowerCase(c);
					if((bit&1<<shift-'a') == 0) {
						continue;
					}
				}
				
				visit[nx][ny][bit] = true;
				q.offer(new Pair(nx, ny, bit, cnt+1));
			}
		}
		
		System.out.println(-1);
	}
}