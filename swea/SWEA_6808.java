// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0
// 규영이와 인영이의 카드게임
// 순열

package swea;

import java.io.*;
import java.util.*;

public class SWEA_6808 {
	
	static int[] A;
	static int[] B;
	static int[] order = new int[9];
	static boolean[] check = new boolean[9];
	static final int total = 9*8*7*6*5*4*3*2;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = 0;
			A = new int[9];
			B = new int[9];
			int idx = 0;
			boolean[] num = new boolean[19];
			for(int i = 0; i<9; ++i) {
				A[idx] = Integer.parseInt(st.nextToken());
				num[A[idx++]] = true;
			}
			idx = 0;
			for(int i = 1; i<=18; ++i) {
				if(!num[i]) {
					B[idx++] = i;
				}
			}
			
			permutation(0);
		
			sb.append("#").append(t).append(" ").append(ans).append(' ').append(total - ans).append('\n');
		}
		System.out.println(sb);

	}
	
	static void permutation(int depth) {
		if(depth == 9) {
			int aSum = 0, bSum = 0;
			for(int i = 0; i<9; ++i) {
				if(A[i] > B[order[i]]) aSum+= A[i]+B[order[i]];
				else bSum+=A[i]+B[order[i]];
			}
			if(aSum>bSum) ++ans;
			return;
		}
		
		for(int i = 0; i<9; ++i) {
			if(check[i]) continue;
			check[i] = true;
			order[depth] = i;
			permutation(depth+1);
			check[i] = false;
		}
	}
}
