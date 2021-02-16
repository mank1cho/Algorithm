// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static String s; // 입력 받을 단어
	static char[] word; // 입력 받을 단어 담을 char형 배열
	static boolean flag; // 팰린드롬인지 아닌지
	static int ans = 0; // 팰린드롬이면 1 아니면 0

	public static void main(String[] args) throws IOException {

		s = br.readLine();

		word = new char[s.length()];

		for (int i = 0; i < word.length; i++) {
			word[i] = s.charAt(i);
		}
		
		flag = true;
		for(int i = 0; i<word.length/2; i++) {
			if(word[i] != word[word.length-i-1]) {
				flag = false;
				break;
			}
		}
		
		System.out.println(flag);
	}

}