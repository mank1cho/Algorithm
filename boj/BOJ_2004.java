// https://www.acmicpc.net/problem/2004
// 조합 0의 개수

package boj;

import java.io.*;
import java.util.*;

public class BOJ_2004 {	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());

		long[] t = new long[3];
		long[] f = new long[3];
		
		for(long i = 2; i<=n; i*=2) {
			t[0]+=n/i;
			if(i<=m) t[1]+=m/i;
			if(i<=n-m) t[2]+=(n-m)/i;
		}
		
		for(long i = 5; i<=n; i*=5) {
			f[0]+=n/i;
			if(i<=m) f[1]+=m/i;
			if(i<=n-m) f[2]+=(n-m)/i;
		}

		t[0]-=t[1]+t[2];
		f[0]-=f[1]+f[2];
		System.out.print(Math.min(t[0], f[0]));
	}

}