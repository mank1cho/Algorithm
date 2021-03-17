// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b7Yf6ABcBBASw
// 1486. 장훈이의 높은 선반
// powerset

package swea;

import java.io.*;
import java.util.*;

public class SWEA_1486 {
	
	static int N, height, ans;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			ans = 10000;
			powerset(0,0);
			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}

	static void powerset(int depth, int sum) {
		if(sum>height || depth==N) {
			if(sum-height<0) return;
			ans = Math.min(ans, sum - height);
			return;
		}

		powerset(depth+1, sum);
		powerset(depth+1, sum+arr[depth]);
	}
}
