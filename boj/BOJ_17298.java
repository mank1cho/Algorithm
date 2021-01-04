// https://www.acmicpc.net/problem/17298  오큰수
// stack
package boj;

import java.io.*;
import java.util.*;

public class BOJ_17298 {
	public static class Pair{
		int var;
		int idx;
		Pair(int var, int idx){
			this.var = var;
			this.idx = idx;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ans = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Pair> stack = new Stack<>();
		
		for(int i = 0; i<N; ++i) {
			int x = Integer.parseInt(st.nextToken());
			while(stack.empty() == false && stack.peek().var<x) {
				ans[stack.peek().idx] = x;
				stack.pop();
			}
			stack.push(new Pair(x, i));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; ++i) {
			if(ans[i] == 0) sb.append(-1);
			else sb.append(ans[i]);
			sb.append(" ");
		}
		System.out.print(sb);
	}
}