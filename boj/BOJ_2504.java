// https://www.acmicpc.net/problem/2504
// 괄호의 값
// 스택
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        Stack<String> stack = new Stack<>();

		boolean err = false;
        for(int i = 0; i<s.length; ++i) {
        	if(s[i].equals("(") || s[i].equals("[")) stack.push(s[i]);
        	else {
        		int temp = 1;
        		err = true;
        		while(!stack.isEmpty()) {
        			String top = stack.pop();
        			if(top.equals("(")) {
        				if(s[i].equals(")")) {
        					temp*=2; err = false; break;
        				} else break;
        			}else if(top.equals("[")) {
        				if(s[i].equals("]")) {
        					temp*=3; err = false; break;
        				} else break;
        			}else {
        				if(temp == 1) temp = Integer.parseInt(top);
        				else temp += Integer.parseInt(top);
        			}
        		}
        		if(err) break;
        		if(s[i].equals(")")) stack.push(String.valueOf(temp));
        		else if(s[i].equals("]")) stack.push(String.valueOf(temp));
        	}
        }
        
        if(err) {System.out.println(0); return;}
        int ans = 0;
        while(!stack.isEmpty()) {
        	String top = stack.pop();
        	if(top.equals("(") || top.equals("[")) {System.out.println(0); return;}
        	ans+=Integer.parseInt(top);
        }
        System.out.println(ans);
    }
}
