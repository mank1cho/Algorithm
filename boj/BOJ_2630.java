// https://www.acmicpc.net/problem/2630
// 색종이 만들기
// Divide and Conquer
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2630 {
	static int white, blue;
	static int[][] map;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(N, 0, 0);

		System.out.println(white);
		System.out.print(blue);
	}
	
	public static void func(int n, int x, int y) {
		if(n == 1) {
			if(map[x][y] == 0) ++white;
			else ++blue;
			return;
		}
		
		int wCnt = 0;
		for(int i = x; i<x+n; ++i) {
			for(int j = y; j<y+n; ++j) {
				if(map[i][j] == 0) ++wCnt;
			}
		}
		
		if(wCnt == n*n) {
			++white;
			return;
		}
		else if(wCnt == 0) {
			++blue;
			return;
		}
		else {
			func(n/2, x, y);
			func(n/2, x+n/2, y);
			func(n/2, x, y+n/2);
			func(n/2, x+n/2, y+n/2);
		}
	}
	
	
}