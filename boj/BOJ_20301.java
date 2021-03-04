// https://www.acmicpc.net/problem/20301
// 반전 요세푸스
// 덱
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_20301 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1; i<=N; ++i) {
        	dq.offer(i);
        }
        
        int cnt = 0;
        int dCnt = 0;
        boolean reverse = false;
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()) {
        	++cnt;
        	if(!reverse) {
        		if(cnt == K) {
        			++dCnt;
        			cnt = 0;
        			sb.append(dq.poll()).append('\n');
        		}
        		else dq.offer(dq.poll());
        		if(dCnt == M) {
        			dCnt = 0;
        			reverse^=true;
        		}
        	}
        	else {
        		if(cnt==K) {
        			++dCnt;
        			cnt = 0;
        			sb.append(dq.pollLast()).append('\n');
        		}
        		else dq.offerFirst(dq.pollLast());
        		if(dCnt==M) {
        			dCnt = 0;
        			reverse^=true;
        		}
        	}
        }
        System.out.println(sb);
    }
}