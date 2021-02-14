// https://www.acmicpc.net/problem/2096
// 내려가기
// Dynamic Programming
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2096_G4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] max = new int[3];
		int[] min = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		max[0] = Integer.parseInt(st.nextToken());
		max[1] = Integer.parseInt(st.nextToken());
		max[2] = Integer.parseInt(st.nextToken());
		min = max.clone();
		--N;
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int x = Math.max(max[0], max[1]);
			int y = Math.max(Math.max(max[0], max[1]), max[2]);
			int z = Math.max(max[1], max[2]);
			max[0] = x + a; max[1] = y + b; max[2] = z + c;
			x = Math.min(min[0], min[1]);
			y = Math.min(Math.min(min[0], min[1]), min[2]);
			z = Math.min(min[1], min[2]);
			min[0] = x + a; min[1] = y + b; min[2] = z + c;
		}
		
		System.out.println(Math.max(Math.max(max[0], max[1]), max[2]) + " " + Math.min(Math.min(min[0], min[1]), min[2]));
		
	}
}