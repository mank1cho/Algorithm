// https://www.acmicpc.net/problem/1654
// 랜선 자르기
// Binary Search
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1654 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		long max = 0;
		long min = 1;
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		while(max>=min) {
			long mid = (min+max)/2;
			int cnt = 0;
			for(int i = 0; i<N; ++i) {
				cnt+=arr[i]/mid;
			}
			if(cnt<K) {
				max = mid-1;
			}
			else {
				min = mid+1;
			}
		}
		
		System.out.println(max);
	}
}