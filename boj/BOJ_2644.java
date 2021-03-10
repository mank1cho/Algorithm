// https://www.acmicpc.net/problem/2644
// 촌수계산
// dfs
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_2644 {

	static int N, x, y, ans = -1;
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        visit = new boolean[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        while(M-->0) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	if(arr[u] == null) arr[u] = new ArrayList<>();
        	if(arr[v] == null) arr[v] = new ArrayList<>();
        	arr[u].add(v);
        	arr[v].add(u);
        }
        
        dfs(x, 0);
        
        System.out.println(ans);
    }
    
    static void dfs(int x, int cnt) {
    	visit[x] = true;
    	for(int i = 0; i<arr[x].size(); ++i) {
    		int next = arr[x].get(i);
    		if(flag) return;
    		if(visit[next]) continue;
    		if(next == y) {
    			ans = cnt+1;
    			flag = true;
    		}
    		dfs(next, cnt+1);
    	}
    }
}