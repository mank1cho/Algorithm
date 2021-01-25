// https://www.acmicpc.net/problem/1283
// 단축키 지정
// String
package boj;

import java.io.*;

public class BOJ_1283 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] check = new boolean[26];
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			String s = br.readLine();
			boolean isFirst = true;
			boolean isFinded = false;
			StringBuilder temp = new StringBuilder();
			
			for(int i = 0; i<s.length(); ++i) {
				char c = s.charAt(i);
				if(c == ' ') {
					isFirst = true;
					temp.append(' ');
				}
				else {
					if(isFirst && !isFinded) {
						isFirst = false;
						char now = s.toLowerCase().charAt(i);
						if(!check[now-'a']) {
							isFinded = true;
							check[now-'a'] = true;
							temp.append('[').append(s.charAt(i)).append(']');
						}
						else {
							temp.append(s.charAt(i));
						}
					}
					else {
						temp.append(s.charAt(i));
					}
				}
			}
			
			if(isFinded) {
				sb.append(temp).append('\n');
				continue;
			}
			
			temp = new StringBuilder();
			isFinded = false;
			for(int i = 0; i<s.length(); ++i) {
				char c = s.charAt(i);
				if(c == ' ') {
					temp.append(' ');
				}
				else {
					if(!isFinded) {
						char now = s.toLowerCase().charAt(i);
						if(!check[now-'a']) {
							check[now-'a'] = true;
							isFinded = true;
							temp.append('[').append(s.charAt(i)).append(']');
						}
						else {
							temp.append(s.charAt(i));
						}
					}
					else {
						temp.append(s.charAt(i));
					}
				}
			}
			
			sb.append(temp).append('\n');
		}
		System.out.println(sb);		
	}
} 
