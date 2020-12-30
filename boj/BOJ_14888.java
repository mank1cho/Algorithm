// https://www.acmicpc.net/problem/14888  연산자 끼워넣기
// back tracking
package boj;

import java.io.*;
import java.util.*;

public class BOJ_14888 {
	static int[] arr;
	static int[] op;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		op = new int[4];
		
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<4; ++i) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		func(op[0], op[1], op[2], op[3], 1, arr[0]);
		
		System.out.println(max);
		System.out.print(min);
	}
	
	static void func(int plus, int minus, int multi, int divi, int idx, int sum) {
		if(idx == arr.length) {
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			return;
		}
		
		if(plus >0) {
			func(plus-1, minus, multi, divi, idx+1, sum+arr[idx]);
		}
		if(minus >0) {
			func(plus, minus-1, multi, divi, idx+1, sum-arr[idx]);
		}
		if(multi >0) {
			func(plus, minus, multi-1, divi, idx+1, sum*arr[idx]);
		}
		if(divi >0) {
			func(plus, minus, multi, divi-1, idx+1, sum/arr[idx]);
		}
	}
}
