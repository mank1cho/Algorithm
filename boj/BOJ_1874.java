// https://www.acmicpc.net/problem/1874
// 스택 수열
// Stack

package boj;

import java.io.*;
import java.util.*;

public class BOJ_1874 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		st.push(0);
		
		int now = 1;
		boolean flag = true;
		while(N-->0) {
			int x = Integer.parseInt(br.readLine());
			if(st.peek() < x) {
				while(st.peek() < x) {
					st.push(now++);
					sb.append('+').append('\n');
				}
				sb.append('-').append('\n');
				st.pop();
			}
			else {
				if(st.peek() != x) {
					flag = false;
					break;
				}
				else {
					sb.append('-').append('\n');
					st.pop();
				}
			}
		}
		
		if(flag == false) System.out.print("NO");
		else System.out.print(sb);
	}
}