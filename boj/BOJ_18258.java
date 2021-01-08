// https://www.acmicpc.net/problem/18258
// 큐2
// Queue
package boj;

import java.io.*;
import java.util.*;

public class BOJ_18258 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("push")) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			else if(s.equals("pop")) {
				if(q.isEmpty()) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(q.poll()).append('\n');
				}
			}
			else if(s.equals("size")) {
				sb.append(q.size()).append('\n');
			}
			else if(s.equals("empty")) {
				if(q.isEmpty()) {
					sb.append(1).append('\n');
				}
				else {
					sb.append(0).append('\n');
				}
			}
			else if(s.equals("front")) {
				if(q.isEmpty()) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(q.peek()).append('\n');
				}
			}
			else if(s.equals("back")) {
				if(q.isEmpty()) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(((LinkedList<Integer>) q).getLast()).append('\n');
				}
			}
			
		}
		
		System.out.println(sb);
	}
}