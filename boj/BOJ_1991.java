// https://www.acmicpc.net/problem/1991
// 트리 순회
// 트리
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1991 {
	static class pair{
		int left, right;
		pair(){}
		pair(int l, int r){
			left= l;
			right = r;
		}
	}
	
	static pair[] tree = new pair[26];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int root = st.nextToken().charAt(0)-'A';
			int left = st.nextToken().charAt(0)-'A';
			int right = st.nextToken().charAt(0)-'A';
			tree[root] = new pair();
			if(left>=0) tree[root].left = left;
			if(right>=0) tree[root].right = right;
			
		}
		
		preorder(0);
		sb.append('\n');
		inorder(0);
		sb.append('\n');
		postorder(0);
		System.out.println(sb);
	}
	
	static void preorder(int root) {
		sb.append((char) (root+'A'));
		int left = tree[root].left;
		int right = tree[root].right;
		if(left>0) preorder(left);
		if(right>0) preorder(right);
	}
	static void inorder(int root) {
		int left = tree[root].left;
		int right = tree[root].right;
		if(left>0) inorder(left);
		sb.append((char) (root+'A'));
		if(right>0) inorder(right);
	}
	static void postorder(int root) {
		int left = tree[root].left;
		int right = tree[root].right;
		if(left>0) postorder(left);
		if(right>0) postorder(right);
		sb.append((char) (root+'A'));
	}
}