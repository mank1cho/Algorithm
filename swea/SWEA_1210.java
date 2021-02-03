// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh
// [S/W 문제해결 기본] 2일차 - Ladder1
// 시뮬레이션
package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210 {
	static StringTokenizer st;
	public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	for(int t = 1; t<=10; ++t) {
    		br.readLine();
    		boolean[][] map = new boolean[101][102];
        	for(int i = 1; i<100; ++i) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 1; j<101; ++j) {
        			map[i][j] = Integer.parseInt(st.nextToken())==1;
        		}
        	}
        	int x = 99, y = 0;
    		st = new StringTokenizer(br.readLine());
    		for(int i = 0; i<100; ++i) {
    			if(Integer.parseInt(st.nextToken())==2) {
    				y = i+1; break;
    			}
    		}

    		while(x>0) {
    			if(map[x][y-1]) map[x][y--] = false;
    			else if(map[x][y+1]) map[x][y++] = false;
    			else map[x--][y] = false;
    		}
    		sb.append("#"+t+" ").append(y-1).append("\n");
    	}

    	System.out.println(sb);
	}
	
}