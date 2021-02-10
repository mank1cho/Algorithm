// https://www.acmicpc.net/problem/3613
// Java vs C++
// 문자열
package boj;

import java.io.*;
import java.util.*;

public class BOJ_3613 {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       String s = br.readLine();
       boolean java = false;
       boolean cpp = false;
       for(int i = 1; i<s.length(); ++i) {
    	   char c = s.charAt(i);
    	   if(c == '_') cpp = true;
    	   else if(c>='A' && c<='Z') java = true;
    	   if(c == '_' && s.charAt(i-1) == '_') {
    		   cpp = true;
    		   java = true;
    		   break;
    	   }
       }
       
       if(java&cpp || s.charAt(0) == '_' || (s.charAt(s.length()-1) == '_') || (s.charAt(0)>='A' && s.charAt(0)<='Z')) {
    	   System.out.println("Error!");
    	   return;
       }
       
       if(!java & !cpp) {
    	   System.out.println(s);
    	   return;
       }
       
       if(java) {
    	   for(int i = 0; i<s.length(); ++i) {
    		   char c = s.charAt(i);
        	   if(c>='A' && c<='Z') {
        		   sb.append('_');
        		   sb.append((char) (c+'a'-'A'));
        	   } 
        	   else {
        		   sb.append(c);
        	   }
    	   }
       }
       else {
    	   for(int i = 0; i<s.length(); ++i) {
    		   char c = s.charAt(i);
        	   if(c=='_') {
        		   sb.append((char) (s.charAt(++i)-'a'+'A'));
        	   }
        	   else {
        		   sb.append(c);
        	   }
    	   }
       }
       
       System.out.println(sb);
    }
}