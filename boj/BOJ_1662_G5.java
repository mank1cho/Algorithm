// https://www.acmicpc.net/problem/1662
// 압축
// 스택
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1662_G5 {
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String s = br.readLine();
       Stack<String> stack = new Stack<>();
       
       for(int i = 0; i<s.length(); ++i) {
    	   char c = s.charAt(i);
    	   if(c != ')') stack.push(Character.toString(c));
    	   else {
    		   int temp = 0;
    		   
    		   while(!stack.peek().equals("(")) {
    			   if(stack.peek().charAt(0) == '*') temp+=Integer.parseInt(stack.peek().substring(1));
    			   else ++temp;
    			   stack.pop();
    		   }
    		   
    		   stack.pop();	// (
    		   temp*=Integer.parseInt(stack.pop()); 	// 그다음 나오는건 곱하기
    		   while(!stack.isEmpty() && !stack.peek().equals("(")) {
    			   if(stack.peek().charAt(0) == '*') temp+=Integer.parseInt(stack.peek().substring(1));
    			   else ++temp;
    			   stack.pop();
    		   }
    		   
    		   stack.push("*"+Integer.toString(temp));
    	   }
       }
       
       int ans = 0;
       while(!stack.isEmpty()) {
    	   if(stack.peek().charAt(0) == '*') ans+=Integer.parseInt(stack.peek().substring(1));
		   else ++ans;
    	   stack.pop();
       }
       
       System.out.println(ans);
    }
}