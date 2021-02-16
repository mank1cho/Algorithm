// https://www.acmicpc.net/problem/2564
// 경비원
// 구현
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2564 {
	static int w, h, c;
	static int N;
	static int[] dis;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		c = (w+h)*2;
		N = Integer.parseInt(br.readLine());
		dis = new int[N+1];
		for(int i = 0; i<N+1; ++i) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			dis[i] = getDis(d, x);
		}
		int pos = dis[N];
		int ans = 0;
		for(int i = 0; i<N; ++i) {
			int r = Math.abs(pos-dis[i]);
			ans+=Math.min(r, c-r);
		}
		System.out.println(ans);
	}
	
	static int getDis(int d, int x) {
		if(d==1) return x;
		else if(d==2) return c-h-x;
		else if(d==3) return c-x;
		else return w+x;
	}
}