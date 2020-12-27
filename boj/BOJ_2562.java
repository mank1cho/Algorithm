//https://www.acmicpc.net/problem/2562 최댓값
package boj;

import java.io.*;

public class BOJ_2562 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int max = Integer.MIN_VALUE;
		int index = 0;
		for(int i = 1; i<=9; ++i) {
			int x = Integer.parseInt(br.readLine());
			if(x>max) {
				max = x;
				index = i;
			}
		}
		System.out.print(max + "\n" + index);
	}
}
