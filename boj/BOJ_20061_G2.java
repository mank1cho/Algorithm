// https://www.acmicpc.net/problem/20061
// 모노미노도미노2
// Implementation, Simulation
package boj;

import java.io.*;
import java.util.*;

public class BOJ_20061_G2 {
	static boolean[][][] map = new boolean[2][10][4];	//x, y, color(green, blue)
	static boolean[] clear = {false, false, false, false};
	static int ans = 0;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			block(0, t, x, y);
			block(1, t^1, y, 3-x);
			checkSpecial(0);
			checkSpecial(1);
			//print();
		}
		
		int cnt = 0;
		for(int i = 0; i<10; ++i) {
			for(int j = 0; j<4; ++j) {
				if(map[0][i][j]) cnt++;
				if(map[1][i][j]) cnt++;
			}
		}
		System.out.println(ans);
		System.out.println(cnt);
	}
	
	static void block(int c, int t, int x, int y) {	// 0 -> green, 1 -> blue
		if(c==1 && t == 2) --y;	// 회전시킨게 가로모양
		if(t == 3) ++x;	// 세로모양
		// 1은 그냥 내려가면 됨.
		// 2는 x,y랑 x,y+1 확인
		// 3은 x, y 만 확인
		while(++x<11) {
			if(t == 2) {
				if(x == 10 || map[c][x][y] || map[c][x][y+1]) { 
					map[c][x-1][y] = true;
					map[c][x-1][y+1] = true;
					if(crushCheck(c, x-1)) {
						blockMove(c, x-1);
					}
					break;
				}
			}
			else {
				if(x == 10 || map[c][x][y]) {
					if(t == 3) {
						map[c][x-2][y] = true;
					}
					map[c][x-1][y] = true;
					if(crushCheck(c, x-2)) {
						blockMove(c, x-2);
					}
					if(crushCheck(c, x-1)) {
						blockMove(c, x-1);
					}
					break;
				}
			}
		}
	}
	
	static boolean crushCheck(int c, int x) {
		for(int i = 0; i<4; ++i) {
			if(!map[c][x][i]) return false;
		}
		map[c][x] = clear.clone();
		++ans;
		return true;
	}
	
	static void blockMove(int c, int x) {
		while(x>3) {
			map[c][x] = map[c][x-1].clone();
			x--;
		}
	}
	
	static void checkSpecial(int c) {
		for(int i = 0; i<4; ++i) {
			if(map[c][5][i]) {
				map[c][9] = clear.clone();
				blockMove(c, 9);
				checkSpecial(c);
				break;
			}
		}
	}
} 
