// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_ {
	
	static ArrayList<Integer>[] arr;
	static int[] num;
	static int ans = 0, cnt;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		num = new int[N+1];
		for(int i = 0; i<=N; ++i) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[y].add(x);
		}
		
		for(int i = 1; i<=N; ++i) {
			if(num[i]==0) {
				dfs(i);
			}
			System.out.println(Arrays.toString(num));
		}
		
	}
	
	static int dfs(int x) {
		if(num[x] != 0) return num[x];
		System.out.println(x);
		num[x] = 1;
		for(int i = 0; i<arr[x].size(); ++i) {
			int next = arr[x].get(i);
			if(num[next] != 0) {
				return num[x]=num[next];
			}
			else num[x]+=dfs(next);
		}
		
		return num[x];
	}
	
}