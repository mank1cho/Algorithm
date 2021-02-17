// https://www.acmicpc.net/problem/15686
// 치킨 배달
// 구현
package boj;

import java.io.*;
import java.util.*;

public class BOJ_15686_G5 {

	static int N, M, hidx, cidx, ans;
	static int[][] home, chic, dis;
	static int[] pick;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		home = new int[2*N][2];
		chic = new int[13][2];
		hidx = 0;
		cidx = 0;
		for(int i = 0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; ++j) {
				int x = Integer.parseInt(st.nextToken());
				if(x == 1) {
					home[hidx++] = new int[] {i,j};
				}
				else if(x == 2) {
					chic[cidx++] = new int[] {i,j};
				}
			}
		}
		
		dis = new int[cidx][hidx];
		for(int i = 0; i<cidx; ++i) {
			for(int j = 0; j<hidx; ++j) {
				dis[i][j] = Math.abs(chic[i][0]-home[j][0]) + Math.abs(chic[i][1]-home[j][1]);
			}
		}
		
		pick = new int[cidx];
		ans = 9999;
		func(0,0);
		System.out.println(ans);
	}
	
	static void func(int depth, int next) {
		if(depth == M) {
			int sum = 0;
			for(int i = 0; i<hidx; ++i) {
				int m = 9999;
				for(int j = 0; j<M; ++j) {
					m = Math.min(m, dis[pick[j]][i]);
				}
				sum+=m;
			}
			ans = Math.min(ans, sum);
			return;
		}
		
		for(int i = next; i<cidx; ++i) {
			pick[depth] = i;
			func(depth+1, i+1);
		}
	}

}