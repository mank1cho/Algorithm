// https://www.acmicpc.net/problem/2748  피보나치 수2
// dynamic programming
package boj;

import java.io.*;

public class BOJ_2748 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long a = 0, b = 1, c = 0;
		for(int i = 1; i<N; ++i) {
			c = a + b;
			a = b;
			b = c;
		}
		if(N == 1) System.out.print(1);
		else System.out.print(c);
	}
}