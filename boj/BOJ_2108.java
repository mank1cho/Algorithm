// https://www.acmicpc.net/problem/2108  통계학
// sort

package boj;

import java.io.*;
import java.util.Arrays;

public class BOJ_2108 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] cnt = new int[8001];
		double sum = 0;
		int maxCnt = 0;
		
		for(int i = 0; i<N; ++i) {
			int x = Integer.parseInt(br.readLine());
			sum+=x;
			arr[i] = x;
			maxCnt = Math.max(++cnt[x + 4000], maxCnt);
		}

		int flag = 0;
		int num = 0;
		for(int i = 0; i<8001 && flag<2; ++i) {
			if(cnt[i] == maxCnt) {
				num = i;
				++flag;
			}
		}
		 
		Arrays.sort(arr);
		System.out.println(Math.round(sum/N));
		System.out.println(arr[N/2]);
		System.out.println(num - 4000);
		System.out.print(arr[N-1] - arr[0]);
	}
}
