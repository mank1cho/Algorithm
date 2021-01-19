// https://www.acmicpc.net/problem/18111
// 마인크래프트
// implementation, Brute Force
package boj;

import java.io.*;
import java.util.*;

public class BOJ_18111 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] height = new int[257];
		for(int i = 0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; ++j) {
				++height[Integer.parseInt(st.nextToken())];
			}
		}
		
		int t = Integer.MAX_VALUE;
		int h = 0;
		
		for(int i = 256; i>=0; --i) { //높이를 i로 맞출거임
			int block = 0;
			int time = 0;
			for(int j = 0; j<=256; ++j) {
				if(i > j) {	//블록을 쌓아야함.
					block -= (i-j)*height[j];
					time += (i-j)*height[j];
				}
				else if(i < j) { //블록을 제거해야함.
					block += (j-i)*height[j];
					time += (j-i)*height[j]*2;
				}
			}
			if(block+B<0) continue;
			if(time < t) {
				t = time;
				h = i;
			}
			else if(time == t) {
				h = Math.max(i, h);
			}
		}
		
		System.out.print(t + " " + h);
	}
}