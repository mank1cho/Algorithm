// https://www.acmicpc.net/problem/15651  N과 M 3
// back tracking
package boj;

import java.io.*;
import java.util.*;

public class BOJ_15651 {
	static StringBuilder sb;
	static int N, M, arr[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[8];
		func(0);
		
		System.out.print(sb);
	}
	
	public static void func(int cnt) {
		if(cnt == M) {
			for(int i = 0; i<cnt; ++i)
				sb.append(arr[i]).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int i = 1; i<=N; ++i) {
			arr[cnt] = i;
			func(cnt+1);
		}
	}
}
