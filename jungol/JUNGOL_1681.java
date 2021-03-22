// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=954&sca=99&sfl=wr_hit&stx=1681
// 1681:해밀턴 순환회로
// 외판원 순회
 
package jungol;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL_1681 {
	static final int INF = 1<<25;
	static int N;
	static int[][] map, dp;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][1<<N];
		
		for(int i = 0; i<N; ++i) {
			Arrays.fill(dp[i], INF);
		}
		
		for(int i = 0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(TSP(1,0));
	}
	
	static int TSP(int visit, int node) {
		if(visit == (1<<N) -1) {
			if(map[node][0] == 0) return INF;
			return map[node][0];
		}
		
		if(dp[node][visit]!=INF) {
			return dp[node][visit];
		}
		
		for(int i = 0; i<N; ++i) {
			if(map[node][i] != 0 && (visit&(1<<i))==0) {
				dp[node][visit] = Math.min(dp[node][visit], map[node][i] + TSP(visit|(1<<i), i));
			}
		}
		
		return dp[node][visit];
	}
}