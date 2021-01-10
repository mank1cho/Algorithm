// https://www.acmicpc.net/problem/2164
// 카드2
// Queue
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2164 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i<=N; ++i) {
			q.offer(i);
		}
		
		while(q.size() != 1) {
			q.poll();
			q.offer(q.poll());
		}
		
		System.out.print(q.peek());
	}
}