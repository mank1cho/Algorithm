// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1136&sca=99&sfl=wr_hit&stx=1863
// 종교
// 유니온파인드

package jungol;

import java.io.*;
import java.util.*;

public class JUNGOL_1863 {

	static int[] arr;
	static int[] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n + 1];
		rank = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			arr[i] = i;
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int x = find(a);
			int y = find(b);
			if (rank[x] < rank[y]) {
				arr[x] = y; // 큰 놈에 붙여줌
				rank[y]++;	// 트리에서 레벨같은 개념
			} else {
				arr[y] = x;
				rank[x]++;
			}
		}

		int ans = 0;
		boolean[] visit = new boolean[n+1];
		for (int i = 1; i <= n; ++i) {
			int x = find(i);
			if(visit[x]) continue;
			visit[x] = true;
			++ans;
		}

		System.out.println(ans);
	}

	static int find(int x) {
		if (arr[x] == x) return x;
		return arr[x] = find(arr[x]);
	}
}
