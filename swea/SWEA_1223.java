// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14nnAaAFACFAYD
// 1223. [S/W 문제해결 기본] 6일차 - 계산기2
// Stack

package swea;

import java.io.*;
import java.util.*;

public class SWEA_1223 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t<=10; ++t) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			Stack<Integer> num = new Stack<>();
			Stack<Character> op = new Stack<>();
			for(int i = 0; i<N; ++i) {
				char c = s.charAt(i);
				if(c>='0' && c<='9') num.push(c-'0');
				else if(c == '*') {
					op.push('*');
				}
				else {
					while(!op.isEmpty() && op.peek() == '*') {
						num.push(num.pop()*num.pop());
						op.pop();
					}
					op.push('+');
				}
			}
			while(!op.isEmpty()) {
				char c = op.pop();
				if(c == '*') num.push(num.pop()*num.pop());
				else num.push(num.pop()+num.pop());
			}
			
			sb.append("#").append(t).append(" ").append(num.peek()).append("\n");
		}
		System.out.println(sb);
	}

}