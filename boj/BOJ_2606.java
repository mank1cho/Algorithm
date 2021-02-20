// https://www.acmicpc.net/problem/2606
// 바이러스
// dfs
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2606 {
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[N+1];
		visit = new boolean[N+1];
		for(int i = 1; i<=N; ++i) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		
		visit[1] = true;
		dfs(1);
		System.out.println(ans-1);
	}
	
	static void dfs(int now) {
		++ans;
		for(int i = 0; i<arr[now].size(); ++i) {
			int next = arr[now].get(i);
			if(!visit[next]) {
				visit[next] = true;
				dfs(next);
			}
		}
	}
	
}
