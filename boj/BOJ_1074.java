// https://www.acmicpc.net/problem/1074
// Z
// 분할정복
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1074 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int ans = 0;
		while(N-->0) {
			int s = (1<<N);
			if(r<s && c>=s) ans+=s*s;
			else if(r>=s && c<s) ans+=2*s*s;
			else if(r>=s && c>=s) ans+=3*s*s;
			r%=s; c%=s;
		}
		System.out.println(ans);
	}
}