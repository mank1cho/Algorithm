// https://www.acmicpc.net/problem/9466
// 텀 프로젝트
// 사이클
package boj;

import java.io.*;
import java.util.*;

public class BOJ_9466_G4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			int[] visit = new int[N+1];
			int[] num = new int[N+1];
			int[] pick = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=N; ++i) {
				pick[i] = Integer.parseInt(st.nextToken());
			}
			
			int ans = 0;
			
			for(int i = 1; i<=N; ++i) {
				if(visit[i]>0) continue;
				visit[i] = i;
				int next = pick[i];

				int cnt = 0;
				num[i] = cnt++;
				while(visit[next] == 0) {
					visit[next] = i;
					num[next] = cnt++;	// 현재 보고있는 노드가 몇번째인지 카운트 세줌
					next = pick[next];
				}

				if(i!=visit[next]) ans+=cnt;	// 다른 사이클로 들어가버리는경우
				else ans += num[next];			// 사이클이 완성된 경우
			}			
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
}