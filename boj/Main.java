// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];

		int left = 0;
		int right = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}
		
		M = Integer.parseInt(br.readLine());
		
		// 1. 어느 순간이 되면
		// 2. left가 right를 넘어간다
		// 3. [결국 조건을 만족하는] 최댓값을 right로 맞춰줘야겠다.
		// 4. right와 left의 증감 조건만 잘 설정해주면 끝.
		while(left<=right) {
			int mid = (left+right)/2;
			long sum = 0;
			
			for(int i = 0; i<N; ++i) {
				if(arr[i] < mid) {
					sum+=arr[i];
				}
				else sum+=mid;
			}
			
			if(sum>M) {
				right = mid-1;
			}
			else {
				left = mid+1;
			}
			
			System.out.println("left : " + left + " , right : " + right);
		}
		System.out.println("left : " + left + " , right : " + right);
		System.out.println(right);
    }    
}
