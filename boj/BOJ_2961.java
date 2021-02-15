// https://www.acmicpc.net/problem/2961
// 도영이가 만든 맛있는 음식
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2961 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] taste = new int[N][2];
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i = 1; i<(1<<N); ++i) {
			int s = 1, b = 0;
			for(int j = 0; j<N; ++j) {
				if((i&(1<<j))>0) {
					s*=taste[j][0];
					b+=taste[j][1];
				}
			}
			ans = Math.min(ans, Math.abs(s-b));
		}
		System.out.println(ans);
	}
}