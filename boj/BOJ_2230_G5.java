// https://www.acmicpc.net/problem/2230
// 수 고르기
// 투포인터
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_2230_G5 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i<N; ++i) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        while(true) {
        	if(right==N) break;
        	if(arr[right] - arr[left] < M) right++;
        	else {
        		ans = Math.min(ans,  arr[right]-arr[left]);
        		left++;
        	}
        }
        System.out.println(ans);
    }
}