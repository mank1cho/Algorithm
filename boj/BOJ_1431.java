// https://www.acmicpc.net/problem/1431
// 시리얼 번호
// Sort
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1431 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[N];
		for(int i = 0; i<N; ++i) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, (s1, s2) ->{
			if(s1.length() != s2.length()) {
				return s1.length() - s2.length();
			}
			else {
				int n1 = 0, n2 = 0;
				for(int i = 0; i<s1.length(); ++i) {
					char c = s1.charAt(i);
					if(c>='0' && c<='9') n1+=c-'0';
				}
				for(int i = 0; i<s2.length(); ++i) {
					char c = s2.charAt(i);
					if(c>='0' && c<='9') n2+=c-'0';
				}
				if(n1!=n2) return n1 - n2;
				else return s1.compareTo(s2);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; ++i) {
			sb.append(arr[i]).append('\n');
		}
		System.out.print(sb);
	}
} 
