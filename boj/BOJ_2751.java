// https://www.acmicpc.net/problem/2751  수 정렬하기 2
// sort(O(NlogN))
package boj;

import java.io.*;
import java.util.Arrays;

public class BOJ_2751 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i<N; ++i){
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i<N; ++i){
			bw.write(arr[i] + "\n");
		}
		
		bw.flush();
	}
}