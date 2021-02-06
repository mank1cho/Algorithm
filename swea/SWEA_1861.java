// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc
// 1861. 정사각형 방
// Greedy

package swea;

import java.io.*;
import java.util.*;

public class SWEA_1861 {
	static class Pair{
		int x, y, c;
		Pair(int x, int y, int c){
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	
	static Pair[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			int N = Integer.parseInt(br.readLine());
			p = new Pair[N*N+1];
			for(int i = 0; i<N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; ++j) {
					p[Integer.parseInt(st.nextToken())] = new Pair(i,j,1);
				}
			}
			
			int num = 0, cnt = 0;
			for(int i = N*N-1; i>0; --i) {
				p[i].c += func(i);
				if(p[i].c>=cnt) {
					num = i;
					cnt = p[i].c;
				}
			}
			
			sb.append("#"+t+" ").append(num + " " + cnt).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int func(int x) {
		if((Math.abs(p[x].x-p[x+1].x)==1 && p[x].y==p[x+1].y)||(Math.abs(p[x].y-p[x+1].y)==1 && p[x].x==p[x+1].x)) return p[x+1].c;
		return 0;
	}
}