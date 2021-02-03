// https://www.acmicpc.net/problem/1182
// 부분수열의 합
// 브루트포스
package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
	static int N, S, ans;
	static int[] arr;
	public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	S = Integer.parseInt(st.nextToken());
    	
    	arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<N; ++i) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	dfs(0,0);
    	if(S == 0) ans--;	// 0일땐 하나 빼줘야함. ans 초기값이 0이므로
    	System.out.println(ans);
    }
	
	static void dfs(int x, int sum) {
		if(x == N) {
			if(sum == S) ++ans;
			return;
		}
		dfs(x+1, sum+arr[x]);
		dfs(x+1,sum);
	}
	
}