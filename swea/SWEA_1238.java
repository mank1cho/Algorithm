// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD&categoryId=AV15B1cKAKwCFAYD&categoryType=CODE&problemTitle=Contact&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
// 1238. [S/W 문제해결 기본] 10일차 - Contact
// BFS

package swea;

import java.io.*;
import java.util.*;

public class SWEA_1238 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		for(int t = 1; t<=T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] arr = new ArrayList[101];
			for(int i = 1; i<=100; ++i) {
				arr[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				arr[u].add(v);
			}
			
			int ans = 0;
			boolean[] visit = new boolean[101];
			Queue<Integer> q = new LinkedList<>();
			q.offer(start);
			visit[start] = true;
			while(!q.isEmpty()) {
				int size = q.size();
				int max = 0;
				while(size-->0) {
					int now = q.poll();
					max = Math.max(max, now);
					for(int i = 0; i<arr[now].size(); ++i) {
						int next = arr[now].get(i);
						if(visit[next]) continue;
						visit[next] = true;
						q.offer(next);
					}
				}
				if(max>0) ans = max;
			}
			
			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}

}
