// 
// 
// 

package swea;

import java.io.*;
import java.util.*;

public class SWEA_ {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			N = Integer.parseInt(br.readLine());
			
			sb.append("#").append(t).append(" ").append(-1).append('\n');
		}
		System.out.println(sb);
	}

}
