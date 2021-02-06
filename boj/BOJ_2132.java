// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.*;
import java.util.*;


// 푸는중
public class BOJ_2132 {
	
	static int SUM;
	static int[] num;
	static boolean[] check;
	static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        adj = new ArrayList[N+1];
        num = new int[N+1];
        check = new boolean[N+1];

        for(int i = 1; i<=N; ++i) {
        	num[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i<N-1; ++i) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	if(adj[x] == null) adj[x] = new ArrayList<>();
        	if(adj[y] == null) adj[y] = new ArrayList<>();
        	if(c(x,y)) adj[x].add(y);
        	if(c(y,x)) adj[y].add(x);
        }
        
        int idx = -1, sum = 0;
        for(int i = 1; i<=N; ++i) {
        	if(adj[i].size() == 1) {
        		// SUM, check
        		Arrays.fill(check, false);
        		check[i] = true;
        		dfs(i, num[i]);
        		if(SUM>sum) {
        			sum = SUM;
        			idx = i;
        		}
        		SUM = 0;
        	}
        }
        
        System.out.println(sum + " "+ idx);
    }
    
    static boolean c(int x, int y) {
    	for(int i = 0; i<adj[x].size(); ++i) {
    		if(adj[x].get(i) == y) return false;
    	}
    	return true;
    }
    
    static void dfs(int x, int sum) {
    	if(sum!=num[x] && adj[x].size() == 1) {
    		SUM = Math.max(sum,SUM);
    		return;
    	}
    	
    	for(int i = 0; i<adj[x].size(); ++i) {
    		int next = adj[x].get(i);
    		if(check[next]) continue;
    		check[next] = true;
    		dfs(next, sum+num[next]);
    	}
    }
    
    
}
