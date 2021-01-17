// https://www.acmicpc.net/problem/5086
// 배수와 약수

package boj;

import java.io.*;
import java.util.*;

public class BOJ_5086 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a+b == 0) break;
			if(a%b == 0) {
				sb.append("multiple");
			}
			else if(b%a == 0) {
				sb.append("factor");
			}
			else {
				sb.append("neither");
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
}