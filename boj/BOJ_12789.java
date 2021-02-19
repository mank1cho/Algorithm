// https://www.acmicpc.net/problem/12789
// 도키도키 간식드리미
// 스택
package boj;

import java.io.*;
import java.util.*;

public class BOJ_12789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int x = 1;
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(n-->0) {
			stack.push(Integer.parseInt(st.nextToken()));
			while(!stack.isEmpty() && x==stack.peek()) {
				++x;
				stack.pop();
			}
		}
		if(stack.isEmpty()) System.out.println("Nice");
		else System.out.println("Sad");
	}
}