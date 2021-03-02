// https://www.acmicpc.net/problem/9328
// 열쇠
// BFS, BitMasking
package boj;

import java.io.*;
import java.util.*;

public class BOJ_9328_G1 {
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M, keybit, ans;
	static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
        	input(br);
        	bfs();
        	sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }

    static void input(BufferedReader br) throws IOException {
    	ans = 0;
    	
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
        		map[i][j] = s.charAt(j-1);
        	}
        }
        
        keybit = 0;
        String key = br.readLine();
        if(!key.equals("0")) {
        	for(int i = 0; i<key.length(); ++i) {
        		keybit|=1<<key.charAt(i)-'a';
        	}
        }
    }
    
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    
    static void bfs() {
    	Queue<Pair> q = new LinkedList<>();
    	Queue<Pair> door = new LinkedList<>();
    	q.offer(new Pair(0,0));
    	boolean[][] visit = new boolean[N+2][M+2];
    	visit[0][0] = true;
    	
    	while(!q.isEmpty()) {
    		int size = q.size();
    		while(size-->0) {
    			int x = q.peek().x;
        		int y = q.poll().y;
        		for(int i = 0; i<4; ++i) {
        			int nx = x + dx[i];
        			int ny = y + dy[i];
        			if(nx<0||ny<0||nx==N+2||ny==M+2||visit[nx][ny]||map[nx][ny]=='*') continue;
        			if(map[nx][ny]>='A' && map[nx][ny]<='Z') {
        				if((keybit&1<<map[nx][ny]-'A') == 0) {	// 열쇠가 없는 경우
        					door.offer(new Pair(nx, ny));
        				}
        				else {
        					q.offer(new Pair(nx, ny));
        				}
        			}
        			else {
        				if(map[nx][ny] == '$') ans++;
        				else if(map[nx][ny]>='a' && map[nx][ny]<='z') {
        					keybit|=1<<map[nx][ny]-'a';
        				}
            			q.offer(new Pair(nx, ny));
        			}
        			visit[nx][ny] = true;
        		}
    		}
    		
    		size = door.size();
    		while(size-->0) {
    			int x = door.peek().x;
    			int y = door.poll().y;
    			if((keybit&1<<map[x][y]-'A') != 0) {
					q.offer(new Pair(x, y));
				}
    			else door.offer(new Pair(x, y));
    		}
    	}
    	
    }
}