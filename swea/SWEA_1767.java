// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf
// 1767. [SW Test 샘플문제] 프로세서 연결하기
// 완전탐색

package swea;

import java.io.*;
import java.util.*;

public class SWEA_1767 {
	
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, size;
	static boolean map[][];
	static Pair[] pos = new Pair[12];
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	static int coreMax, lengthMin;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			N = Integer.parseInt(br.readLine());
			map = new boolean[N][N];
			size = 0;
			coreMax = Integer.MIN_VALUE;
			lengthMin = Integer.MAX_VALUE;
			
			for(int i = 0; i<N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken())==1?true:false;
					if(i!=0&&j!=0&&i!=N-1&&j!=N-1&&map[i][j]) {
						pos[size++] = new Pair(i, j);
					}
				}
			}
			dfs(0,0,0);
			
			sb.append("#").append(t).append(" ").append(lengthMin).append('\n');
		}
		System.out.println(sb);
	}
	
	static void dfs(int idx, int corecnt, int length) {
		if(idx==size) {
			if(coreMax<corecnt) {
				coreMax = corecnt;
				lengthMin = length;
			}
			else if(coreMax==corecnt) {
				lengthMin = Math.min(lengthMin, length);
			}
			return;
		}
		
		dfs(idx+1, corecnt, length);
		for(int d = 0; d<4; ++d) {
			if(check(pos[idx].x, pos[idx].y, d)) {
				dfs(idx+1, corecnt+1, length + fill(pos[idx].x, pos[idx].y, d, true));
				fill(pos[idx].x, pos[idx].y, d, false);
			}
		}
	}

	static boolean check(int x, int y, int d) {
		x+=dx[d]; y+=dy[d];
		while(x>=0&&y>=0&&x<N&&y<N) {
			if(map[x][y]) return false;
			x+=dx[d]; y+=dy[d];
		}
		return true;
	}
	
	static int fill(int x, int y, int d, boolean f) {
		x+=dx[d]; y+=dy[d];
		int ret = 0;
		while(x>=0&&y>=0&&x<N&&y<N) {
			map[x][y] = f;
			x+=dx[d]; y+=dy[d];
			++ret;
		}
		return ret;
	}
}
