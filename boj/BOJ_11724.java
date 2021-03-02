// https://www.acmicpc.net/problem/11724
// 연결 요소의 개수
// dfs
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_11724 {
	
	static ArrayList<Integer>[] arr; //2차원 어레이리스트
    static boolean[] visit;	// 방문체크를 위한 boolean 배열
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[N+1]; //2차원 어레이리스트
        visit = new boolean[N+1];	// 방문체크를 위한 boolean 배열
        
        for(int i = 1; i<=N; ++i) {
        	arr[i] = new ArrayList<>();
        } //초기화 끝
        
        while(M-->0) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	// 3, 1
        	arr[u].add(v); // arr[3] add 1
        	arr[v].add(u); // arr[3] add 1
        }
        
        int ans = 0;
        for(int i = 1; i<=N; ++i) {
        	if(!visit[i]) {
        		++ans;
        		dfs(i);
        	}
        }
        
        System.out.println(ans);
    }
    
    static void dfs(int x) {
    	visit[x] = true;
    	for(int i = 0; i<arr[x].size(); ++i) {
    		int next = arr[x].get(i);
    		if(!visit[next]) {
    			dfs(next);
    		}
    	}
    }
}