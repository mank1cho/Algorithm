// https://www.acmicpc.net/problem/1072
// 게임
// Binary Search
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1072 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    long X = Long.parseLong(st.nextToken());
	    long Y = Long.parseLong(st.nextToken());
	    
	    long max = (int) 1e9;
	    long min = 0;
	    
	    long Z = Y*100/X;
	    
	    if(Z>=99) {
	    	System.out.println(-1);
	    	return;
	    }
	    
	    while(max>=min) {
	    	long mid = (max+min)/2;
	    	long newZ = (Y+mid)*100/(X+mid);
	    	if(newZ>Z) {
	    		max = mid-1;
	    	}
	    	else {
	    		min = mid+1;
	    	}
	    	//System.out.println("max : " + max + " min : " + min + " rate : " + newZ);
	    }
	    
	    System.out.println(min);
	}
} 
