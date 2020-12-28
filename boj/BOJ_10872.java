// https://www.acmicpc.net/problem/10872  팩토리얼
package boj;

import java.io.*;

public class BOJ_10872 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.print(factorial(N, 1));
	}
	
	public static int factorial(int x, int r) {
		if(x == 0) return r;
		return factorial(x-1, r * x);
	}
}