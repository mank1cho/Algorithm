// https://www.acmicpc.net/problem/1052
// 물병
// BitMasking
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// N = 0011
		int ans = 0;
		while(true) {
			int cnt = 0;
			int firstIdx = -1;
			for(int i = 0; i<30; ++i) {
				int x = 1<<i;
				if((N&x) != 0) {
					if(firstIdx == -1) {
						firstIdx = x;
					}
					cnt++;
				}
			}
			if(cnt <= K) break;
			ans+=firstIdx;
			N+=firstIdx;
		}
		
		System.out.println(ans);
	}
}