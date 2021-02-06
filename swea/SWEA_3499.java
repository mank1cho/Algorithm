// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW
// 3499. 퍼펙트 셔플
// 구현

package swea;

import java.io.*;

public class SWEA_3499 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			
			sb.append("#").append(t).append(" ");
			for(int i = 0; i<N/2; ++i) {
				sb.append(arr[i]).append(" ");
				sb.append(arr[i+N/2+(N%2)]).append(" ");
			}
			if(N%2==1) sb.append(arr[N/2]);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}