// https://www.acmicpc.net/problem/2346
// 풍선 터뜨리기
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2346 {
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       Queue<Integer> q = new LinkedList<>();
       StringTokenizer st = new StringTokenizer(br.readLine());
       while(N-->0) {
    	   q.offer(Integer.parseInt(st.nextToken()));
       }
       
       StringBuilder sb = new StringBuilder();
       sb.append(1);
       int next = q.poll();
       while(!q.isEmpty()) {
    	   if(next>0) {
    		   
    	   }
    	   else {
    		   
    	   }
       }
    }
    
}