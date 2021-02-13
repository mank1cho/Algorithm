// https://www.acmicpc.net/problem/2003
// 수들의 합2
// 투포인터
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2003 {
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       
       int[] arr = new int[N];
       st = new StringTokenizer(br.readLine());
       for(int i = 0; i<N; ++i) {
    	   arr[i] = Integer.parseInt(st.nextToken());
       }
       
       int ans = 0;
       int sum = 0;
       int left = 0;
       int right = 0;
       while(true) {
    	   if(sum>=M) sum-=arr[left++];
    	   else if(right==N) break;
    	   else sum+=arr[right++];
    	   //System.out.println(left + " " + right + " " + sum);
    	   if(sum==M) ans++;
       }
       
       System.out.println(ans);
    }
}