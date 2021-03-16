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
		
		int T = 10;
		for(int t = 1; t<=T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int ans = 0;
			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}

}
