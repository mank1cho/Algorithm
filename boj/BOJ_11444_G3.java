// https://www.acmicpc.net/problem/11444
// 피보나치 수6 (피보나치수 3은 mod가 10^x 꼴이기 때문에 피사노주기를 사용하여 해결 가능)
// Divide and Conquer
package boj;

import java.io.*;

public class BOJ_11444_G3 {
	static final long mod = (long) (1e9+7);
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		
		long[][] matrix = {{1,1},{1,0}};
		long[][] ans = {{1,0},{0,1}};
		
		//matrix^(n-1)
		--n;
		while(n>0) {
			if(n%2==1) {
				multi(ans, matrix);
			}
			n/=2;
			multi(matrix, matrix);
		}
		
		System.out.print((ans[1][0]+ans[1][1])%mod);
	}
	
	public static void multi(long[][] a, long[][] b) {
		long[][] temp = new long[2][2];
		for(int i = 0; i<2; ++i) {
			for(int j = 0; j<2; ++j) {
				temp[i][j] = a[i][0]*b[0][j]+a[i][1]*b[1][j];
			}
		}
		for(int i = 0; i<2; ++i) {
			for(int j = 0; j<2; ++j) {
				a[i][j] = temp[i][j]%mod;
			}
		}
	}
	
}