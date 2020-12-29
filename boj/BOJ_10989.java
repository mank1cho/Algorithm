// https://www.acmicpc.net/problem/10989  수 정렬하기 3
// Counting sort(O(N))
package boj;

import java.io.*;

public class BOJ_10989 {
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