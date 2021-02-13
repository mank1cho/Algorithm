// https://www.acmicpc.net/problem/1806
// 부분합
// 투포인터
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1806_G4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int left = 0;
		int right = 0;
		int ans = Integer.MAX_VALUE;
		
		while(true) {
			if(sum>S) sum-=arr[left++];
			else if(right == N) break;
			else sum+=arr[right++];
			if(sum >= S) ans = Math.min(ans, right-left);
		}
		
		if(ans == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(ans);
	}
}