// https://www.acmicpc.net/problem/6603
// 로또
// 완전탐색

package boj;

import java.io.*;
import java.util.*;

public class BOJ_6603 {
	
	static int[] arr = new int[13];
	static int[] combination = new int[13];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s = br.readLine();
			if(s.equals("0")) break;
			
			StringTokenizer st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			for(int i = 0; i<n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			makeCombination(arr, 0, n, 0);
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static void makeCombination(int[] arr, int depth, int n, int next) {
		if(depth == 6) {
			for(int i = 0; i<6; ++i) {
				sb.append(combination[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = next; i<n; ++i) {
			combination[depth] = arr[i];
			makeCombination(arr, depth+1, n, i+1);
		}
	}
	
}