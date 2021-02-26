// 
// 
// 

package swea;

import java.io.*;
import java.util.*;

public class SWEA_ {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			
			int ans = 0;
			
			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}

}
