// https://www.acmicpc.net/problem/11047  동전 0
// Greedy
package boj;

import java.io.*;
import java.util.*;

public class BOJ_11047 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i = N-1; i>=0; --i) {
			if(K==0) break;
			if(arr[i] <= K) {
				cnt+=K/arr[i];
				K%=arr[i];
			}
		}
		System.out.print(cnt);
	}
}