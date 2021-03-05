// https://www.acmicpc.net/problem/3048
// 개미
// 시뮬레이션
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_3048 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());
        String s1 = br.readLine();
        String s2 = br.readLine();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int idx1 = s1.length()-1;
        int idx2 = 0;
        
        while(idx1>t) sb.append(s1.charAt(idx1--));
        while(t>0) {
        	if(t>=s1.length()) {
        		if(idx2<s2.length())
        			sb.append(s2.charAt(idx2++));
        	}
        	else {
        		if(idx1>=0)
        			sb.append(s1.charAt(idx1--));
        		if(idx2<s2.length())
        			sb.append(s2.charAt(idx2++));
        	}
        	t--;
        }
        while(idx1>=0) sb.append(s1.charAt(idx1--));
        while(idx2<s2.length()) sb.append(s2.charAt(idx2++));
        System.out.println(sb);
    }

}