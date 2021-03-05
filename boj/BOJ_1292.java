// https://www.acmicpc.net/problem/1292
// 쉽게 푸는 문제
// 누적 합
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_1292 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] arr = new int[B+1];
        
        int cnt = 1;
        int i = 1;
        while(i<=B) {
        	for(int j = 0; j<cnt&&i<=B; ++j) {
        		arr[i]+=arr[i-1]+cnt;
        		++i;
        	}
        	++cnt;
        }
        System.out.println(arr[B]-arr[A-1]);
    }
}