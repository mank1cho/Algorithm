// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN
// 9229. 한빈이와 Spot Mart
// 

package swea;

import java.io.*;
import java.util.*;

public class SWEA_9229 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int ans = -1;
			for(int i = 0; i<N; ++i) {
				for(int j = i+1; j<N; ++j) {
					if(arr[i]+arr[j]<=M) {
						ans = Math.max(ans, arr[i]+arr[j]);
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);

	}

}
