// https://www.acmicpc.net/problem/2981
// 검문
// GCD
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2981 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int gcd = arr[1]-arr[0];
		for(int i = 2; i<N; ++i) {
			gcd = gcd(gcd, arr[i]-arr[i-1]);
		}

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int i = 2;
		for(; i*i<gcd; ++i) {
			if(gcd%i == 0) {
				sb1.append(i).append(' ');
				sb2.insert(0, ' ').insert(0, gcd/i);
			}
		}
		if(i*i==gcd) sb1.append(i).append(' ');
		sb2.append(gcd);
		
		System.out.print(sb1);
		System.out.print(sb2);
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