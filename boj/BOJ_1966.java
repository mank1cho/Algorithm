// https://www.acmicpc.net/problem/1966
// 프린터 큐
// Queue
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1966 {
	public static class INFO{
		int idx, prio;
		INFO(int i, int p){
			idx = i;
			prio = p;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			Queue<INFO> q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());

			int[] pCnt = new int[10];
			int prio = 0;
			for(int i = 0; i<N; ++i) {
				int p = Integer.parseInt(st.nextToken());
				q.offer(new INFO(i, p));
				++pCnt[p];
				if(i == M) prio = p;
			}
			
			int cnt = 0;
			for(int i = 9; i>prio; --i) {
				if(pCnt[i] == 0) continue;
				int size = q.size();
				while(size-->0) {
					if(q.peek().prio == i) {
						--pCnt[i];
						q.poll();
						++cnt;
					}
					else {
						q.offer(q.poll());
					}
					if(pCnt[i] == 0) break;
				}
			}
			
			while(q.peek().idx != M) {
				if(q.peek().prio == prio) {
					q.poll();
					++cnt;
				}
				else {
					q.offer(q.poll());	
				}
			}
			
			sb.append(cnt+1).append('\n');
		}
		
		System.out.print(sb);
	}
}