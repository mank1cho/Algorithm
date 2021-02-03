// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc
// 상호의 배틀필드
// 구현 시뮬레이션
package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873 {
	static final int[] dx = { 0, 1, 0, -1 }; // 오,아,왼,위
	static final int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] map = new char[H][W];
 
            int tx=-1, ty=-1, td=-1;
            for (int i = 0; i < H; ++i) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < W; ++j) {
                    if(map[i][j] == '>') { tx = i;   ty = j; td = 0; map[i][j] = '.';}
                    else if(map[i][j] == 'v') { tx = i; ty = j; td = 1; map[i][j] = '.';}
                    else if(map[i][j] == '<') { tx = i;  ty = j; td = 2; map[i][j] = '.';}
                    else if(map[i][j] == '^') { tx = i; ty = j; td = 3; map[i][j] = '.';}   
                }
            }
 
            int N = Integer.parseInt(br.readLine());
            String op = br.readLine();
 
            for (int i = 0; i < N; ++i) {
                char c = op.charAt(i);
                if (c == 'S') {
                    int x = tx, y = ty, d = td;
                    while(x>=0&&x<H&&y>=0&&y<W) {
                        if(map[x][y] == '#') break;
                        else if(map[x][y] == '*') { map[x][y] = '.'; break;}
                        x+=dx[d]; y+=dy[d];
                    }
                }
                else {
                    td = delta(c);
                    int nx = tx+dx[td], ny = ty+dy[td];
                    if(nx>=0&&nx<H&&ny>=0&&ny<W&&map[nx][ny]=='.') {
                        map[tx][ty] = '.';
                        tx=nx; ty=ny;
                    }
                }
            }
             
            if(td == 0) {map[tx][ty] = '>';}
            else if(td == 1) {map[tx][ty] = 'v';}
            else if(td == 2) {map[tx][ty] = '<';}
            else {map[tx][ty] = '^';}
 
            StringBuilder ans = new StringBuilder();
            for(int i = 0; i<H; ++i) {
                for(int j = 0; j<W; ++j) {
                    ans.append(map[i][j]);
                }ans.append('\n');
            }
             
            sb.append("#" + t + " ").append(ans);
        }
 
        System.out.println(sb);
    }
	static int delta(char c) {
		if (c == 'R') return 0;
		else if (c == 'D') return 1;
		else if (c == 'L') return 2;
		else return 3;
	}
}
