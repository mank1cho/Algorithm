// https://www.acmicpc.net/problem/1725
// 히스토그램
// Stack
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1725_P5 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
				
		int[] h = new int[N];
		for(int i = 0; i<N; ++i) {
			h[i] = Integer.parseInt(br.readLine());
		}
				
		long area = 0;
		for(int i = 0; i<N; ++i) {
			while(!stack.isEmpty() && h[stack.peek()] > h[i]) {
				long height = h[stack.peek()];
				stack.pop();
				long width = i;
					if(!stack.isEmpty()) {
					width = i - stack.peek() - 1;
				}
				area = Math.max(area, width*height);
				}
				stack.push(i);
			}
				
		while(!stack.isEmpty()) {
			long height = h[stack.peek()];
			stack.pop();
			long width = N;
			if(!stack.isEmpty()) width = N - stack.peek() - 1;
				area = Math.max(area, width*height);
		}	
		
		System.out.print(area);
	}
}