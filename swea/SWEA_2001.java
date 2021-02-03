// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq
// 파리 퇴치
// 누적합, dp
package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int map[][] = new int[N+1][N+1];
			int ans = 0;
			
			for(int i = 1; i<=N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j<=N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken()) + map[i-1][j]+map[i][j-1] - map[i-1][j-1];
					if(i-M<0 || j-M<0) continue;
					ans = Math.max(ans, map[i][j]-map[i-M][j]-map[i][j-M]+map[i-M][j-M]);
				}
			}

            sb.append("#"+t+" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}	
}