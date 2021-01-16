// https://www.acmicpc.net/problem/15624
// 피보나치수
package boj;

import java.io.*;

public class BOJ_15624 {
	static final int mod = (int) (1e9+7);
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a = 0;
		int b = 1;
		int c = 1;
		for(int i = 2; i<=n; ++i) {
			c = (a+b)%mod;
			a = b;
			b = c;
		}
		if(n==0) System.out.print(0);
		else {
			System.out.print(c);
		}
	}
}