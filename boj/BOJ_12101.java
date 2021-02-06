// https://www.acmicpc.net/problem/12101
// 1,2,3 더하기
// Back Tracking

package boj;

import java.io.*;
import java.util.*;

public class BOJ_12101 {
	static int n, k, cnt;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        sb.append(-1);
        dfs(0, new LinkedList<>());
        System.out.println(sb);
    }
    
    static void dfs(int sum, LinkedList<Integer> list) {
    	if(sum > n) return;
    	else if(sum == n) {
    		if(++cnt == k) {
    			sb.delete(0,2);
    			for(int i = 0; i<list.size(); ++i) {
    				sb.append(list.get(i)).append("+");
    			}
    			sb.deleteCharAt(sb.length()-1);
    		}
    		return;
    	}
    	
    	for(int i = 1; i<=3; ++i) {
    		list.add(i);
    		dfs(sum+i, list);
    		list.removeLast();
    	}
    }
}
