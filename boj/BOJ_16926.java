// https://www.acmicpc.net/problem/16926
// 배열 돌리기1
// 구현
package boj;

import java.io.*;
import java.util.*;

public class BOJ_16926 {

	final static int[] dx = {0,1,0,-1};
	final static int[] dy = {1,0,-1,0};
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       int R = Integer.parseInt(st.nextToken());
       int[][] map = new int[N][M];
       
       for(int i = 0; i<N; ++i) {
    	   st = new StringTokenizer(br.readLine());
    	   for(int j = 0; j<M; ++j) {
    		   map[i][j] = Integer.parseInt(st.nextToken());
    	   }
       }
       
       int group = Math.min(N, M)/2;
       for(int i = 0; i<R; ++i) {
    	   for(int j = 0; j<group; ++j) {
    		   int x = j;
    		   int y = j;
    		   int temp = map[x][y];
    		   int d = 0;
    		   while(d<4) {
    			   int nx = x+dx[d];
    			   int ny = y+dy[d];
    			   if(nx<j||ny<j||nx>=N-j||ny>=M-j) {
    				   ++d;
    				   continue;
    			   }
    			   map[x][y] = map[nx][ny];
    			   x = nx;  y = ny;
    		   }
    		   map[j+1][j] = temp;
    	   }
       }
       
       for(int i = 0; i<N; ++i) {
    	   for(int j = 0; j<M; ++j) {
    		   sb.append(map[i][j]).append(" ");
    	   }sb.append('\n');
       }
       System.out.println(sb);
    }
}