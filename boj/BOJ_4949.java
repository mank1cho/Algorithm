// https://www.acmicpc.net/problem/4949
// 균형잡힌 세상
// stack
package boj;

import java.io.*;
import java.util.*;

public class BOJ_4949 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			if(s.equals(".")) break;
			
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i<s.length(); ++i) {
				
				char c = s.charAt(i);
				
				if(c == '(' ||  c == '[') {
					stack.push(c);
				}
				else {
					if(c == ')' ||  c == ']') {
						if(stack.empty()) {
							stack.push(c);
							break;
						}
						if(c == ')') {
							if(stack.peek() == '(') stack.pop();
							else break;
						}
						else if(c == ']') {
							if(stack.peek() == '[') stack.pop();
							else break;
						}
					}
				}
				
			}
			
			if(stack.empty()) sb.append("yes").append('\n');
			else sb.append("no").append('\n');
		}
		
		System.out.print(sb);
	}
	
}