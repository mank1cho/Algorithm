// https://www.acmicpc.net/problem/18436
// 암호만들기
// bitMasking, DFS

package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_G5 {						
	static int L, C;
	static char[] arr;
	static final int checkbit = (1<<'a'-'a')|(1<<'e'-'a')|(1<<'i'-'a')|(1<<'o'-'a')|(1<<'u'-'a');
	
	static StringBuilder ans = new StringBuilder();
	public static void main(String args[]) throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new char[C];
		for(int i = 0; i<C; ++i) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);

		combi(0,0,0,0,new StringBuilder());
		System.out.println(ans);

	}
	
	static void combi(int x, int last, int vCnt, int cCnt, StringBuilder sb) {
		if(x == L) {
			if(vCnt < 1 || cCnt< 2) return;
			ans.append(sb).append('\n');
			return;
		}
		for(int i = last; i<C; ++i) {
			sb.append(arr[i]);
			int shifted = 1<<(arr[i]-'a');
			if((shifted&checkbit) == 0) combi(x+1, i+1, vCnt, cCnt+1, sb);
			else combi(x+1, i+1, vCnt+1, cCnt, sb);
			sb.deleteCharAt(x);
		}
	}
}
