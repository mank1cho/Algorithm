// https://www.acmicpc.net/problem/2110
// 공유기 설치
// Binary Search
package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int left = 1;
		int right = arr[N-1] - arr[0];
		int ans = 0;
		while(right>=left) {
			int mid = (right+left)/2;
			int now = arr[0];
			int cnt = 1;
			
			for(int i = 0; i<N; ++i) {
				if(now+mid<=arr[i]) {
					now = arr[i];
					++cnt;
				}
			}
			
			if(cnt >= C) {
				ans = mid;
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}
		System.out.print(ans);
	}
}