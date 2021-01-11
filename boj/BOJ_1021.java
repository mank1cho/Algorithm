// https://www.acmicpc.net/problem/1021
// 회전하는 큐
// Dequeue
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1021 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i = 1; i<=N; ++i) {
			q.offer(i);
		}
		
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		while(M-->0) {
			int now = Integer.parseInt(st.nextToken());
			int cnt = 0;
			while(q.peek() != now) {
				q.offer(q.poll());
				++cnt;
			}
			ans+= Math.min(cnt, q.size()-cnt);
			q.poll();
		}
		System.out.print(ans);
	}
}