// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr
// 3289. 서로소 집합
// 서로소 집합

package swea;

import java.io.*;
import java.util.*;

public class SWEA_3289 {

	static int arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		;
		for (int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			arr = new int[n + 1];

			for(int i = 1; i<=n; ++i) {
				arr[i] = i;
			}
			
			StringBuilder ans = new StringBuilder();
			
			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int q = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(q == 0) {
					a = find(a);
					b = find(b);
					if(a!=b) arr[a] = b;
				}
				else {
					if(find(a)==find(b)) ans.append(1);
					else ans.append(0);
				}
				
			}

			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static int find(int x) {
		if(x != arr[x]) return arr[x] = find(arr[x]);
		return x;
	}

}
