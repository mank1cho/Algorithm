// https://www.acmicpc.net/problem/5639
// 이진 검색 트리
// 트리
package boj;

import java.io.*;

public class BOJ_5639 {
	
	static int[] tree = new int[10000];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		int idx = 0;
		while((s=br.readLine()) != null && s.length() != 0) {
			int n = Integer.parseInt(s);
			tree[idx++] = n;
		}
		
		tree[idx] = Integer.MAX_VALUE;
		postorder(0, idx-1);
		
		System.out.println(sb);
	}
	
	static void postorder(int left, int right) {
		int root = left;
		int sub = left++;
		while(tree[++sub] < tree[root]);
		if(left<=sub-1) postorder(left, sub-1);
		if(sub<=right) postorder(sub,right);
		sb.append(tree[root]).append('\n');
	}
}