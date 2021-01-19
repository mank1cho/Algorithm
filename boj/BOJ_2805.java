// https://www.acmicpc.net/problem/2805
// 나무 자르기
// Binary Search
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2805 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		int[] arr = new int[N];
		
		long low = 0;
		long high = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			high = Math.max(high, arr[i]);
		}
		
		while(high>=low) {
			long mid = (high+low)/2;
			long tree = 0;
			for(int i = 0; i<N; ++i) {
				if(arr[i] <= mid) continue;
				tree += arr[i]-mid;
			}
			
			if(tree < M) {
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		
		System.out.println(high);
	}
}