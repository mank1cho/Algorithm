// https://www.acmicpc.net/problem/13335
// 트럭
// 구현
package boj;

import java.io.*;
import java.util.*;

public class BOJ_13335 {
	static class pair{
		int weight, dis;
		pair(int x, int y){
			weight = x;
			dis = y;
		}
	}
    public static void main(String[] args) throws IOException {
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         int n = Integer.parseInt(st.nextToken());
         int w = Integer.parseInt(st.nextToken());
         int L = Integer.parseInt(st.nextToken());
         
         st = new StringTokenizer(br.readLine());
         int[] truck = new int[n];
         for(int i = 0; i<n; ++i) {
      	   truck[i] = Integer.parseInt(st.nextToken());
         }
         
         Queue<pair> q = new LinkedList<>();
         q.offer(new pair(truck[0], 1));
         int weight = truck[0];    // 다리 위 트럭 무게
         int idx = 1;            // 다음 트럭 인덱스
         int ans = 1;
         while(!q.isEmpty()) {
      	   ++ans;
             
             // 트럭 이동
      	   int size = q.size();
      	   while(size-->0) {
      		   pair now = q.poll();
      		   if(now.dis+1>w) {
      			   weight-=now.weight;
      		   }
      		   else {
      			   ++now.dis;
      			   q.offer(now);
      		   }
      	   }
      	   
             // 다음 트럭 올라옴
      	   if(idx < n && weight + truck[idx] <= L) {
      		   weight+=truck[idx];
      		   q.offer(new pair(truck[idx++], 1));
      	   }
         }
         
         System.out.println(ans);
      }
}