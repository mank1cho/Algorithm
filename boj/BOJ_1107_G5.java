// https://www.acmicpc.net/problem/1107
// 리모컨
// 브루트포스
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1107_G5 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int n = Integer.parseInt(input);
		int m = Integer.parseInt(br.readLine());
		int[] target = new int[6];
		
		boolean[] remocon = new boolean[10];
		int ans = Math.abs(n - 100);

		for (int i = 0; i < input.length(); i++) {
			target[i] = input.charAt(i) - '0';
		}

		StringTokenizer st = null;
		if(m>0) st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			remocon[Integer.parseInt(st.nextToken())] = true;
		}

		for (int i = 0; i <= 888888; i++) {
			boolean flag = false;
			String current = String.valueOf(i);
			int len = current.length();

			for (int j = 0; j < len; j++) {
				int value = current.charAt(j) - '0';

				if (!check(remocon, value)) {
					flag = true;
					break;
				}

			}

			if (!flag) {
				if (ans > Math.abs(i - n) + len) {
					ans = Math.abs(i - n) + len;
				}

			}

		}

		System.out.println(ans);
	}

	// 고장 여부
	public static boolean check(boolean[] array, int target) {
		if (array[target]) {
			return false;
		}

		return true;
	}

}