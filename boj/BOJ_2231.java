// https://www.acmicpc.net/problem/2231  분해합
// brute force
package boj;

import java.io.*;

public class BOJ_2231 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i = 1; i<=N; ++i) {
			int x = i;
			int sum = i;
			while(x > 0) {
				sum+=x%10;
				x/=10;
			}
			
			if(sum == N) {
				ans = i;
				break;
			}
		}
		
		System.out.print(ans);
	}
}