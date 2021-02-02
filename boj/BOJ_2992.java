// https://www.acmicpc.net/problem/2992
// 크면서 작은 수
// Back Tracking

package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2992 {
	static String s;
	static char[] combi;
	static boolean[] check;
	static int ans = Integer.MAX_VALUE;
	static int X;
    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	s = br.readLine();
    	X = Integer.parseInt(s);
    	combi = new char[s.length()];
    	check = new boolean[s.length()];
    	dfs(0);
    	System.out.println(ans);
    }
    
    static void dfs(int x) {
    	if(x == s.length()) {
    		int m = 1;
    		int num = 0;
    		for(int i = check.length-1; i>=0; --i) {
    			num+=(combi[i]-'0')*m;
    			m*=10;
    		}
    		if(num>X) ans = Math.min(num, ans);
    		return;
    	}
    	
    	for(int i = 0; i<s.length(); ++i) {
    		if(check[i]) continue;
    		check[i] = true;
    		combi[x] = s.charAt(i);
    		dfs(x+1);
    		check[i] = false;
    	}
    }   
}
