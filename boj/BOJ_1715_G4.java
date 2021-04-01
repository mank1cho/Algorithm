// https://www.acmicpc.net/problem/
// 
// 

package boj;

import java.io.*;
import java.util.*;

public class BOJ_1715_G4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Long> pq = new PriorityQueue<>();
		while(n-->0) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		long ans = 0;
		while(pq.size()>1) {
			long a = pq.poll();
			long b = pq.poll();
			ans+=a+b;
			pq.add(a+b);
		}
		
		System.out.println(ans);
	}
}