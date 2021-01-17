// https://www.acmicpc.net/problem/2609
// 최대공약수와 최대공배수
// 유클리드 호제법
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2609 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int gcd = getGCD(a, b);
		int lcm = getLCM(a, b, gcd);
		System.out.println(gcd);
		System.out.print(lcm);
	}
	
	public static int getGCD(int a, int b) {
		while(b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	
	public static int getLCM(int a, int b, int gcd) {
		return a*b/gcd;
	}
}