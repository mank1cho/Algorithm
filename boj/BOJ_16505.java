package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16505 {
	static boolean[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int size = (int) Math.pow(2, N);

		arr = new boolean[size][size];
		func(N, 0, 0);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<size; ++i) {
			for (int j = 0; j<size-i; ++j) {
				if (arr[i][j])
					sb.append("*");
				else
					sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void func(int n, int x, int y) {
		if (n == 0) {
			arr[x][y] = true;
			return;
		}
		func(n-1, x, y);
		func(n-1, x+(int) Math.pow(2, n-1), y);
		func(n-1, x, y+(int) Math.pow(2, n-1));
	}
}