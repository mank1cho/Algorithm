// https://www.acmicpc.net/problem/7453
// 합이 0인 네 정수
// 이분탐색
package boj;

import java.io.*;
import java.util.*;

public class BOJ_7453_G2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] A = new long[N][4];
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<4; ++j) {
				A[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		long[] arr1 = new long[N*N];
		long[] arr2 = new long[N*N];
		
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<N; ++j) {
				arr1[i*N+j] = A[i][0]+A[j][1];
				arr2[i*N+j] = A[i][2]+A[j][3];
			}
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		long ans = 0;
		for(int i = 0; i<N*N; ++i) {
			long x = -arr2[i];
			ans += upperBound(x,arr1)-lowerBound(x,arr1);
		}
		System.out.println(ans);
	}
	
	static int upperBound(long x, long[] arr) {
		int low = 0;
		int high = arr.length;
		while(high>low){
			int mid = (low+high)/2;
			if(arr[mid] > x) high = mid;
			else low = mid+1;
		}
		return high;
	}
	
	static int lowerBound(long x, long[] arr) {
		int low = 0;
		int high = arr.length;
		while(high>low){
			int mid = (low+high)/2;
			if(arr[mid] >= x) high = mid;
			else low = mid+1;
		}
		return high;
	}
	
}