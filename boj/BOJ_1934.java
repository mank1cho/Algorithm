// https://www.acmicpc.net/problem/1934
// 최소공배수
// 유클리드 호제법
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1934 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(lcm(a, b, gcd(a,b))).append('\n');
		}
		System.out.print(sb);
	}
	
	public static int gcd(int a, int b) {
		while(b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	public static int lcm(int a, int b, int gcd) {
		return a*b/gcd;
	}
}