// https://www.acmicpc.net/problem/2346
// 풍선 터뜨리기
// 구현, 큐
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2346 {
	static class pair{
		int val, idx;
		pair(int x, int y){
			val = x;
			idx = y;
		}
	}
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       Queue<pair> q = new LinkedList<>();
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       for(int i = 1; i<=N; ++i) {
    	   q.offer(new pair(Integer.parseInt(st.nextToken()), i));
       }
       
       StringBuilder sb = new StringBuilder();
       int val = q.poll().val;
       sb.append(1).append(' ');
       
       while(!q.isEmpty()) {
    	   if(val > 1) {
    		   val = (val-1)%q.size();
    		   while(val-->0) q.offer(q.poll());
    	   }
    	   else if(val<0) {
    		   val%=q.size();
    		   val+=q.size();
    		   while(val-->0) q.offer(q.poll());
    	   }
    	   
    	   val = q.peek().val;
    	   sb.append(q.poll().idx).append(' ');
       }
       
       System.out.println(sb);
    }
    
}