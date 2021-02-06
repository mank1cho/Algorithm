// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] ans = new int[M];
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		func(ans, arr, N, 0, 0);
		System.out.print(sb);
	}
	
	static void func(int[] ans, int[] arr, int N, int x, int n) {
		if(x == ans.length) {
			for(int i=0; i<ans.length; ++i)
				sb.append(ans[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		int before = -1;
		for(int i = n; i<arr.length; ++i) {
			if(arr[i] == before) continue;
			ans[x] = arr[i];
			before = arr[i];
			func(ans, arr, N, x+1, i);
		}
	}
}
