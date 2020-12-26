//https://www.acmicpc.net/problem/10818
package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10818 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			int x = Integer.parseInt(st.nextToken());
			if(x<min) min = x;
			if(x>max) max = x;
		}
		System.out.print(min + " " + max);		
	}
}
