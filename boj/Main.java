package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   String s = br.readLine();
	   
	   int[] arr = new int[26];
	   
	   for(int i = 0; i<s.length(); ++i) {
		   arr[s.charAt(i)-'A']++;
	   }
	   
	   int cnt = 0;
	   for(int i = 0; i<26; ++i) {
		   if(arr[i]%2 == 1) cnt++;
	   }
	   
	   StringBuilder sb = new StringBuilder();
	   if(cnt > 1) System.out.println("I'm Sorry Hansoo");
	   else {
		   char c = '0';
		   for(int i = 0; i<26; ++i) {
			   if(arr[i]%2 == 1) c = (char) (i + 'A'); 
			   for(int j = 0; j<arr[i]/2; ++j) {
				   sb.append((char) (i + 'A'));
			   }
		   }
		   if(c!='0') sb.append(c);
		   for(int i = 25; i>=0; --i) {
			   for(int j = 0; j<arr[i]/2; ++j) {
				   sb.append((char) (i + 'A'));
			   }
		   }
		   System.out.println(sb);
	   }
	}
}
