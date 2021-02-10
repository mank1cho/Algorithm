// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT
// 5215. 햄버거 다이어트
// 부분집합

package swea;

import java.io.*;
import java.util.*;

public class SWEA_5215 {

	static class pair implements Comparable<pair>{
		int s, c;
		pair(int s, int c){
			this.s = s;
			this.c = c;
		}
		@Override
		public int compareTo(pair p) {
			if(c==p.c) return Integer.compare(p.s, s);
			return Integer.compare(c, p.c);
		}
	}
	
	static int N, L, ans;
	static pair[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			p = new pair[N];
			ans = 0;
			for(int i = 0; i<N; ++i) {
				st = new StringTokenizer(br.readLine());
				p[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(p);

			for(int i = 0; i<N; ++i) {
				if(p[i].c>L) break;
				combi(i,0,0);
			}
			
			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);

	}
	
	static void combi(int idx, int s, int c) {
		for(int i = idx; i<N; ++i) {
			if(c+p[i].c>L) return;
			s+=p[i].s;
			c+=p[i].c;
			ans = Math.max(ans, s);
			combi(i+1, s, c);
			s-=p[i].s;
			c-=p[i].c;
		}
	}
}
