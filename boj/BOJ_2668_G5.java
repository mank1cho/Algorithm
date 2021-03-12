// https://www.acmicpc.net/problem/2668
// 숫자고르기
// 
package boj;

import java.io.*;
import java.util.Arrays;

public class BOJ_2668_G5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i = 1; i<=N; ++i) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        boolean visit[] = new boolean[N+1];
        boolean pick[] = new boolean[N+1];
        
        for(int i = 1; i<=N; ++i) {
        	if(pick[i]) continue;
        	Arrays.fill(visit, false);
        	int next = arr[i];
        	visit[i] = true;
        	while(!visit[next]) {
        		visit[next] = true;
        		next = arr[next];
        	}
        	
        	if(i!=next) continue;
        	for(int j = 1; j<=N; ++j) {
        		if(visit[j]) pick[j] = true;;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 1; i<=N; ++i) {
        	if(pick[i]) {
        		++cnt;
        		sb.append(i).append('\n');
        	}
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
    
}