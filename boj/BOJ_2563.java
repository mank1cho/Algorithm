// https://www.acmicpc.net/problem/2563
// 색종이
// 구현
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2563 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       boolean[][] map = new boolean[101][101];
       while(N-->0) {
    	   StringTokenizer st = new StringTokenizer(br.readLine());
    	   int x = Integer.parseInt(st.nextToken());
    	   int y = Integer.parseInt(st.nextToken());
    	   for(int i = x; i<x+10; ++i) {
    		   for(int j = y; j<y+10; ++j) {
    			   map[i][j] = true;
    		   }
    	   }
       }
       int ans = 0;
       for(int i = 1; i<101; ++i) {
    	   for(int j = 1; j<101; ++j) {
    		   ans+=map[i][j]?1:0;
    	   }
       }
       System.out.print(ans);
    }
}