package boj;

import java.io.*;


// 1339 하는중
public class BOJ_ {

    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	long[] alphaHash = new long[26];
    	
    	int N = Integer.parseInt(br.readLine());
    	String[] arr = new String[N];
    	for(int i = 0; i<N; ++i) {
    		arr[i] = br.readLine();
    		int size = arr[i].length();
    		for(int j = 0; j<size; ++j) {
    			alphaHash[arr[i].charAt(j)-'A'] += N*(size-j+1);
    		}
    	}
    	
//    	for(int i = 0; i<26; ++i) {
//    		System.out.println(alphaHash[i]);
//    	}
    	
    	int[] alphaNum = new int[26];
    	for(int i = 9; i>=0; --i) {
    		int idx = -1;
    		long hash = 0;
    		for(int j = 0; j<26; ++j) {
    			if(alphaHash[j]>hash) {
    				idx = j;
    				hash = alphaHash[j];
    			}
    		}
    		if(idx == -1) break;
    		alphaNum[idx] = i;
    		alphaHash[idx] = 0;
    	}
    	
//    	alphaNum[0] = 8;
//    	alphaNum[2] = 9;
    	int ans = 0;
    	for(int i = 0; i<N; ++i) {
    		String s = arr[i];
    		int m = 1;
    		for(int j = s.length()-1; j>=0; --j) {
    			ans+= alphaNum[s.charAt(j)-'A'] * m;
    			m*=10;
    		}
    	}
 
//    	for(int i = 0; i<26; ++i) {
//    		System.out.println(alphaNum[i]);
//    	}
    	
    	int a = 9999999;
    	int b = 8888888;
    	for(int i = 1; i<=10; ++i) {
    		System.out.println("i : " + i + "[" + (90000000+(b*i)) + " , " + (80000000+a*i) + "]");
    	}
    	
    	
    	String s1 = "hel";
    	s1.concat("12");
    	System.out.println(s1);
//        System.out.println(ans);
    }
    
} 