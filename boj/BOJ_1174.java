// https://www.acmicpc.net/problem/1174
// 줄어드는 숫자
// 구현
package boj;

import java.io.*;
import java.util.*;

public class BOJ_1174 {
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int[] num = {9,8,7,6,5,4,3,2,1,0};
       ArrayList<Long> arr = new ArrayList<>();
       for(int i = 1; i<(1<<10); ++i) {
    	   long sum = 0;
    	   for(int j = 0; j<10; ++j) {
    		   if((i&(1<<j)) > 0) {
    			   sum = sum*10+num[j];
    		   }
    	   }
    	   arr.add(sum);
       }
       
       Collections.sort(arr);
       int n = Integer.parseInt(br.readLine());
       if(n>arr.size()) {
    	   System.out.println("-1");
    	   return;
       }
       System.out.println(arr.get(n-1));
    }
}