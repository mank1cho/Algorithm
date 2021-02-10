// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD
// 1233. [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
// Binary Tree

package swea;

import java.io.*;
import java.util.*;

public class SWEA_1233 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t<=10; ++t) {
			int N = Integer.parseInt(br.readLine());
			boolean flag = true;
			for(int i = 0; i<N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				if(x*2+1<=N) {
					if(c>='0' && c<='9') {
						flag = false;
					}
				}
				else {
					if(!(c>='0' && c<='9')) {
						flag = false;
					}
				}
			}
			
			if(N%2==0) flag = false;
			
			sb.append("#").append(t).append(" ").append(flag?1:0).append('\n');
		}
		System.out.println(sb);

	}

}
