// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWuSgKpqmooDFASy
// 7964. 부먹왕국의 차원 관문 D3
// 그리디

package swea;

import java.io.*;
import java.util.*;

public class SWEA_7964 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			int arr[] = new int[N+1];
			arr[0] = 1;
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int ans = 0;
			int gate = 0;
			for(int i = 1; i<=N; ++i) {
				if(arr[i] == 1) {
					gate = i;
				}
				else if(arr[i] == 0 && i-gate == D) {
					++ans;
					gate = i;
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}

}
