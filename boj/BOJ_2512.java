// https://www.acmicpc.net/problem/2512
// 예산
// 이분탐색
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2512 {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		int min = 0;
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		M = Integer.parseInt(br.readLine());
		
		while(min<=max) {
			int mid = (min+max)/2;
			long sum = 0;
			
			for(int i = 0; i<N; ++i) {
				if(arr[i] < mid) {
					sum+=arr[i];
				}
				else sum+=mid;
			}
			
			if(sum>M) {
				max = mid-1;
			}
			else min = mid+1;
		}
		
		System.out.println(max);
    }    
}
