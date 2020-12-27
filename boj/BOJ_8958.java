// https://www.acmicpc.net/problem/8958  OX퀴즈
package boj;

import java.io.*;

public class BOJ_8958 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; ++i) {
			String s = br.readLine();
			int cnt = 0;
			int score = 0;
			
			for(int j = 0; j < s.length(); ++j) {
				if(s.charAt(j) == 'O') ++cnt;
				else cnt = 0;
				score+=cnt;
			}
			
			bw.write(score + "\n");
		}
		bw.flush();
	}
}
