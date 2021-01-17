// https://www.acmicpc.net/problem/9375
// 패션왕 신해빈
// 경우의 수, String, HashMap
package boj;

import java.io.*;
import java.util.*;

public class BOJ_9375 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			
			while(n-->0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String kind= st.nextToken();
				if(map.containsKey(kind)) {
					map.put(kind, map.get(kind)+1);
				}
				else {
					map.put(kind, 1);
				}
			}
			
			int ans = 1;
			for(int i : map.values()) {
				ans*=i+1;
			}
			sb.append(ans-1).append('\n');
		}
		
		System.out.print(sb);
	}
}