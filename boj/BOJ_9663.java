// https://www.acmicpc.net/problem/9663  N-Queen
// back tracking
package boj;

import java.io.*;

public class BOJ_9663 {
	static int[] col;	//열
	static int[] diag1;	//대각선 1
	static int[] diag2;	//대각선 2
	static int ans = 0;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		col = new int[N];
		diag1 = new int[2*N-1];
		diag2 = new int[2*N-1];
		func(N, 0);
		System.out.print(ans);
	}
	
	static void func(int N, int x) {
		if(x == N) {
			++ans;
			return;
		}
		
		for(int i = 0; i<N; ++i) {
			if(col[i] == 1 || diag1[x+i] == 1 || diag2[x-i+N-1] == 1) continue;
			col[i] = 1;
			diag1[x+i] = 1;
			diag2[x-i+N-1] = 1;
			func(N, x+1);
			col[i] = 0;
			diag1[x+i] = 0;
			diag2[x-i+N-1] = 0;
		}
	}
}
