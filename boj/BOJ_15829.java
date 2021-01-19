// https://www.acmicpc.net/problem/15829
// Hashing
package boj;

import java.io.*;

public class BOJ_15829 {
	static final long mod = 1234567891;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		long ans = 0;		
		long r = 1;
		for(int i = 0; i<L; ++i) {
			ans= (ans + (s.charAt(i)-'a'+1)*r) % mod;
			r = r*31%mod;
		}
		System.out.println(ans);
	}
}