// https://www.acmicpc.net/problem/2116
// 주사위 쌓기
// 구현
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2116_G5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dice = new int[N][6];
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<6; ++j) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for(int i = 0; i<6; ++i) {
			int down = dice[0][i];
			int up = dice[0][up(i)];
			int sum = getMax(down, up);
			for(int j = 1; j<N; ++j) {
				for(int k = 0; k<6; ++k) {
					if(dice[j][k] == up) {
						down = up;
						up = dice[j][up(k)];
						break;
					}
				}
				sum+=getMax(down,up);
			}
			ans = Math.max(ans, sum);
		}
		System.out.println(ans);
	}
	
	static int getMax(int x, int y) {
		if(x!=6 && y!=6) return 6;
		else if(x!=5 && y!=5) return 5;
		else return 4;
	}
	
	static int up(int d) {
		if(d==0) return 5;
		else if(d==1) return 3;
		else if(d==2) return 4;
		else if(d==3) return 1;
		else if(d==4) return 2;
		else return 0;
	}
}