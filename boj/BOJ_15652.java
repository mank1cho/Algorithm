// https://www.acmicpc.net/problem/15652  N과 M 4
// back tracking
package boj;

import java.io.*;
import java.util.*;

public class BOJ_15652 {
	static StringBuilder sb;
	static int N, M, arr[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[9];
		func(0, 1);
		
		System.out.print(sb);
	}
	
	public static void func(int cnt, int now) {
		if(cnt == M) {
			for(int i = 0; i<cnt; ++i)
				sb.append(arr[i]).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int i = now; i<=N; ++i) {
			arr[cnt] = i;
			func(cnt+1, i);
		}
	}
}
