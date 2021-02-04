// https://www.acmicpc.net/problem/10216
// Count Circle Groups
// 구현
package boj;

import java.io.*;
import java.util.*;

public class BOJ_10216_G5 {	
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
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			int[] p = new int[N];
			for(int i = 0; i<N; ++i) {
				p[i] = i;
			}
			
			INFO[] arr = new INFO[N];
			for(int i = 0; i<N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				arr[i] = new INFO(x,y,r);
				for(int j = 0; j<i; ++j) {
					int rdis = pow(arr[i].r+arr[j].r);
					int pdis = pow(arr[i].x-arr[j].x)+pow(arr[i].y-arr[j].y);
					if(pdis<=rdis) {
						p[find(p, i)] = find(p, j);
					}
				}
			}
			
			int cnt = 0;
			for(int i = 0; i<N; ++i) {
				if(p[i] == i) ++cnt;
			}
			
			sb.append(cnt).append('\n');
			
		}
		System.out.print(sb);
	}
	
	public static int find(int[] p, int x) {
		while(p[x] != x) {
			x = p[x];
		}
		return x;
	}
	
	public static int pow(int x) {
		return x*x;
	}
}