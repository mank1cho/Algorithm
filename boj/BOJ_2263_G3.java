// https://www.acmicpc.net/problem/2263
// 트리의 순회
// 재귀
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2263_G3 {
	static int N;
	static int[] inorder, postorder, idx;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		inorder = new int[N+1];
		postorder = new int[N+1];
		idx = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; ++i) {
			inorder[i] = Integer.parseInt(st.nextToken());
			idx[inorder[i]] = i; 
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; ++i) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(1,N,1,N);
		System.out.println(sb);
	}
	
	public static void solve(int inS, int inE, int postS, int postE) {
		if(inS>inE || postS>postE) return;
		
		int root = postorder[postE];
		sb.append(root).append(' '); 
		
		int rootidx = idx[root];
		int left = rootidx - inS;
		int right = inE - rootidx;
		
		solve(inS, rootidx-1, postS, postS+left-1);
		solve(rootidx+1, inE, postS+left, postE-1);
	}

}