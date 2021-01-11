// https://www.acmicpc.net/problem/5430
// AC
// Dequeue
package boj;

import java.io.*;
import java.util.*;

public class BOJ_5430 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			String op = br.readLine();
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine().replaceAll("[^\\d]", " "));
			Deque<Integer> dq = new ArrayDeque<>();
			for(int i = 0; i<n; ++i) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			
			boolean isError = false;
			byte reverse = 0;
			for(int i = 0; i<op.length(); ++i) {
				if(op.charAt(i) == 'D') {
					if(dq.isEmpty()) {
						isError = true;
						break;
					}
					else {
						if(reverse == 0) {
							dq.pollFirst();
						}
						else {
							dq.pollLast();
						}
					}
				}
				else {
					reverse^=1;
				}
			}
			
			if(isError) {
				sb.append("error").append('\n');
			}
			else {
				sb.append('[');
				while(dq.size()>1) {
					sb.append(dq.poll()).append(", ");
				}
				if(!dq.isEmpty()) {
					sb.append(dq.poll());
				}
				sb.append(']').append('\n');
			}
		}
		
		System.out.print(sb);
	}
}