// https://www.acmicpc.net/problem/1427  소트인사이드
// sort

package boj;

import java.io.*;
import java.util.Arrays;

public class BOJ_1427 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		Arrays.sort(arr);
		for(int i = arr.length - 1; i>=0; --i) {
			System.out.print(arr[i]);
		}
	}
}
