// https://www.acmicpc.net/problem/1780
// 종이의 개수
// Divide and conquer
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1780 {
	static int[][] arr;
	static int[] ans;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		ans = new int[3];
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(N, 0, 0);
		for(int i = 0; i<3; ++i)
		System.out.println(ans[i]);
	}
	
	public static void func(int n, int x, int y) {
		if(n == 1) {
			++ans[arr[x][y]+1];
			return;
		}
		
		int num = arr[x][y];
		for(int i = 0; i<n; ++i) {
			for(int j = 0; j<n; ++j) {
				if(arr[x+i][y+j] != num) {
					
					//총 9번의 재귀호출이 필요함
					for(int a = 0; a<3; ++a) {
						for(int b = 0; b<3; ++b) {
							func(n/3, x+n/3*a, y+n/3*b);
						}
					}
					
					return;
				}
			}
		}
		
		++ans[num+1];
	}
	
}