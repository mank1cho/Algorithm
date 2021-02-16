// https://www.acmicpc.net/problem/2143
// 두 배열의 합
// 누적합, 이분탐색
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2143_G3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] prefix1 = new int[(n+1)*n/2];
		prefixSum(prefix1, arr, n);
		
		int m = Integer.parseInt(br.readLine());
		arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<m; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] prefix2 = new int[(m+1)*m/2];
		prefixSum(prefix2, arr, m);
		
		Arrays.sort(prefix2);
		long ans = 0;
		for(int i = 0; i<prefix1.length; ++i) {
			int x = T - prefix1[i];
			int low = lowerBound(x, prefix2);
			int high = upperBound(x, prefix2);
			ans+=high-low;
		}
		System.out.println(ans);
	}
	
	static int upperBound(int x, int[] arr) {
		int low = 0;
		int high = arr.length;
		while(high>low){
			int mid = (low+high)/2;
			if(arr[mid] > x) high = mid;
			else low = mid+1;
		}
		return high;
	}
	
	static int lowerBound(int x, int[] arr) {
		int low = 0;
		int high = arr.length;
		while(high>low){
			int mid = (low+high)/2;
			if(arr[mid] >= x) high = mid;
			else low = mid+1;
		}
		return high;
	}
	
	static void prefixSum(int[] pre, int[] arr, int n) {
		int idx = 0;
		for(int i = 0; i<n; ++i) {
			int sum = arr[i];
			pre[idx++] = sum;
			for(int j = i+1; j<n; ++j) {
				sum+=arr[j];
				pre[idx++] = sum;
			}
		}
	}
}