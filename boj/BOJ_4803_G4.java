// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


// 미완
public class BOJ_4803_G4 {

	static int N, M;
	static boolean[][] visit;
	static ArrayList<Integer>[] adj;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = 0;
        while(true) {
        	t++;
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	if(N == 0 && M == 0) break;
        	
        	visit = new boolean[2][N+1];
        	adj = new ArrayList[N+1];
        	
        	for(int i = 1; i<=N; ++i) {
        		adj[i] = new ArrayList<>();
        	}
        	
        	for(int i = 0; i<M; ++i) {
        		st = new StringTokenizer(br.readLine());
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		if(adj[x] == null) adj[x] = new ArrayList<>();
        		if(adj[y] == null) adj[y] = new ArrayList<>();
        		adj[x].add(y);
        		adj[y].add(x);
        	}
        	
        	System.out.println();
        	int cnt = 0;
        	for(int i = 1; i<=N; ++i) {
        		if(visit[0][i]) continue;
        		int v = v(i);
        		int e = e(i);
        		System.out.println(v + "  " + e);
        		if(v-1 == e/2) ++cnt;
        	}
        	sb.append("Case ").append(t).append(": ");
        	if(cnt == 0) {
        		sb.append("No trees.");
        	}
        	else if(cnt == 1) {
        		sb.append("There is one tree.");
        	}
        	else {
        		sb.append("A forest of ").append(cnt).append(" trees.");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static int v(int x) {
    	int cnt = 1;
    	visit[0][x] = true;
    	for(int i = 0; i<adj[x].size(); ++i) {
    		int next = adj[x].get(i);
    		if(!visit[0][next]) cnt+=v(next);
    	}
    	return cnt;
    }
    
    static int e(int x) {
    	int cnt = adj[x].size();
    	visit[1][x] = true;
    	for(int i = 0; i<adj[x].size(); ++i) {
    		int next = adj[x].get(i);
    		if(!visit[1][x]) cnt+=e(next);
    	}
    	return cnt;
    }
    
}
