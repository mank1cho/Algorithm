// https://www.acmicpc.net/problem/9935
// 문자열 폭발
// 스택

package boj;

import java.io.*;

public class BOJ_9935_G4 {
	static char[] arr = new char[1000001];
	
	public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   String s = br.readLine();
	   String bomb = br.readLine();
	   
	   int idx = 0, bidx = bomb.length()-1;
	   for(int i = 0; i<s.length(); ++i) {
		   char c = s.charAt(i);
		   arr[idx++] = c;
		   if(c == bomb.charAt(bidx)) {
			   int k = idx - 1;
			   boolean flag = true;
			   for(; bidx>=0; --bidx) {
				   if(k<0 || bomb.charAt(bidx) != arr[k--]) {
					   flag = false;
					   break;
				   }
			   }
			   if(flag) {
				   idx-=bomb.length();
			   }
			   bidx = bomb.length()-1;
		   }		   
	   }
	   
	   if(idx == 0) {
		   System.out.print("FRULA");
	   }
	   else {
		   StringBuilder sb = new StringBuilder();
		   for(int i = 0; i<idx; ++i) {
			   sb.append(arr[i]);
		   }
		   System.out.print(sb);
	   }
	}
}
