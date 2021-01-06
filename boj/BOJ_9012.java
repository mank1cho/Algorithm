// https://www.acmicpc.net/problem/9012
// 괄호
package boj;

import java.io.*;

public class BOJ_9012 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		while(N-->0) {
			String s = br.readLine();
			int x = 0;
			for(int i = 0; i<s.length(); ++i) {
				if(s.charAt(i) == '(') x++;
				else {
					x--;
					if(x<0) break;
				}
			}
			
			if(x == 0) System.out.println("YES");
			else System.out.println("NO");
		}
		
	}
}