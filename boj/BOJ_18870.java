// https://www.acmicpc.net/problem/18870
// 좌표압축
// 좌표압축
package boj;

import java.io.*;
import java.util.*;

public class BOJ_18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] copy = arr.clone();
		Arrays.sort(copy);
		
		int cnt = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<N; ++i) {
			if(!map.containsKey(copy[i])) {
				map.put(copy[i], cnt++);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; ++i) {
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.print(sb);
	}
}
