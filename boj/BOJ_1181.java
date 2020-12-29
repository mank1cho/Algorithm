// https://www.acmicpc.net/problem/1181  단어 정렬
// sort string

package boj;

import java.io.*;
import java.util.*;

public class BOJ_1181 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for(int i = 0; i<N; ++i) {
			arr[i] = br.readLine();
		}

		/*
		 Arrays.sort(arr, (String s1, String s2) -> {
			if(s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}
			else
				return s1.length() - s2.length();
		});
		*/
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				else {
					return s1.length() - s2.length();
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0]).append("\n");
		for(int i = 1; i<N; ++i) {
			if(arr[i].equals(arr[i-1])) continue;
			sb.append(arr[i]).append("\n");
		}
		System.out.print(sb);
	}
}
