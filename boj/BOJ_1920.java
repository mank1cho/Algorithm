// https://www.acmicpc.net/problem/1920
// 수 찾기
// 이분탐색

package boj;

import java.io.*;
import java.util.*;

public class BOJ_1920 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; ++i) {
			int target = Integer.parseInt(st.nextToken());
			sb.append(func(arr, N, target)).append('\n');
		}
		System.out.println(sb);
	}
	
	public static int func(int[] arr, int N, int target) {
		int right = N - 1;
		int left = 0;
		while(right>=left) {
			int mid = (right+left)/2;
			if(arr[mid] > target) {
				right = mid - 1;
			}
			else if(arr[mid] < target) {
				left = mid + 1;
			}
			else {
				return 1;
			}
		}
		return 0;
	}
} 
