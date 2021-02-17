// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_17135_G4 {
	
	static int N,M,D,enemyCnt,ans;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		for(int i = 1; i<=N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) enemyCnt++;
			}
		}
		
		for(int i = 0; i<M-2; ++i)
			for(int j = i+1; j<M-1; ++j)
				for(int k = j+1; k<M; ++k)
					func(new int[] {i,j,k});

		System.out.println(ans);
	}
	
	static void func(int[] combi) {
		int[][] test = new int[N+1][];
		for(int i = 0; i<=N; ++i) {
			test[i] = map[i].clone();
		}
		
		int get = 0, lose = 0;
		while(get+lose<enemyCnt) {
			// 궁수 사격
			int[][] enemy = new int[3][2];
			for(int i = 0; i<3; ++i) {
				int y = combi[i];				
				enemy[i] = find(test, N+1, y).clone();
			}
			
			// 적 제거
			for(int i = 0; i<3; ++i) {
				if(enemy[i][0] == -1) continue;
				if(test[enemy[i][0]][enemy[i][1]] == 1) {
					test[enemy[i][0]][enemy[i][1]] = 0;
					++get;
				}
			}
			
			// 첫째줄에 남아있는 적 확인
			for(int i = 0; i<M; ++i) {
				if(test[N][i] == 1) {
					lose++;
				}
			}
			// 적 한칸 전진
			for(int i = N-1; i>=0; --i) {
				test[i+1] = test[i].clone();
			}
		}
		ans = Math.max(ans, get);
	}

	static int[] find(int[][] test, int x, int y) {
		for(int d = 1; d<=D && d<=N; ++d) {
			for(int left = d-1; left>=0; --left) {
				if(y-left<0) continue;
				if(test[x-d+left][y-left] == 1) return new int[] {x-d+left,y-left};
			}
			for(int right = 1; right<d; ++right) {
				if(y+right>=M) continue;
				if(test[x-d+right][y+right] == 1) return new int[] {x-d+right, y+right};
			}
		}
		return new int[] {-1,-1};
	}
}