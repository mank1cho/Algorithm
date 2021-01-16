// https://www.acmicpc.net/problem/11402
// 이항계수4
// 루카스 정리
package boj;

import java.io.*;
import java.util.*;

public class BOJ_11402 {
	static long[][] binomial;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		binomial = new long[M][M];
		binomial[0][0]=1;
		for(int i=1; i<M; ++i) {
			binomial[i][0] = 1;
			for(int j = 1; j<=i; ++j) {
				binomial[i][j] = (binomial[i-1][j-1]+binomial[i-1][j])%M;
			}
		}

		long ans = 1;
		while(N>0) {
			ans*=binomial[(int) N%M][(int) K%M];
			ans%=M;
			N/=M;
			K/=M;
		}
		System.out.print(ans);
	}
}