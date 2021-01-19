// https://www.acmicpc.net/problem/9020
// 제곱ㄴㄴ수
// 에라토스테네스의 체, 정수론
package boj;

import java.io.*;
import java.util.*;

public class BOJ_9020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		
		long ans = max - min + 1;
		
		int range = (int)Math.sqrt(max);
		boolean[] prime = new boolean[range+1];
		boolean[] square = new boolean[(int) (max-min+1)];
		
		for(long i = 2; i<=range; ++i) {
			if(!prime[(int) i]) {
				for(long j = i*i; j<=range; j+=i) {
					prime[(int) j] = true;
				}
				long now = i*i;
				for(long j = ((min-1)/now+1)*now; j<=max; j+=now){
					if(!square[(int) (j-min)]) {
						--ans;
						square[(int) (j-min)] = true;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
} 