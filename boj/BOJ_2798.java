// https://www.acmicpc.net/problem/2798  블랙잭
// brute force
package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2798 {
	static int ans = 0;
	static int N, M;
	static int[] arr;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		blackJack(0, 0, 0);
		System.out.println(ans);
	}
	
	static void blackJack(int cnt, int now, int sum) {
		if(cnt == 3) {
			ans = Math.max(ans,  sum);
			return;
		}
		for(int i = now; i<N; ++i) {
			if(sum+arr[i]>M) continue;
			blackJack(cnt+1, i+1, sum+arr[i]);
		}
	}
}