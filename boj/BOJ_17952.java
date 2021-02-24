// https://www.acmicpc.net/problem/17952
// 과제는 끝나지 않아!
// 스택
package boj;

import java.io.*;
import java.util.*;

public class BOJ_17952 {
	
	static class INFO{
		int score, time;
		INFO(int score, int time){
			this.score = score;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		Stack<INFO> stack = new Stack<>();
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k == 1) {
				int s = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				if(t == 1) {
					ans+=s;
				}
				else {
					stack.add(new INFO(s, --t));
				}
			}
			else {
				if(stack.isEmpty()) continue;
				INFO now = stack.pop();
				if(now.time == 1) {
					ans+=now.score;
				}
				else {
					now.time--;
					stack.add(now);
				}
			}
		}
		
		System.out.println(ans);
	}
}