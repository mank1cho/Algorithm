// https://www.acmicpc.net/problem/1316  그룹 단어 체커
package boj;

import java.io.*;

public class BOJ_1316 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		while(N-- > 0) {
			String s = br.readLine();
			
			boolean[] alpha = new boolean[26];
			boolean checker = true;
			char pre = '0';
			
			for(int i = 0; i<s.length(); ++i) {
				char now = s.charAt(i);
				if(now == pre) continue;
				if(alpha[now-'a'] == true) {
					checker = false;
					break;
				}
				alpha[now-'a'] = true;
				pre = now;
			}
			
			if(checker == true) ++ans;
		}
		
		System.out.print(ans);
	}
}
