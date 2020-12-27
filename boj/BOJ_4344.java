// https://www.acmicpc.net/problem/4344 평균은 넘겠지
package boj;

import java.io.*;

public class BOJ_4344 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int C = Integer.parseInt(br.readLine());

		while(C-- > 0) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int[] scores = new int[N];
			double avg = 0;
			
			for(int i = 0; i<N; ++i) {
				scores[i] = Integer.parseInt(input[i+1]);
				avg+=scores[i];
			}

			avg/=N;
			
			double cnt = 0;
			for(int i : scores) {
				if(i > avg) cnt+=1;
			}
			
			bw.write(String.format("%.3f", cnt/N*100));
			bw.write("%\n");
		}
		bw.flush();
	}
}

/*
Double ans = BigDecimal.valueOf(cnt)
.setScale(3, RoundingMode.HALF_UP)
.doubleValue();
*/