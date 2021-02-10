// https://www.acmicpc.net/problem/2697
// 다음수 구하기
// 그리디
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2697 {
	public static void main(String[] args) throws IOException {
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       StringBuilder sb = new StringBuilder();
	       int T = Integer.parseInt(br.readLine());
	       while(T-->0) {
	    	   char[] arr = br.readLine().toCharArray();
	    	   int size = arr.length;
	    	   char max = arr[size-1];
	    	   int idx = -1;
	    	   for(int i = size-2; i>=0; --i) {
	    		   if(arr[i] < max) {
	    			   idx = i;
	    			   break;
	    		   }
	    		   else max = arr[i];
	    	   }
	    	   
	    	   if(idx == -1) {
	    		   sb.append("BIGGEST").append('\n');
	    		   continue;
	    	   }
	    	   
	    	   max = '9'+1;
	    	   int nidx = 0;
	    	   for(int i = idx+1; i<size; ++i) {
	    		   if(arr[i] > arr[idx] && arr[i] < max) {
	    			   nidx = i;
	    			   max = arr[i];
	    		   }
	    	   }
	    	   
	    	   char c = arr[idx];
	    	   arr[idx] = arr[nidx];
	    	   arr[nidx] = c;
	    	   
	    	   Arrays.sort(arr, idx+1, size);
	    	   sb.append(String.valueOf(arr)).append('\n');
	       }
	       System.out.println(sb);
	    }
}
