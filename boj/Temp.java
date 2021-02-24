// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class Temp {
	
	// 재귀를 쓰지 않고 조합을 만드는 방법 ( 비트연산 사용 )
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
       int[] num = {1,2,3,4,5};
       
       ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
       
       for(int i = 1; i<(1<<num.length); ++i) {
    	   ArrayList<Integer> temp = new ArrayList<>();
    	   for(int j = 0; j<num.length; ++j) {
    		   if((i&(1<<j))>0) {
    			   temp.add(num[j]);
    		   }
    	   }
    	   System.out.println(temp);
    	   arr.add(temp);
       }
       
       Collections.sort(arr, (l1, l2) -> {
    	   return Integer.compare(l1.size(), l2.size());
       });

       System.out.println();
       for(int i = 0; i<arr.size(); ++i) {
    	   System.out.println(arr.get(i));
       }
    }
}


/*	소켓연결 예제
		Socket socket = new Socket("quietjun.asuscomm.com", 9876);
		ObjectOutputStream oout = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
		oout.writeObject("아놔 왜 안되지");
		Object result=oin.readObject();
		System.out.println(result);
		socket.close();
		
*/

