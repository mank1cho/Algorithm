// https://www.acmicpc.net/problem/10250  ACM 호텔
package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10250 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int floor = N%H;
			int num = N/H+1;
			if(floor == 0) {
				floor = H;
				--num;
			}
			bw.write(Integer.toString(floor));
			bw.write(String.format("%02d", num) + "\n");
		}
		bw.flush();
	}
}
