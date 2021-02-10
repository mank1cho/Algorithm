// https://www.acmicpc.net/problem/5525
// IOIOI
// 문자열
package boj;

import java.io.*;

public class BOJ_5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        int ans = 0;
        boolean f = false;
        int cnt = 0;
        for(int i = 0; i<M; ++i) {
        	if(s.charAt(i) == 'I' && !f){
        		f = true;
        		cnt++;
        		if(cnt >= N*2+1) {
        			++ans;
        		}
        	}
        	else if(s.charAt(i) == 'O' && f) {
        		f = false;
        		cnt++;
        	}
        	else {
        		cnt = 0;
        		if(s.charAt(i) == 'I') {
        			f = true; cnt = 1;
        		}
        		else f = false;
        	}
        }
        System.out.println(ans);
    }
}


