// https://www.acmicpc.net/problem/17413
// 단어 뒤집기 2
// 문자열
package boj;

import java.io.*;

class Solution {
	public String solution(String input) {
		StringBuilder sb = new StringBuilder();
		String s = input;
		StringBuilder reverse = new StringBuilder();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (c == '<') {
				sb.append(reverse.reverse());
				reverse.setLength(0);
				sb.append(c);
				while (++i < s.length() && s.charAt(i) != '>') {
					sb.append(s.charAt(i));
				}
				sb.append(s.charAt(i));
			} 
			else if(c == ' ') {
				sb.append(reverse.reverse());
				reverse.setLength(0);
				sb.append(' ');
			}
			else {
				reverse.append(c);
			}

		}
		sb.append(reverse.reverse());
		return sb.toString();
	}
}

public class BOJ_17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution solution = new Solution();
		System.out.println(solution.solution(br.readLine()));
	}
}