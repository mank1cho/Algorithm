// https://www.acmicpc.net/problem/9328
// 열쇠
// BFS, BitMasking
package boj;

import java.io.*;
import java.util.*;
		
public class BOJ_9328_G1 {

	static int N, M;
	static char[][] map;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
        	input(br);
        	sb.append(bfs()).append('\n');
        }

        System.out.println(sb);
    }
    
    static void input(BufferedReader br) throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new char[N+2][M+2];
        for(int i = 0; i<N+2; ++i) {
        	map[i][0] = '.';
        	map[i][M+1] = '.';
        }
        for(int i = 0; i<M+2; ++i) {
        	map[0][i] = '.';
        	map[N+1][i] = '.';
        }
        
        for(int i = 1; i<=N; ++i) {
        	String s = br.readLine();
        	for(int j = 1; j<=M; ++j) {
        		map[i][j] = s.charAt(j);
        	}
        }
        
        int keybit = 0;
        String key = br.readLine();
        if(!key.equals("0")) {
        	for(int i = 0; i<key.length(); ++i) {
        		keybit|=1<<key.charAt(i)-'a';
        	}
        }

        
    }
    
    static int bfs() {
    	int ret = 0;
    	return ret;
    }
}