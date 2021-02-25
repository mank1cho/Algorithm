// https://www.acmicpc.net/problem/10157
// 자리배정
// 구현
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_ {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i = 0; i<N; ++i) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j = 0; j<N; ++j){
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // 행
        int row = -1;
        for(int i = 0; i<N; ++i) {
        	int cnt = 0;
        	for(int j = 0; j<N; ++j) {
        		if(arr[i][j] == 1) {
        			++cnt;
        		}
        	}
        	
        	if(cnt%2 == 1) {
        		if(row != -1) {
        			System.out.println("Corrupt");
        			return;
        		}
        		else row = i;
        	}
        }
        
        int col = -1;
        for(int i = 0; i<N; ++i) {
        	int cnt = 0;
        	for(int j = 0; j<N; ++j) {
        		if(arr[j][i] == 1) {
        			++cnt;
        		}
        	}
        	if(cnt%2 == 1) {
        		if(col != -1) {
        			System.out.println("Corrupt");
        			return;
        		}
        		else col = i;
        	}
        }

        // row == -1 col == -1	둘다 짝수
        
        // row == -1, col == j	절대 못바꾸는 경우.
        // row == i, col == -1	하나만 홀수면, 바꿔버리면 
        
        // row == i, col == j
        
        // 둘 다 짝수
        if(row == -1 && col == -1) {
        	System.out.println("OK");
        }
        
        // 둘 중 하나만 홀수
        else if(row == -1 || col == -1) {
        	System.out.println("Corrupt");
        }
        
        else {
        	System.out.println("Change bit ("+(row+1)+","+(col+1)+")");
        }
    }
}