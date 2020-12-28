// https://www.acmicpc.net/problem/7568 덩치
// brute force
package boj;

import java.io.*;

public class BOJ_1436 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int a = 666;
		int cnt = 1;
		while(N!=cnt) {
			int i = ++a;
			while(i > 100) {
				if(i % 1000 == 666) {
					cnt++;
					break;
				}
				i/=10;
			}
		}
		System.out.print(a);
	}
}