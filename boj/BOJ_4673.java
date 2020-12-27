// https://www.acmicpc.net/problem/4673  셀프 넘버
package boj;

import java.io.*;

public class BOJ_4673 {
	public static void main(String args[]) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Boolean[] arr = new Boolean[10001];
		
		for(int i = 1; i<=10000; ++i) {
			int x = i;
			int sum = i;
			while(x > 0) {
				sum+=x%10;
				x/=10;
			}
			if(sum < 10001) arr[sum] = true;
			if(arr[i] == null) bw.write(i + "\n");
		}
		bw.flush();
	}
}
