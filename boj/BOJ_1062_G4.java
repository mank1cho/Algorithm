// https://www.acmicpc.net/problem/1062
// 가르침
// String, BackTracking, BitMasking
package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1062_G4 {
	static boolean[] alphabet = new boolean[26];
	static String[] arr;
	static int N, K, ans;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new String[N];
		
		for(int i = 0; i<N; ++i) {
			String s = br.readLine();
			arr[i] = s.substring(4, s.length()-4);
			for(int j = 0; j<arr[i].length(); ++j) {
				alphabet[arr[i].charAt(j)-'a'] = true;
			}
		}
		// a,n,t,i,c
		alphabet['a'-'a'] = false;
		alphabet['n'-'a'] = false;
		alphabet['t'-'a'] = false;
		alphabet['i'-'a'] = false;
		alphabet['c'-'a'] = false;
		
		int cnt = 0;
		for(int i = 0; i<26; ++i) {
			if(alphabet[i]) cnt++;
		}
		
		K = Math.min(K-5, cnt);
		int bit = (1<<('a'-'a'))|(1<<('n'-'a'))|(1<<('t'-'a'))|(1<<('i'-'a'))|(1<<('c'-'a'));
		if(K>=0) dfs(0, bit, 0);
		System.out.print(ans);
	}
	
	public static void dfs(int x, int bit, int last) {
		if(x == K) {
			int cnt = 0;
			for(int i = 0; i<arr.length; ++i) {
				if(check(arr[i], bit)) ++cnt;
			}
			ans = Math.max(ans, cnt);
			return;
		}
		
		for(int i = last; i<26; ++i) {
			if(!alphabet[i]) continue;
			dfs(x+1, bit|(1<<i), i+1);
		}
	}
	
	public static boolean check(String s, int bit) {
		for(int j = 0; j<s.length(); ++j) {
			int now = 1 << (s.charAt(j)-'a');
			if((now&bit) == 0) return false;
		}
		return true;
	}
}