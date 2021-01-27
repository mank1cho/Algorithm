// https://www.acmicpc.net/problem/1039
// 교환
// BFS

package boj;

import java.io.*;
import java.util.*;

public class BOJ_1039_G3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String num = st.nextToken();
		int K = Integer.parseInt(st.nextToken());
		int ans = -1;
		Queue<String> q = new LinkedList<>();
		q.offer(num);
		while(K-->0) {
			int qsize = q.size();
			boolean[] check = new boolean[1000001];
			while(qsize-->0) {
				String now = q.poll();
				int size = now.length();
				for(int i = 0; i<size; ++i) {
					for(int j = i+1; j<size; ++j) {
						if(i == 0 && now.charAt(j) == '0') continue;
						StringBuilder sb = new StringBuilder();
						for(int k = 0; k<size; ++k) {
							if(k==i) {
								sb.append(now.charAt(j));
							}
							else if(k==j) {
								sb.append(now.charAt(i));
							}
							else {
								sb.append(now.charAt(k));
							}
						}
						
						int x = Integer.parseInt(sb.toString());
						if(check[x]) continue;
						check[x] = true;
						if(K==0) ans = Math.max(ans, x);
						q.offer(sb.toString());
						//System.out.println(x);
					}
				}
			}
		}
		System.out.println(ans);
	}
}
