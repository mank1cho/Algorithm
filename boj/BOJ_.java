// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_ {
	// 부분집합 조합으로 구하기.
	static int N;		// 요소의 갯수
	static int[] input;	// 요소의 갯수와 같은 크기의 배열을 저장해야함.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        
        // 조합할 갯수를 인자로 넘겨준다.
        for(int i = 0; i<=N; ++i)
        	powerset(0, 1, i);
    }
    
    static void powerset(int depth, int next, int cnt) {
    	if(depth==cnt) {
    		for(int i = 0; i<cnt; ++i) {
    			System.out.print(input[i]+" ");
    		}
    		System.out.println();
    		return;
    	}
    	
    	for(int i = next; i<=N; ++i) {
    		input[depth] = i;
    		powerset(depth+1, i+1, cnt);
    	}
    }
}
