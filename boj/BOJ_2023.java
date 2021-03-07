// https://www.acmicpc.net/problem/2023
// 신기한 소수
// 수학, 백트래킹
package boj;

import java.io.*;
 
public class BOJ_2023 {
 
	static int N;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        function(2,0); function(3,0); function(5,0); function(7,0);
        System.out.println(sb);
    }
    
    static void function(int x, int n) {
    	if(n==N-1) sb.append(x).append('\n');
    	for(int i = 1; i<10; i+=2) {
    		int temp = x*10+i;
    		if(isPrime(temp)) function(temp, n+1);
    	}
    }
    
    static boolean isPrime(int x) {
    	for(int i = 2; i*i<=x; ++i) {
    		if(x%i==0) return false;
    	}
    	return true;
    }
    
}