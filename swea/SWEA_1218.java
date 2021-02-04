// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD
// 1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기
// Stack

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1218 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t<=1; ++t) {
			int a=0,b=0,c=0,d=0; // ( [ { <
			int size = Integer.parseInt(br.readLine());
			
			String s = br.readLine();
			for(int i = 0; i<size; ++i) {
				char e = s.charAt(i);
				if(e == '(') a++;
				else if(e == ')')a--;
				else if(e == '[') b++;
				else if(e == ']') b--;
				else if(e == '{') c++;
				else if(e == '}') c--;
				else if(e == '<') d++;
				else if(e == '>') d--;
				if(a<0||b<0||c<0||d<0) break;
			}
			
			sb.append("#"+t+" ").append((a!=0|b!=0|c!=0|d!=0)==false?1:0).append("\n");
		}
		
		System.out.println(sb);
	}
}