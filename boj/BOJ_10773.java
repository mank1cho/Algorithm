// https://www.acmicpc.net/problem/10773
// 제로
// 구현
package boj;

import java.io.*;
import java.util.*;

public class BOJ_10773 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[] arr = new int[100001];
		
		int idx = 0;
		for(int i = 0; i<K; ++i) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				--idx;
			}
			else {
				arr[idx++] = input;
			}
		}
		
		int sum = 0;
		for(int i = 0; i<idx; ++i) {
			sum+=arr[i];
		}
		
		System.out.println(sum);
		
	}
} 