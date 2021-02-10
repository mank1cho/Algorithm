// https://www.acmicpc.net/problem/2178
// 미로 탐색
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2178 {
	
	static class pair{
		int x, y;
		pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       char[][] map = new char[N][];
       for(int i = 0; i<N; ++i) {
    	   map[i] = br.readLine().toCharArray();
       }
       
       map[0][0] = '0';
       
       Queue<pair> q = new LinkedList<>();
       q.offer(new pair(0,0));
       int ans = 0;
       while(!q.isEmpty()) {
    	   ++ans;
    	   int size = q.size();
    	   while(size-->0) {
    		   int x = q.peek().x;
    		   int y = q.poll().y;
    		   for(int i = 0; i<4; ++i) {
    			   int nx = x+dx[i];
    			   int ny = y+dy[i];
    			   if(nx<0||ny<0||nx==N||ny==M||map[nx][ny] == '0') continue;
    			   if(nx == N-1 && ny == M-1) {
    				   System.out.println(ans+1);
    				   return;
    			   }
    			   map[nx][ny] = '0';
    			   q.offer(new pair(nx, ny));
    		   }
    	   }
       }
    }
}