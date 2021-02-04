// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh
// 1208. [S/W 문제해결 기본] 1일차 - Flatten
// 투포인터

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1208 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t<=10; ++t) {
			int dumpCnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[101];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			while(st.hasMoreTokens()) {
				int x = Integer.parseInt(st.nextToken());
				++arr[x];
				max = Math.max(max, x);
				min = Math.min(min, x);
			}
			
			while(max!=min) {
				if(arr[max] == arr[min]) {
					if(dumpCnt<arr[max]) break;
					dumpCnt-=arr[max];
					arr[max-1] += arr[max--];
					arr[min+1] += arr[min++];
				}
				else if(arr[max] > arr[min]) {
					if(dumpCnt<arr[min]) break;
					dumpCnt-=arr[min];
					arr[max-1] += arr[min];
					arr[max] -= arr[min];
					arr[min+1] += arr[min++];
				}
				else {
					if(dumpCnt<arr[max]) break;
					dumpCnt-=arr[max];
					arr[min+1] += arr[max];
					arr[min] -= arr[max];
					arr[max-1] += arr[max--];
				}
			}

			sb.append("#").append(t).append(" ").append(max-min).append("\n");
		}
		
		System.out.println(sb);
	}
}