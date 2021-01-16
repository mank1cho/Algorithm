// https://www.acmicpc.net/problem/11401
// 이항계수3
// 페르마의 소정리
package boj;

import java.io.*;
import java.util.*;

public class BOJ_11401 {
	static final long mod = (long) (1e9+7);
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long nf = 1, kf = 1, nkf = 1;
		for(int i = 1; i<=N; ++i) {
			nf = nf*i%mod;
			if(i == K) kf = nf;
			if(i == N-K) nkf = nf;
		}
		kf=kf*nkf%mod;
		kf = pow(kf, mod-2);
		System.out.print(nf*kf%mod);
	}
	
	public static long pow(long x, long m) {
		long ret = 1;
		while(m>0) {
			if(m%2 == 1) {
				ret = ret*x%mod;
			}
			m>>=1;
			x=x*x%mod;
		}
		return ret;
	}
}