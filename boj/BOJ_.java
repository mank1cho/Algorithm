// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_ {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        final int INF = (int) 1e9;

        for (int t = 0; t < T; ++t) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n + 2][n + 2];
            for (int i = 0; i < n + 2; ++i) {
                for (int j = 0; j < n + 2; ++j) {
                    if (i != j) map[i][j] = INF;
                }
            }
            Point[] pos = new Point[n + 2];
            for (int i = 0; i < n + 2; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                pos[i] = new Point(x, y);
            }
            for (int i = 0; i < n + 2; ++i) {
                for (int j = 0; j < n + 2; ++j) {
                    if (i == j) continue;
                    int dist = findDist(pos[i].x, pos[j].x, pos[i].y, pos[j].y);
                    if (dist <= 1000) {
                        map[i][j] = Math.min(map[i][j], dist);
                    }
                }
            }
            for (int k = 0; k < n + 2; ++k) {
                for (int i = 0; i < n + 2; ++i) {
                    for (int j = 0; j < n + 2; ++j) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }

            if (map[0][n + 1] > 0 && map[0][n + 1] < INF) sb.append("happy").append("\n");
            else sb.append("sad").append("\n");
        }
        System.out.print(sb);
    }

    static int findDist(int x1, int x2, int y1, int y2) {
        int distX = Math.abs(x1 - x2);
        int distY = Math.abs(y1 - y2);
        return distX + distY;
    }
	
}















