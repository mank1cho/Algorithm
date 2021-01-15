// https://www.acmicpc.net/problem/1068
// 트리
// tree
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1068 {
	static ArrayList<Integer>[] array;
	static int d;
	static int ans;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		array = new ArrayList[N];
		
		int root = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			int x = Integer.parseInt(st.nextToken());
			if(x==-1) {
				root = i;
				continue;
			}
			if(array[x] == null) array[x] = new ArrayList<>();
			array[x].add(i);
		}
		
		d = Integer.parseInt(br.readLine());
		dfs(root);
		System.out.print(ans);
	}
	
	public static void dfs(int x) {
		if(x == d) return;
		if(array[x] == null) {
			++ans;
			return;
		}
		if(array[x].size() == 1 && array[x].get(0) == d) {
			++ans;
			return;
		}
		for(int i = 0; i<array[x].size(); ++i) {
			dfs(array[x].get(i));
		}
	}
	
}