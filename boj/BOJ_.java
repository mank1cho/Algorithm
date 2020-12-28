// 
package boj;

import java.io.*;

public class BOJ_ {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		System.out.print(factorial(N, 1));
		//bw.flush();
	}
	
	public static int factorial(int x, int r) {
		if(x == 0) return r;
		return factorial(x-1, r * x);
	}
}