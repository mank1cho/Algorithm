// https://www.acmicpc.net/problem/1620
// 나는야 포켓몬 마스터 이다솜
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<>();
		for(int i = 1; i<=N; ++i) {
			String k = br.readLine();
			String v = String.valueOf(i);
			map.put(k, v);
			map.put(v, k);
		}
		
		StringBuilder sb = new StringBuilder();
		while(M-->0) {
			sb.append(map.get(br.readLine())).append('\n');
		}
		
		System.out.println(sb);
	}
}