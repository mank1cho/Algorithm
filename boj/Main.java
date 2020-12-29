// https://www.acmicpc.net/problem/
// 
package boj;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] cnt = new int[10001];
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; ++i) {
			int x = Integer.parseInt(br.readLine());
			++cnt[x];
		}
		for(int i = 0; i<10001; ++i) {
			for(int j = 0; j<cnt[i]; ++j) {
				bw.write(i + "\n");
			}
		}
		bw.flush();
	}
}


/* 11650, 1181 - Sort (int, String //  Compartor, Lambda)
 * 10814 - stable Sort
 * 
 * 
 * 
 * 
 */