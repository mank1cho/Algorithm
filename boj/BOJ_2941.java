// https://www.acmicpc.net/problem/2941
// 크로아티아 알파벳
// 문자열
package boj;

import java.io.*;

public class BOJ_2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int ans = 0;
		for(int i = 0; i<s.length(); ++i) {
			char c = s.charAt(i);
			if(c == 'c') {
				if(i+1<s.length() && (s.charAt(i+1) == '-' || s.charAt(i+1) == '=')){
					++i;
				}
				++ans;
			}
			else if(c == 'd') {
				if(i+1 < s.length() && s.charAt(i+1) == '-') {
					++i;
				}
				else if(i+2 < s.length() && s.charAt(i+1) == 'z' && s.charAt(i+2) == '=') {
					i+=2;
				}
				++ans;
			}
			else if(c == 'l') {
				if(i+1 < s.length() && s.charAt(i+1) == 'j') {
					++i;
				}
				++ans;
			}
			else if(c == 'n') {
				if(i+1 < s.length() && s.charAt(i+1) == 'j') {
					++i;
				}
				++ans;
			}
			else if(c == 's') {
				if(i+1 < s.length() && s.charAt(i+1) == '=') {
					++i;
				}
				++ans;
			}
			else if(c == 'z') {
				if(i+1 < s.length() && s.charAt(i+1) == '=') {
					++i;
				}
				++ans;
			}
			else ++ans;
		}
		System.out.println(ans);
	}
}