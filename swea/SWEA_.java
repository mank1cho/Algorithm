// 
// 
// 

package swea;

import java.io.*;
import java.util.*;

public class SWEA_ {

	static int N, ans, arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			N = Integer.parseInt(br.readLine());
			ans = 0;
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; ++i) {
				arr[i] = -Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			for(int i = 0; i<N; ++i) arr[i] = -arr[i];
			permutation(0, 0, 0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static void permutation(int depth, int sum, int left, int right, int bit) {
		if(depth == N){
			++ans;
			return;
		}
		
		for(int i = 0; i<N; ++i) {
			if((bit&(1<<i)) != 0) continue;
			permutation(depth+1, sum ,left+arr[i], right, bit|(1<<i));
			sum = right + arr[i];
			if(sum>left) continue;
			permutation(depth+1, sum, left, sum, bit|(1<<i));
		}
	}

	static int factorial(int x) {
		int ret = 1;
		x++;
		while(x-->0) ret*=x;
		return ret;
	}
}
