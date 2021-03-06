// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_ {
 
	static int N, M, ans, cnt;
	static int[] arr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; ++i) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 0);
        System.out.println("cnt: " + cnt);
        System.out.println(ans);
    }
    
    public static void dfs(int i, int sum) {
    	++cnt;
    	if(i==N) return;
    	dfs(i+1, sum);
    	if(sum+arr[i]<M) {
    		dfs(i+1, sum+arr[i]);
    	}
    	else if(sum+arr[i] == M) {
    		++ans;
    	}
    	else return;
    }
}