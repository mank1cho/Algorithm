// https://www.acmicpc.net/problem/16120
// PPAP
// 문자열, 구현
package boj;

import java.io.*;
 
public class BOJ_16120_G4 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); ++i) {
        	sb.append(s.charAt(i));
        	if(sb.length()>=4) {
        		if(sb.substring(sb.length()-4, sb.length()).equals("PPAP")) {
        			sb.setLength(sb.length()-4);
        			sb.append('P');
        		}
        	}
        }
        if(sb.toString().equals("P")) System.out.println("PPAP");
        else System.out.println("NP");
    }
}