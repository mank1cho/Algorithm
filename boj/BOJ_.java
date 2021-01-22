// https://www.acmicpc.net/problem/
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_ {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = 0;
		while(N-->0) {
			int x = Integer.parseInt(st.nextToken());
			
			if(x != 1) {
				boolean check = true;
				for(int i = 2; i*i<x; ++i) {
					if(x%i == 0) {
						check = false;
						break;
					}
				}
				if(check) num++;
			}
		}
		
		System.out.println(num);
	}
} 
