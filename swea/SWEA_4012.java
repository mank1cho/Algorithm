// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH
// 4012. [모의 SW 역량테스트] 요리사
// 구현, 조합

package swea;

import java.io.*;
import java.util.*;

public class SWEA_4012 {
	static int DEPTH = 1;

	static int[][] arr;	// 주어진 배열
	static boolean[] teaming;
	static int N, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			N = Integer.parseInt(br.readLine());
			
			// 초기화
			arr = new int[N+1][N+1];
			teaming = new boolean[N+1];
			ans = Integer.MAX_VALUE;
			
			// 맵 입력
			for(int i = 1; i<=N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 1; j<=N; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//1단계. 조합을 구해야겠다 / 부분집합
			combination(0, 1);
			
			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static void combination(int count, int next) {
		if(count == N/2) {			
//			
//			System.out.println();
//			System.out.print(DEPTH++ + "번째 티밍 : ");
//			for(int i = 1; i<=N; ++i) {
//				System.out.print((teaming[i]?1:0) + " ");
//			}
//			
			
			// 2번째로 한 작업
			int[] team1 = new int[N/2];	// 배열 사이즈 주의
			int idx1 = 0;
			for(int i = 1; i<=N; ++i) {
				if(teaming[i]) {		//teaming에서 true인 것을 1팀으로
					team1[idx1++] = i;
				}
			}
			
			
			// 2번팀
			int[] team2 = new int[N/2];	// 배열 사이즈 주의
			int idx2 = 0;
			for(int i = 1; i<=N; ++i) {
				if(!teaming[i]) {		//teaming에서 false인 것을 2팀으로
					team2[idx2++] = i;
				}
			}
			
//			System.out.println();
//			System.out.print("team1 : ");
//			System.out.println(Arrays.toString(team1));
//			
//			
//			System.out.print("team2 : ");
//			System.out.println(Arrays.toString(team2));

			// 3 단계.
			int sum1 = 0;
			int sum2 = 0;
			for(int i = 0; i<N/2; ++i) {
				for(int j = 0; j<N/2; ++j) {
					sum1+=arr[team1[i]][team1[j]];
				}
			}
			
			for(int i = 0; i<N/2; ++i) {
				for(int j = 0; j<N/2; ++j) {
					sum2+=arr[team2[i]][team2[j]];
				}
			}
			
//			System.out.println("sum1 : " + sum1 + "  sum2 : " + sum2);
			
			int gap = Math.abs(sum1 - sum2);
			ans = Math.min(ans, gap);

			return;
		}
		
		for(int i = next; i<=N; ++i) {
			teaming[i] = true;
			combination(count+1, i+1);
			teaming[i] = false;
		}
		
	}
}
