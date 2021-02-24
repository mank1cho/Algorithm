// https://www.acmicpc.net/problem/18291
// 비요뜨의 징검다리 건너기
// 
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_18291 {
	
	static final int mod = (int) (1e9+7);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());			
			N-=2;
			long a = 2;
			long r = 1;
			while(N>0) {
				if(N%2==1) r=r*a%mod;
				a*=a;
				a%=mod;
				N/=2;
			}
			sb.append(r).append('\n');
		}
		System.out.println(sb);
	}
}
