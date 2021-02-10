// https://www.acmicpc.net/problem/17406
// 배열 돌리기 4
// 구현
package boj;

import java.io.*;
import java.util.*;

public class BOJ_17406_G4 {

	static int N,M,K, ans = Integer.MAX_VALUE;
	static int[][] arr;
	static int[][] rcs;
	static int[] combi;
	static boolean[] check;
	
	final static int dx[] = {1,0,-1,0};
	final static int dy[] = {0,1,0,-1};
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       K = Integer.parseInt(st.nextToken());
       arr = new int[N][M];
       rcs = new int[K][3];
       combi = new int[K];
       check = new boolean[K];
       for(int i = 0; i<N; ++i) {
    	   st = new StringTokenizer(br.readLine());
    	   for(int j = 0; j<M; ++j) {
    		   arr[i][j] = Integer.parseInt(st.nextToken());
    	   }
       }
       
       for(int i = 0; i<K; ++i) {
    	   st = new StringTokenizer(br.readLine());
    	   for(int j = 0; j<3; ++j) {
    		   rcs[i][j] = Integer.parseInt(st.nextToken());;   
    	   }
       }
       
       dfs(0);
       System.out.println(ans);
    }
    
    static void dfs(int depth) {
    	if(depth == K) {
    		ans = Math.min(ans, rotate());
    		return;
    	}
    	
    	for(int i = 0; i<K; ++i) {
    		if(check[i]) continue;
    		check[i] = true;
    		combi[depth] = i;
    		dfs(depth+1);
    		check[i] = false;
    	}
    }
    
    static int rotate() {
    	int[][] test = new int[N][];
    	for(int i = 0; i<N; ++i) {
    		test[i] = arr[i].clone();
    	}
    	
    	for(int i = 0; i<K; ++i) {
    		int r = rcs[combi[i]][0]-1;
    		int c = rcs[combi[i]][1]-1;
    		int s = rcs[combi[i]][2];
    		
    		for(int j = 1; j<=s; ++j) {
    			int x = r - j;
    			int y = c - j;
    			int temp = test[x][y];
    			int d = 0;
    			while(d<4) {
    				int nx = x + dx[d];
    				int ny = y + dy[d];
    				if(nx<r-j||ny<c-j||nx>r+j||ny>c+j) {
    					++d; continue;
    				}
    				test[x][y] = test[nx][ny];
    				x = nx; y = ny;
    			}
    			test[r-j][c-j+1] = temp;
    		}
    	}

    	int cnt = Integer.MAX_VALUE;
    	for(int i = 0; i<N; ++i){
    		int sum = 0;
    		for(int j =0; j<M; ++j) {
    			sum+=test[i][j];
    		}
    		cnt = Math.min(cnt, sum);
    	}
    	return cnt;
    }
}