// https://www.acmicpc.net/problem/9184  신나는 실행 함수
// dynamic programming
package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9184 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][][] w = new int[21][21][21];
		for(int i = 0; i<21; ++i) {
			for(int j = 0; j<21; ++j) {
				w[0][i][j] = w[i][0][j] = w[i][j][0] = 1;
			}
		}
		
		for(int i = 1; i<21; ++i) {
			for(int j = 1; j<21; ++j) {
				for(int k = 1; k<21; ++k) {
					if(i<j && j<k) w[i][j][k] = w[i][j][k-1] + w[i][j-1][k-1] - w[i][j-1][k];
					else w[i][j][k] = w[i-1][j][k] + w[i-1][j-1][k] + w[i-1][j][k-1] - w[i-1][j-1][k-1];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1 && c == -1) break;
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
			if(a<1 || b<1 || c<1) sb.append(1);
			else if(a>20 || b>20 || c>20) sb.append(w[20][20][20]);
			else sb.append(w[a][b][c]);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
