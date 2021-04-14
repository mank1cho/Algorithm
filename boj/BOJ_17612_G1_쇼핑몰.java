// https://www.acmicpc.net/problem/
// 
// 

package boj;

import java.io.*;
import java.util.*;

public class BOJ_17612_G1_쇼핑몰 {
	
	static class Info implements Comparable<Info>{
		int id;
		int counter;
		int time;
		Info(int id, int counter, int time){
			this.id = id;
			this.counter = counter;
			this.time = time;
		}
		
		@Override
		public int compareTo(Info o) {
			if(time == o.time) {
				return Integer.compare(counter, o.counter);
			}
			return Integer.compare(time, o.time);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][2]; // 회원번호, 물건의 수
		for(int i = 0; i<n; ++i) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<Info> pq = new PriorityQueue<>();
		
		int idx = 0;
		for(int i = 0; i<k&&i<n; ++i) {
			pq.add(new Info(arr[idx][0], i, arr[idx++][1]));
		}
		
		
		long ans = 0;
		long r = 1;
		int outTime = 0;
		
		Stack<Long> member = new Stack<>();
		while(!pq.isEmpty()) {
			Info out = pq.poll();
			int outId = out.id; // 고객 회원번호
			int outCounter = out.counter;
			outTime = out.time;
			
			if(idx<n) pq.add(new Info(arr[idx][0], outCounter, arr[idx++][1]+outTime));
			member.add((long)outId);
			
			while(!pq.isEmpty() && pq.peek().time == outTime) {
				out = pq.poll();
				outId = out.id; // 고객 회원번호
				outCounter = out.counter;
				outTime = out.time;
				if(idx<n) pq.add(new Info(arr[idx][0], outCounter, arr[idx++][1]+outTime));
				member.add((long)outId);
			}
			
			while(!member.isEmpty()) {
				ans+=member.pop()*r;
				r++;
			}
		}

		System.out.println(ans);
		
	}
}