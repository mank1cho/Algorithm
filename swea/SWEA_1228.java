// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD
// 1228. [S/W 문제해결 기본] 8일차 - 암호문1
// queue

package swea;

import java.io.*;
import java.util.*;

public class SWEA_1228 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t<=10; ++t) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[10];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<10; ++i) {
				arr[i] = st.nextToken();
			}
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; ++i) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				Queue<String> q = new LinkedList<>();
				
				for(int j = 0; j<x&&j<10; ++j) {
					q.offer(arr[j]);
				}
				while(y-->0) {
					q.offer(st.nextToken());
				}
				for(int j = x; j<10; ++j) {
					q.offer(arr[j]);
				}
				int idx = 0;
				while(!q.isEmpty()) {
					if(idx<10) arr[idx++] = q.poll();
					else q.poll();
				}
			}
			
			sb.append("#").append(t).append(" ");
			for(String s : arr) {
				sb.append(s).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}

}
