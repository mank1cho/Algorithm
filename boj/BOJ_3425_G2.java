// https://www.acmicpc.net/problem/3425
// 고스택
// Stack
package boj;

import java.io.*;
import java.util.*;

public class BOJ_3425_G2 {
	static final int MAX = (int) 1e9;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			//첫 입력. QUIT 이면 종료
			String op = br.readLine();
			if(op.equals("QUIT")) break;
			
			ArrayList<String> opList = new ArrayList<>();	
			while(true) {
				if(op.equals("END")) break;
				opList.add(op);
				op = br.readLine();
			}
				
			int N = Integer.parseInt(br.readLine());
			while(N-->0) {
				Stack<Integer> stack = new Stack<>();
				stack.push(Integer.parseInt(br.readLine()));
				sb.append(operation(opList, stack)).append('\n');
			}
			br.readLine();
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static String operation(ArrayList<String> opList, Stack<Integer> stack) {
		final String e = "ERROR";
		for(int i = 0; i<opList.size(); ++i) {
			String op = opList.get(i);
			if(op.equals("POP")) {
				if(stack.isEmpty()) return e;
				stack.pop();
			}
			else if(op.equals("INV")) {
				stack.push(-stack.pop());
			}
			else if(op.equals("DUP")) {
				stack.push(stack.peek());
			}
			else if(op.equals("SWP")) {
				if(stack.size()<2) return e;
				int n1 = stack.pop();
				int n2 = stack.pop();
				stack.push(n1);
				stack.push(n2);
			}
			else if(op.equals("ADD")) {
				if(stack.size()<2) return e;
				int n = stack.pop() + stack.pop();
				if(n > MAX) return e;
				stack.push(n);
			}
			else if(op.equals("SUB")) {
				if(stack.size()<2) return e;
				int n1 = stack.pop();
				int n2 = stack.pop();
				n2-=n1;
				if(n2<-MAX) return e;
				stack.push(n2);
			}
			else if(op.equals("MUL")) {
				if(stack.size()<2) return e;
				long n = (long) stack.pop();
				n*=stack.pop();
				if(n > MAX) return e;
				stack.push((int) n);
			}
			else if(op.equals("DIV")) {
				if(stack.size()<2) return e;
				int n1 = stack.pop();
				int n2 = stack.pop();
				if(n1 == 0) return e;
				stack.push(n2/n1);
			}
			else if(op.equals("MOD")) {
				if(stack.size()<2) return e;
				int n1 = stack.pop();
				int n2 = stack.pop();
				if(n1 == 0) return e;
				stack.push(n2%n1);
			}
			else{
				int x = Integer.parseInt(op.substring(4));
				if(x>MAX) return e;
				stack.push(x);
			}
		}
		
		if(stack.size()!=1) return e;
		return stack.peek().toString();
	}
	
} 
