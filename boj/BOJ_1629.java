// https://www.acmicpc.net/problem/1629
// 곱셈
// Math
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1629 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long A, B, C, r;
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		r = 1;
		A%=C;
		while(B>0) {
			if (B%2==1) r = r*A%C;
			A = (A*A)%C;
			B/=2;
		}
		System.out.print(r);
	}
}