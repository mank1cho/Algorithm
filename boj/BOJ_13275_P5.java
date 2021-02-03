// https://www.acmicpc.net/problem/13275
// 가장 긴 팰린드롬 부분 문자열
// manacher's algorithm
package boj;

import java.io.*;

public class BOJ_13275_P5 {
	
	static int[] A;
	
	public static void main(String args[]) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String s = br.readLine();
		 
		 StringBuilder sb = new StringBuilder();
		 for(int i = 0; i<s.length(); ++i) {
			 sb.append('#');
			 sb.append(s.charAt(i));
		 }
		 sb.append('#');
		 
		 s = sb.toString();
		 
		 manachers(s);
		 
		 int ans = 0;
		 for(int i = 0; i<A.length; ++i) {
			 ans = Math.max(ans, A[i]);
		 }
		 
		 System.out.println(ans);
	}
	
	static void manachers(String s) {
		int size = s.length();
		A = new int[size];
		
		int r = 0, p = 0;
		for (int i = 0; i < size; ++i) {
			
			if (i <= r) {
				A[i] = Math.min(A[2 * p - i], r - i);
			}
			else {
				A[i] = 0;
			}

			while (i - A[i] - 1 >= 0 && i + A[i] + 1 < size && s.charAt(i - A[i] - 1) == s.charAt(i + A[i] + 1)) {
				++A[i];
			}

			if (r < i + A[i]) {
				r = i + A[i];
				p = i;
			}
		}
		
		return;
	}
	
}
