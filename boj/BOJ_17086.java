// https://www.acmicpc.net/problem/17086
// 아기 상어2
// BFS
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_17086 {
 
	static class Pair{
		int x,y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
    static final int dx[] = {-1,-1,-1,0,1,1,1,0};
    static final int dy[] = {-1,0,1,1,1,0,-1,-1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i<N; ++i) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j<M; ++j) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j]==1) {
        			q.offer(new Pair(i, j));
        		}
        	}
        }

        while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			for(int k = 0; k<8; ++k) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx<0||ny<0||nx==N||ny==M||map[nx][ny]!=0) continue;
				map[nx][ny] = map[x][y]+1;
				q.offer(new Pair(nx, ny));
			}
		}
        
        int ans = 0;
        for(int i = 0; i<N; ++i) {
        	for(int j = 0; j<M; ++j) {
        		ans=Math.max(ans, map[i][j]);
        	}
        }

        System.out.println(ans-1);
    }
}