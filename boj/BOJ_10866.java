// https://www.acmicpc.net/problem/10866
// 덱
// Dequeue
package boj;

import java.io.*;
import java.util.*;

public class BOJ_10866 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> dq = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			if(op.equals("push_front")) {
				dq.offerFirst(Integer.parseInt(st.nextToken()));
			}
			else if(op.equals("push_back")) {
				dq.offerLast(Integer.parseInt(st.nextToken()));
			}
			else if(op.equals("pop_front")) {
				if(dq.isEmpty()) {
					sb.append(-1);
				}
				else {
					sb.append(dq.pollFirst());
				}
				sb.append('\n');
			}
			else if(op.equals("pop_back")) {
				if(dq.isEmpty()) {
					sb.append(-1);
				}
				else {
					sb.append(dq.pollLast());
				}
				sb.append('\n');
			}
			else if(op.equals("size")) {
				sb.append(dq.size()).append('\n');
			}
			else if(op.equals("empty")) {
				if(dq.isEmpty()) {
					sb.append(1);
				}
				else {
					sb.append(0);
				}
				sb.append('\n');
			}
			else if(op.equals("front")) {
				if(dq.isEmpty()) {
					sb.append(-1);
				}
				else {
					sb.append(dq.getFirst());
				}
				sb.append('\n');
			}
			else if(op.equals("back")) {
				if(dq.isEmpty()) {
					sb.append(-1);
				}
				else {
					sb.append(dq.getLast());
				}
				sb.append('\n');
			}
			
		}
		
		System.out.print(sb);
	}
}