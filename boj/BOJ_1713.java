// https://www.acmicpc.net/problem/1713
// 후보 추천하기
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1713 {
	
	public static class INFO implements Comparable<INFO>{
		int num;
		int cnt;
		int old;
		INFO(int num, int cnt, int old){
			this.num = num;
			this.cnt = cnt;
			this.old = old;	//old가 작을수록 오래된거
		}
		@Override
		public int compareTo(INFO i) {
			return num - i.num;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		INFO[] arr = new INFO[N];

		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int idx = 0;
		for(int i = 0; i<K; ++i) {
			int now = Integer.parseInt(st.nextToken());
			
			boolean flag = false;
			for(int j = 0; j<idx; ++j) {
				if(arr[j].num == now) {
					arr[j].cnt++;
					flag = true;
					break;
				}
			}
			
			if(flag) continue;
			if(idx<N) {
				arr[idx++] = new INFO(now,1,i);
			}
			else {
				int cnt = 9999, old = 9999, index = 0;
				for(int j = 0; j<idx; ++j) {
					if(arr[j].cnt < cnt) {
						cnt = arr[j].cnt;
						old = arr[j].old;
						index = j;
					}
					else if(arr[j].cnt == cnt && arr[j].old < old) {
						cnt = arr[j].cnt;
						old = arr[j].old;
						index = j;
					}
				}
				arr[index] = new INFO(now,1,i);
			}
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; ++i) {
			sb.append(arr[i].num).append(' ');
		}
		System.out.print(sb);
	}
	
} 
