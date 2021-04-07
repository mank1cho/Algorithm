// https://www.acmicpc.net/problem/11497
// 통나무 건너뛰기
// Greedy

package boj;

import java.io.*;
import java.util.*;

public class BOJ_11497_통나무건너뛰기 {

	static int T, N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int[] arr2 = new int[N];
			
			int idx = 0;
			for(int i = 0; i<N; i+=2) {
				arr2[idx++] = arr[i];
			}
			
			if(N%2==1) N--;
			for(int i = N-1; i>=0; i-=2) {
				arr2[idx++] = arr[i];
			}
			
			int ans = 0;
			for(int i = 0; i<idx-1; ++i) {
				ans = Math.max(ans, Math.abs(arr2[i]-arr2[i+1]));
			}
			ans = Math.max(ans, Math.abs(arr2[idx-1]-arr2[0]));
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}


}