// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWHPkqBqAEsDFAUn&categoryId=AWHPkqBqAEsDFAUn&categoryType=CODE
// 
package swea;

import java.io.*;
import java.util.*;

public class SWEA_3752 {
	static boolean[] visit;
	static int[] num;
	static int N;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			N = Integer.parseInt(br.readLine());
			
			visit = new boolean[10001];
			num = new int[N];
			visit[0] = true;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; ++i) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			for(int i = 0; i<N; ++i) {
				for(int j = 10000; j>=0; --j) {
					if(visit[j] == true) visit[j+num[i]] = true;
				}
			}
			
			int ans = 0;
			for(int i = 0; i<10001; ++i) {
				if(visit[i] == true) ++ans;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(ans).append("\n");
			System.out.print(sb);
		}
	}
}
