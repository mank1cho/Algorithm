// https://www.acmicpc.net/problem/1259
// 팰린드롬수
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1259 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(s.equals("0")) break;
			boolean flag = true;
			for(int i = 0; i<s.length()/2; ++i) {
				if(s.charAt(i)!=s.charAt(s.length()-i-1)) {
					flag = false;
					break;
				}
			}
			
			if(flag) sb.append("yes");
			else sb.append("no");
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
}