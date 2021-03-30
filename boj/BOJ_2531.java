package boj;

import java.io.*;
import java.util.*;

public class BOJ_2531 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 접시의 수
		int d = Integer.parseInt(st.nextToken());	// 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken());	// 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken());	// 쿠폰번호
		
		int[] arr = new int[N];
		for(int i = 0; i<N; ++i){
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] kinds = new int[d+1];
		
		int count = 0;
		for(int i = 0; i<k; ++i) {
			if(kinds[arr[i]]++ == 0) count++;
		}
		
		int maxCount = 0;
		if(kinds[c] == 0) {
			maxCount = Math.max(maxCount, count+1);
		}
		else {
			maxCount = Math.max(maxCount, count);
		}
		
		for(int i = k; i<N+k; ++i) {
			if(--kinds[arr[i-k]] == 0) count--;
			if(kinds[arr[i]]++ == 0) count++;
			
			if(kinds[c] == 0) {
				maxCount = Math.max(maxCount, count+1);
			}
			else {
				maxCount = Math.max(maxCount, count);
			}
		}
		
		for(int i = 0; i<k; ++i) {
			if(--kinds[arr[i-k+N]] == 0) count--;
			if(kinds[arr[i]]++ == 0) count++;
			
			if(kinds[c] == 0) {
				maxCount = Math.max(maxCount, count+1);
			}
			else {
				maxCount = Math.max(maxCount, count);
			}
		}
		
		System.out.println(maxCount);
	}

}