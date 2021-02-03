// https://www.acmicpc.net/problem/13977
// 이항 계수와 쿼리
// 페르마의 소정리, 동적계획법
package boj;

import java.io.*;
import java.util.*;

public class BOJ_13977_G1 {
	static final long mod = (long) 1e9+7;
	static final int size = (int) 4e6+1;
	static long[] fact;
	static long[] factInv;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		fact = new long[size];
		factInv = new long[size];
		
		fact[0] = 1;
		for(int i = 1; i<size; ++i) {
			fact[i] = fact[i-1]*i%mod;
		}
		
		factInv[size-1] = pow(fact[size-1], mod-2);
		for(int i = size-2; i>=0; --i) {
			factInv[i] = factInv[i+1]*(i+1)%mod;
		}
		
		int M = Integer.parseInt(br.readLine());
		while(M-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			sb.append(combination(N,K)).append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static long pow(long x, long m) {
		long ret = 1;
		while(m>0) {
			if(m%2==1) {
				ret=ret*x%mod;
			}
			m>>=1;
			x=x*x%mod;
		}
		return ret;
	}
	
	public static long combination(int n, int r) {
		return fact[n]*factInv[r]%mod*factInv[n-r]%mod;
	}
}

// 테스트케이스가 적으면 아래 코드가 더 유리함. 
// factorial Inverse를 테케마다 구해주기때문에 메모리를 절약하지만 시간복잡도가 올라감.
// 하지만 N의 최댓값이 400만으로 꽤 큰값이기 때문에 factInv를 모두 초기화 하는데 걸리는 시간이 꽤 큼.
// 따라서 테스트케이스가 엄청 크지 않은 이상 아래 코드가 메모리, 시간 측면에서 유리

/*
import java.io.*;
import java.util.*;

public class Main {
	static final long mod = (long) 1e9+7;
	static final int size = (int) 4e6+1;
	static long[] fact;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		fact = new long[size];
		fact[0] = 1;
		for(int i = 1; i<size; ++i) {
			fact[i] = fact[i-1]*i%mod;
		}
		
		int M = Integer.parseInt(br.readLine());
		while(M-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			// 페르마의 소정리
			sb.append(fact[N]*pow(fact[K]*fact[N-K]%mod, mod - 2)%mod).append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static long pow(long x, long m) {
		long ret = 1;
		while(m>0) {
			if(m%2==1) {
				ret=ret*x%mod;
			}
			m>>=1;
			x=x*x%mod;
		}
		return ret;
	}
}


*/