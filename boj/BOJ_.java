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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	
    	int x = 0;
    	int y = 0;
    	int xx = 0;
    	int yy = 0;
        
    	if(d == 3 || d == 4) {
    		x = k;
    		xx = k;
    	}
    	
    	else {
    		y = k;
    		yy = k;
    	}
    	
    	for(int i = 0; i<5; ++i) {
        	st = new StringTokenizer(br.readLine());
        	int dd = Integer.parseInt(st.nextToken());
        	int kk = Integer.parseInt(st.nextToken());
        	if(func(d) != dd) {
        		xx = k;
        		yy = kk;
        	}
        	
        	if(dd == 3 || dd == 4) {
        		x = Math.max(x, kk);
        	}
        	
        	else {
        		y = Math.max(y, kk);
        	}
	
        	d = dd;
        	k = kk;
        }
    	
    	if(xx == 0) xx = k;
    	if(yy == 0) yy = k;
        
        int ans = (x*y-xx*yy)*N;
        System.out.println(ans);
    }
    
    static int func(int x) {
    	if(x == 4) return 2;
    	else if(x == 2) return 3;
    	else if(x == 3) return 1;
    	else return 4;
    }
    
}