// https://www.acmicpc.net/problem/1244
// 스위치 켜고 끄기
// 구현

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {						
	public static void main(String args[]) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == 1) {
				int d = b;
				while(b<=N) {
					arr[b]^=1;
					b+=d;
				}
			}
			else {
				int offset = 1;
				arr[b]^=1;
				while(b-offset>0&&b+offset<=N&&(arr[b-offset]^arr[b+offset])==0) {
					arr[b+offset]^=1;
					arr[b-offset]^=1;
					++offset;
				}
			}
		}
		
		for(int i = 1; i<=N; ++i) {
			sb.append(arr[i]).append(" ");
			if(i%20==0) sb.append("\n");
		}
		System.out.println(sb);
	}
}
