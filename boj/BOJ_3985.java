// https://www.acmicpc.net/problem/3985
// 롤 케이크
// 구현
package boj;

import java.io.*;
import java.util.*;

public class BOJ_3985 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int[] arr = new int[L+1];
		int N = Integer.parseInt(br.readLine());
		
		int ans1 = 0, max = 0;
		
		for(int k = 1; k<=N; ++k) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if(r-l+1 > max) {
				max = r-l+1;
				ans1 = k;
			}
			for(int i = l; i<=r; ++i) {
				if(arr[i] == 0) {
					arr[i] = k;
				}
			}
		}
		
		int[] cnt = new int[N+1];
		for(int i = 1; i<=L; ++i) {
			++cnt[arr[i]];
		}
		
		int mCnt = 0, idx = 0;
		for(int i = 1; i<=N; ++i) {
			if(cnt[i] > mCnt) {
				mCnt = cnt[i];
				idx = i;
			}
		}
		
		System.out.println(ans1);
		System.out.println(idx);
		
	}
}