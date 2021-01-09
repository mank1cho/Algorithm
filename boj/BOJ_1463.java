// https://www.acmicpc.net/problem/1463
// 1로 만들기
// Dynamic Programming
package boj;

import java.io.*;

public class BOJ_1463 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.print(func(N));
	}
	
	public static int func(int x) {
		if(x<=1) return 0;
		int a = func(x/3) + x%3 + 1;
		int b = func(x/2) + x%2 + 1;
		return a < b ? a : b;
	}
}

/*
public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		if(N>1) arr[2] = 1;
		if(N>2) arr[3] = 1;
		for(int i = 4; i<=N; ++i) {
			int x = Integer.MAX_VALUE;
			if(i%3 == 0) x = Math.min(x, arr[i/3]+1);
			if(i%2 == 0) x = Math.min(x,  arr[i/2]+1);
			x = Math.min(x, arr[i-1]+1);
			arr[i] = x;
		}
		System.out.println(arr[N]);
	}
*/