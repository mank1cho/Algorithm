// https://www.acmicpc.net/problem/1644
// 소수의 연속합
// 수학, 투포인터

package boj;

import java.io.*;
import java.util.*;
// alt s r a r 자동으로 getter setter 생성

public class BOJ_1644_G3 {
	
	static final int max = 4000001;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[max];
		
		for(int i = 2; i*i<max; ++i) {
			if(prime[i]) continue;
			for(int j = i*i; j<max; j+=i) {
				prime[j] = true;
			}
		}
		
		List<Integer> primeList = new ArrayList<>();
		for(int i = 2; i<max; ++i) {
			if(!prime[i]) primeList.add(i);
		}
		
		int count = 0;
		
		int left = 0;
		int right = 0;
		int sum = 0;
		
		while(true) {
			if(sum>=n) {
				sum-=primeList.get(left++);
			} else if(right==primeList.size()){
				break;
			} else {
				sum+=primeList.get(right++);
			}
			
			if(sum==n) count++;
		}
		System.out.println(count);
	}
}