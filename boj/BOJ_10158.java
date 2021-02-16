// https://www.acmicpc.net/problem/10158
// 개미
// 구현
package boj;

import java.io.*;
import java.util.*;

public class BOJ_10158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		int x = 0;
		int y = 0;
		if((p+t)/w%2==1) {
			x = w-(p+t)%w;
		}
		else {
			x = (p+t)%w;
		}
		if((q+t)/h%2==1) {
			y = h-(q+t)%h;
		}
		else {
			y = (q+t)%h;
		}
		System.out.println(x + " " +y);
	}
}