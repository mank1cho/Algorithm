// https://www.acmicpc.net/problem/11003
// 최솟값 찾기
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_11003_P5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Deque<int[]> dq = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			int x = Integer.parseInt(st.nextToken());
			while(!dq.isEmpty() && dq.peekLast()[0] > x) dq.pollLast();
			dq.offerLast(new int[] {x, i});
			while(i - dq.peek()[1] >= L) dq.poll();
			sb.append(dq.peek()[0]).append(' ');
		}
		System.out.println(sb);
	}
}