// https://www.acmicpc.net/problem/1904  01타일
// Dynamic Programming

package boj;

import java.io.*;

// 1,2,3,5,8..

public class BOJ_1904 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int a = 1, b= 2, c = 2;
		for(int i = 2; i<N; ++i) {
			c = (a+b)%15746;
			a = b;
			b = c;
		}
		if(N==1) c=1;
		System.out.print(c);
	}
}