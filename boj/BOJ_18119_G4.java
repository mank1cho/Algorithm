// https://www.acmicpc.net/problem/18119
// 단어 암기
// 비트마스킹
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_18119_G4 {
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int bit = 0;
        for(int i = 0; i<26; ++i) {
        	bit|=1<<i;
        }
        
        int[] arr = new int[N];
        for(int i = 0; i<N; ++i) {
        	int sbit = 0;
        	String s = br.readLine();
        	for(int j = 0; j<s.length(); ++j) {
        		sbit|=1<<s.charAt(j)-'a';
        	}
        	arr[i] = sbit;
        }
        
        StringBuilder sb = new StringBuilder();
        while(M-->0) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	char c = st.nextToken().charAt(0);
        	if(x == 1) {
        		bit^=1<<c-'a';
        	}
        	else {
        		bit|=1<<c-'a';
        	}
        	int cnt = 0;
        	for(int i = 0; i<N; ++i) {
        		if((arr[i]&bit)==arr[i]) ++cnt;
        	}
        	sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}