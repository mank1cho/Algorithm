// https://www.acmicpc.net/problem/11653  소인수분해
// Math(Decomposition of small factors)
package boj;

import java.io.*;

public class BOJ_11653 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i<=N; ++i) {
			if(N==1) break;
			if(N%i == 0) {
				sb.append(i).append('\n');
				N/=i;
				--i;
			}
		}
		
		System.out.print(sb);
	}
}
