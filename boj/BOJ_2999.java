// https://www.acmicpc.net/problem/2999
// 비밀 이메일
// 문자열
package boj;

import java.io.*;

public class BOJ_2999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		int C = len;
		int R = 1;
		for(int i = 1; i<len; ++i) {
			if(len % (len-i) == 0) {
				if(len / (len-i) > (len-i)) break;
				C = len - i;
				R = len / (len-i);
			}
		}
		char[][] matrix = new char[R][C];
		int idx = 0;
		for(int j = 0; j<C; ++j) {
			for(int i = 0; i<R; ++i) {
				matrix[i][j] = s.charAt(idx++);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<R; ++i)
			for(int j = 0; j<C; ++j)
				sb.append(matrix[i][j]);
		
		System.out.println(sb);
	}
}