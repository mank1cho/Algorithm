// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq
// 달팽이 숫자
// 구현
package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1954 {
	static final int[] dx = {0,1,0,-1};
	static final int[] dy = {1,0,-1,0};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[N][N];
			int x = 0, y = 0, d = 0, n = 1;
			while(n<=N*N) {
				map[x][y] = n++;
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nx<0||ny<0||nx>=N||ny>=N||map[nx][ny]!=0) {
					d = (d+1)%4;
					x+=dx[d];
					y+=dy[d];
					continue;
				}
				x=nx; y=ny;
			}
			
			sb.append("#"+t+"\n");
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					sb.append(map[i][j]).append(" ");
				}sb.append("\n");
			}
		}
		System.out.println(sb);
	}	
}