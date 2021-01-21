// https://www.acmicpc.net/problem/2870
// 수학숙제
// Sort
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2870 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<String> arr = new ArrayList<>();
		
		for(int i = 0; i<N; ++i) {
			String s = br.readLine();
			StringBuilder sb = new StringBuilder();
			boolean zero = false;
			
			for(int j = 0; j<s.length(); ++j) {
				char c = s.charAt(j);
				if(c == '0' && sb.length() == 0) {
					zero = true;
					continue;
				}
				if(c>='0' && c<='9') {
					sb.append(c);
				}
				else {
					if(sb.length() == 0 && zero) {
						arr.add("0");
						zero = false; 
						continue;
					}
					else if(sb.length()!=0) {
						arr.add(sb.toString());
						sb.delete(0, sb.length());
					}
				}
			}
			
			if(sb.length() == 0 && zero) {
				arr.add("0");
			}
			else if(sb.length()!=0) {
				arr.add(sb.toString());
			}
			
		}
		
		Collections.sort(arr, (s1, s2)->{
			if(s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}
			else {
				return s1.length() - s2.length();
			}
		});
		
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i<arr.size(); ++i) {
			ans.append(arr.get(i)).append('\n');
		}
		
		System.out.print(ans);
	}
}