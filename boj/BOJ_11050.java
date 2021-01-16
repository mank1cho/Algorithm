// https://www.acmicpc.net/problem/11050
// 이항 계수1
// Math
package boj;

import java.io.*;
import java.util.*;

public class BOJ_11050 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		System.out.print(factorial(N)/factorial(K)/factorial(N-K));
	}
	
	public static int factorial(int x) {
		if(x == 0) return 1;
		int ret = 1;
		for(;x>=1;--x) {
			ret*=x;
		}
		return ret;
	}
}