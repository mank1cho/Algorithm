// https://www.acmicpc.net/problem/9095
// 1,2,3 더하기
// Dynamic Programming
package boj;

import java.io.*;

public class BOJ_9095 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[11];

        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for(int i = 4; i<11; ++i)
        	dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
        
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
        	sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}
