// https://www.acmicpc.net/problem/10828
// 스택
// String, Stack
package boj;

import java.io.*;
import java.util.*;

public class BOJ_10828 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			if(str.equals("push")) {
				s.push(Integer.parseInt(st.nextToken()));
			}
			
			else if(str.equals("pop")) {
				if(s.empty() == true) {
					sb.append(-1).append('\n');;
				}
				else {
					sb.append(s.peek()).append('\n');;
					s.pop();
				}
			}
			
			else if(str.equals("size")) {
				sb.append(s.size()).append('\n');;
			}
			
			else if(str.equals("empty")) {
				if(s.empty() == true) {
					sb.append(1).append('\n');;
				}
				else {
					sb.append(0).append('\n');;
				}
			}
			
			else if(str.equals("top")) {
				if(s.empty() == true) {
					sb.append(-1).append('\n');;
				}
				else {
					sb.append(s.peek()).append('\n');;
				}
			}
		}
		
		System.out.print(sb);
	}
	
}