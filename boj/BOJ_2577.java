// https://www.acmicpc.net/problem/2577 숫자의 개수
package boj;

import java.io.*;

public class BOJ_2577 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 1;		
		for(int i = 0; i<3; ++i) {
			x*=Integer.parseInt(br.readLine());
		}
		
		int[] cnt = new int[10];
		while(x!=0) {
			cnt[x%10]++;
			x/=10;
		}
		for(int i : cnt) {
			System.out.println(i);
		}
	}
}
