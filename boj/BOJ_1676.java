// https://www.acmicpc.net/problem/1676
// 팩토리얼 0의 개수
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1676 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int two = 0;
		int five = 0;
		for(int i = 2; i<=N; ++i) {
			int now = i;
			while(now>0) {
				if(now%5==0) {
					++five;
					now/=5;
				}
				else if(now%2==0) {
					++two;
					now/=2;
				}
				else
					break;
			}
		}
		System.out.print(Math.min(two, five));
	}
}