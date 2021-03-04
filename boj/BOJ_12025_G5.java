// https://www.acmicpc.net/problem/12025
// 장난꾸러기 영훈
// BitMasking
package boj;

import java.io.*;

public class BOJ_12025_G5 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        for(int i = 0; i<sb.length(); ++i) {
        	if(sb.charAt(i) == '6') sb.setCharAt(i, '1');
        	else if(sb.charAt(i) == '7') sb.setCharAt(i, '2');
        }
 
        long k = Long.parseLong(br.readLine());
        --k;
        long bit = 1;
        int index = sb.length()-1;
        
        while(index>=0) {
        	while(index>0 && sb.charAt(index)!='1' && sb.charAt(index)!='2') {
        		--index;
        	}
        	if(index==-1) break;
        	if((bit&k)!=0) {
        		if(sb.charAt(index) == '1') sb.setCharAt(index, '6');
        		else if(sb.charAt(index) == '2') sb.setCharAt(index, '7');
        		k&=~bit;
        	}
        	--index;
        	bit<<=1;
        }
        
        if(k==0) System.out.println(sb);
        else System.out.println(-1);
    }
}