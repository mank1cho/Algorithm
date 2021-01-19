// https://www.acmicpc.net/problem/10845
// 큐
package boj;

import java.io.*;
import java.util.*;

public class BOJ_10845 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10000];
		int head = 0;
		int tail = 0;
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			if(op.equals("push")) {
				arr[tail++] = Integer.parseInt(st.nextToken());
			}
			else if(op.equals("pop")) {
				if(head==tail) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(arr[head++]).append('\n');
				}
			}
			else if(op.equals("size")) {
				sb.append(tail-head).append('\n');
			}
			else if(op.equals("empty")) {
				if(head==tail) {
					sb.append(1);
				}
				else {
					sb.append(0);
				}
				sb.append('\n');
			}
			else if(op.equals("front")) {
				if(head==tail) {
					sb.append(-1);
				}
				else {
					sb.append(arr[head]);
				}
				sb.append('\n');
			}
			else if(op.equals("back")) {
				if(head==tail) {
					sb.append(-1);
				}
				else {
					sb.append(arr[tail-1]);
				}
				sb.append('\n');
			}
		}
		
		System.out.print(sb);
	}
}