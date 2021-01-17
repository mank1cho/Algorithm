// https://www.acmicpc.net/problem/1037
// 약수
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1037 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<N; ++i) {
			int x = Integer.parseInt(st.nextToken());
			min = Math.min(x, min);
			max = Math.max(x, max);
		}
		
		System.out.print(min*max);
	}
}