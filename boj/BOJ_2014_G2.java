// https://www.acmicpc.net/problem/2014
// 소수의 곱
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2014_G2 {
	
	static int N, K;
	static ArrayList<Integer> arr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());        
        arr = new ArrayList<>();
        for(int i = 0; i<K; ++i) {
        	arr.add(Integer.parseInt(st.nextToken()));
        }
        func();
        //
        System.out.println(arr.toString());
    }
    
    static void func() {
    	int start = 0;
    	while(true) {
    		int size = arr.size();
    		for(int i = 0; i<start; ++i) {
    			for(int j = start; j<size; ++j) {
    				arr.add(arr.get(i)*arr.get(j));
    				if(arr.size() >= N) return;
    			}
    		}
    		for(int i = start; i<size; ++i) {
    			for(int j = i; j<size; ++j) {
    				arr.add(arr.get(i)*arr.get(j));
    				if(arr.size() >= N) return;
    			}
    		}
    		
    		start = size;
    	}
    }
}