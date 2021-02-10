// https://www.acmicpc.net/problem/20304
// 비밀번호 제작
// BFS, Bit Masking
package boj;

import java.io.*;
import java.util.*;

public class BOJ_20304_G1 {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        boolean[] visit = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; ++i) {
        	int x = Integer.parseInt(st.nextToken());
        	q.offer(x);
        	visit[x] = true;
        }
        
        int ans = -1;
        while(!q.isEmpty()) {
        	++ans;					// 안전거리
        	int size = q.size();	// 안전거리가 동일한 요소들이 한 사이클.
        	while(size-->0) {
        		int x = q.poll();
        		for(int i = 1; i<=N; i<<=1) {	// 왼쪽으로 1 비트시프트
        			int next = x^i;				// 다음 숫자는 xor로 연산된 수
        			if(next>N || visit[next]) continue;	// N보다 큰 수 or 이미 방문한 수면 넘어감
        			visit[next] = true;			// 방문에 체크 후
        			q.offer(next);				// 큐에 푸시
        		}
        	}
        }
        
        System.out.println(ans);
    }
}
