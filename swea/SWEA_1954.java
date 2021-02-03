// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq
// 달팽이 숫자
// 구현
package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1954 {
	static final int[] dx = {0,1,0,-1};	// 이동방향 우,하,좌,상
	static final int[] dy = {1,0,-1,0};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		// 알고리즘 구현부
		for(int t = 1; t<=T; ++t) {
			
			// 1. 맵의 크기를 받는다.
			int N = Integer.parseInt(br.readLine());
			
			int map[][] = new int[N][N];	// 맵은 전부 0으로 초기화된다.
			
			// 시작위치 0,0  방향 0  초기숫자 1
			int x = 0, y = 0, d = 0, n = 1;
			while(n<=N*N) {			// N*N 을 찍을때까지만 진행
				map[x][y] = n++;	// 맵에 현재 숫자인 n을 기입하고 n을 1 증가시킨다.
				int nx = x+dx[d];	// 달팽이가 이동할 위치
				int ny = y+dy[d];
				
				// 이동하지 못하는 곳인 경우는?
				// 1. 범위를 벗어난 경우.
				// 2. 이미 값을 표시한 곳
				if(nx<0||ny<0||nx>=N||ny>=N||map[nx][ny]!=0) {
					//그럴 경우에는 방향을 바꿔준다.
					d = (d+1)%4;
					x+=dx[d];
					y+=dy[d];
					continue;
				}
				
				// 이동할 수 있는 곳이라면 그대로 진행한다.
				x=nx; y=ny;
			}
			
			// 그린 달팽이를 StringBuilder에 입력한다.
			sb.append("#"+t+"\n");
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					sb.append(map[i][j]).append(" ");
				}sb.append("\n");
			}
		}
		//알고리즘 구현 끝
		
		System.out.println(sb);
	}	
}