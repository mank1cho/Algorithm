// https://www.acmicpc.net/problem/10216
// Count Circle Groups
package boj;

import java.io.*;
import java.util.*;

public class BOJ_10216 {
	public static class INFO{
		int x, y, r;
		INFO(int x, int y, int r){
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer>[] adj = new ArrayList()[];
			
			INFO[] arr = new INFO[N];
			for(int i = 0; i<N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				arr[i] = new INFO(x,y,r);
				for(int j = 0; j<i; ++j) {
					
				}
			}
			
			
			
		}
	}
} 