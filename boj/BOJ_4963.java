// https://www.acmicpc.net/problem/4963
// 섬의 개수
// dfs
package boj;

import java.io.*;
import java.util.*;

public class BOJ_4963 {

	static final int[] dx = {-1,-1,-1,0,0,1,1,1};
	static final int[] dy = {-1,0,1,-1,1,-1,0,1};
	static boolean[][] map;
	static boolean[][] visit;
	static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(r==0&&c==0) break;
            
            map = new boolean[r][c];
            visit = new boolean[r][c];
            
            ans = 0;
            for(int i = 0; i<r; ++i) {
            	st = new StringTokenizer(br.readLine());
            	for(int j = 0; j<c; ++j) {
            		map[i][j] = Integer.parseInt(st.nextToken())==1;
            	}
            }
        	
            for(int i = 0; i<r; ++i) {
            	for(int j = 0; j<c; ++j) {
            		if(visit[i][j] || !map[i][j]) continue;
            		++ans;
            		dfs(i,j,r,c);
            	}
            }
            
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
    
    static void dfs(int x, int y, int r, int c) {
    	visit[x][y] = true;
    	for(int i = 0; i<8; ++i) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		if(nx<0||ny<0||nx==r||ny==c||visit[nx][ny]||!map[nx][ny]) continue;
    		dfs(nx,ny,r,c);
    	}
    }
}
