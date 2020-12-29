// https://www.acmicpc.net/problem/11650  좌표 정렬하기
// sort lambda

package boj;

import java.io.*;
import java.util.*;

public class BOJ_11650 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		/* Comparator
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] e1, int[] e2) {
				if(e1[1] == e2[1]) {
					return e1[0] - e2[0];
				} else {
					return e1[1] - e2[1];
				}
			}
		});
		*/
			
		//lambda
		Arrays.sort(arr, (e1, e2) -> {
			if(e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; ++i) {
			sb.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
		}
		System.out.println(sb);
	}
}
