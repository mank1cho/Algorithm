// https://www.acmicpc.net/problem/3036
// 링
// GCD
package boj;

import java.io.*;
import java.util.*;

public class BOJ_3036 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		for(int i = 0; i<N-1; ++i) {
			int b = Integer.parseInt(st.nextToken());
			int gcd = gcd(a,b);
			sb.append(a/gcd).append('/').append(b/gcd).append('\n');
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
}