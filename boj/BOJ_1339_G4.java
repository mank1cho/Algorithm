// https://www.acmicpc.net/problem/1339
// 단어 수학
// Greedy
package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1339_G4 {
	
	public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] alphabet = new int[26];
    	while(N-->0) {
    		String s = br.readLine();
    		int m = 1;
    		for(int i = s.length()-1; i>=0; --i) {
    			alphabet[s.charAt(i)-'A'] += m;
    			m*=10;
    		}
    	}
    	
    	Arrays.sort(alphabet);
    	int ans = 0;
    	int num = 9;
    	for(int i=0; i<10; ++i) {
    		ans+=alphabet[25-i]*num;
    		--num;
    	}
    	System.out.println(ans);
    }
	
}
