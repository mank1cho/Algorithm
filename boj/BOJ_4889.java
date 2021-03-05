// https://www.acmicpc.net/problem/4889
// 안정적인 문자열
// 
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class BOJ_4889 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = 1;
        while(true) {
        	String s = br.readLine();
        	if(s.contains("-")) break;
        	Stack<Character> stack = new Stack<>();
        	for(int i = 0; i<s.length(); ++i) {
        		if(!stack.isEmpty() && stack.peek() == '{' && s.charAt(i) == '}') stack.pop();
        		else stack.push(s.charAt(i));
        	}
        	int ans = 0;
        	while(!stack.isEmpty()) {
        		if(stack.pop() == '}') {
        			if(stack.pop() == '}') ++ans;
        		}
        		else {
        			if(stack.pop() == '{') ++ans;
        			else ans+=2;
        		}
        	}
        	
        	sb.append(testcase++).append(". ").append(ans).append('\n');
        }
        System.out.println(sb);
    }
}