// https://www.acmicpc.net/problem/1935
// 후위 표기식2
// 스택

package boj;

import java.io.*;
import java.util.Stack;

public class BOJ_1935 {
	public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   int N = Integer.parseInt(br.readLine());
	   String s = br.readLine();
	   double[] arr = new double[N];
	   
	   for(int i = 0; i<N; ++i) {
		   arr[i] = Double.parseDouble(br.readLine());
	   }
	   
	   Stack<Double> stack = new Stack<>();
	   for(int i = 0; i<s.length(); ++i) {
		   char c = s.charAt(i);
		   if(c>='A' && c<='Z') {
			   stack.push(arr[c-'A']);
		   }
		   else {
			   double a = stack.pop();
			   double b = stack.pop();
			   if(c == '*') {
				   stack.push(a*b);
			   }
			   else if(c == '+') {
				   stack.push(a+b);
			   }
			   else if(c == '-') {
				   stack.push(b-a);
			   }
			   else {
				   stack.push(b/a);
			   }
		   }
	   }
	   
	   System.out.printf("%.2f", stack.peek());
	   
	}
}
