// https://www.acmicpc.net/problem/5567
// 결혼식
// dfs
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_5567 {
 
	static int n, m, ans;
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new ArrayList[n+1];
        visit = new boolean[n+1];
        
        for(int i = 1; i<=n; ++i) {
        	arr[i] = new ArrayList<>();
        }
        
        while(m-->0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	arr[u].add(v);
        	arr[v].add(u);
        }

        for(int i = 0; i<arr[1].size(); ++i) {
        	int next = arr[1].get(i);
        	visit[next] = true;
        	for(int j = 0; j<arr[next].size();++j) {
        		int next2 = arr[next].get(j);
        		visit[next2] = true;
        	}
        }
        
        for(int i = 2; i<=n; ++i)
        	if(visit[i]) ++ans;
        
        System.out.println(ans);
    }    
}