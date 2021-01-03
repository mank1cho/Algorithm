// https://www.acmicpc.net/problem/13305  주유소
// Greedy

package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13305 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dis = new int[N-1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N-1; ++i) {
			dis[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		long ans = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N-1; ++i) {
			min = Math.min(min, Integer.parseInt(st.nextToken()));
			ans += (long)min*dis[i];
		}
		System.out.print(ans);
	}
}