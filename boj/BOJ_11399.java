// https://www.acmicpc.net/problem/11399
// ATM
// Greedy, Sort
package boj;

import java.io.*;
import java.util.*;

public class BOJ_11399 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int sum = 0;
		for(int i = 0; i<N; ++i) {
			sum+=arr[i]*(N-i);
		}
		System.out.print(sum);
	}
}