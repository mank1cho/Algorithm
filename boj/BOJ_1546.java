// https://www.acmicpc.net/problem/1546  평균
package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1546 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N];
		int MAX = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			int x = Integer.parseInt(st.nextToken());
			MAX = Math.max(MAX, x);
			arr[i] = x;
		}
		double sum = 0;
		for(int i = 0; i<N; ++i) {
			sum += arr[i]/MAX*100;
		}
		System.out.print(sum/N);
	}
}
