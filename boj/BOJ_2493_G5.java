// https://www.acmicpc.net/problem/2493
// 탑
// Stack
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2493_G5 {
	static class INFO{
		int i, height;
		INFO(int i, int height){
			this.i = i;
			this.height = height;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] ans = new int[N];
		Stack<INFO> stack = new Stack<>();
		for(int i = N-1; i>=0; --i) {
			while(!stack.isEmpty() && arr[i] >= stack.peek().height) {
				ans[stack.pop().i] = i+1;
			}
			if(stack.isEmpty() || stack.peek().height > arr[i]) stack.push(new INFO(i, arr[i]));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i <N; ++i) sb.append(ans[i]).append(" ");
		System.out.println(sb);
	}
}
