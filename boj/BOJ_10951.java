//https://www.acmicpc.net/problem/10951
package boj;

import java.io.*;
import java.util.*;

public class BOJ_10951 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		while((str=br.readLine()) != null) {
			st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(a+b+"\n");
		}
		System.out.print(sb);
	}
}
