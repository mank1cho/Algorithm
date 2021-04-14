// https://www.acmicpc.net/problem/
// 
// 

package boj;

import java.io.*;
import java.util.*;

public class BOJ_ {

	static int n, m;
	static char[] arr;
	static char[][] switches;

	static boolean[] visit;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		input();
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = br.readLine().toCharArray();
		switches = new char[m][];
		visit = new boolean[2 * n + 1]; //
		list = new ArrayList[2 * n + 1];

		for (int i = 0; i < m; ++i) {
			switches[i] = br.readLine().toCharArray();
		}

		int cnt = 0;
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] == '0')
				--cnt;
			else
				++cnt;
		}

		visit[cnt+n] = true;
		list[cnt+n] = new ArrayList<>();
		
		List<Integer> alist = new ArrayList<>();
		dfs(0, alist);
		
		System.out.println(Arrays.toString(visit));

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 2 * n + 1; ++i) {
			if (list[i] != null) {
				sb.append(list[i].size()).append(' ');
				for(int j = 0; j<list[i].size(); ++j) {
					sb.append(list[i].get(j)+1).append(' ');
				}
				sb.append('\n');
			}
			else {
				sb.append(-1).append('\n');
			}
		}
		
		System.out.println(sb);

	}

	public static void dfs(int depth, List<Integer> alist) {
		if (depth == m)
			return;

		// 0 0 과거
		// 0 1 미래
		// 1 0 미래
		// 1 1 과거
		int cnt = 0;
		char[] test = arr.clone();
		for (int i = 0; i < n; ++i) {
			int xor = (arr[i] - '0') ^ (switches[depth][i] - '0');
			arr[i] = (char) (xor + '0');
			if(xor == 0) --cnt;
			else ++cnt;
			
		}
		alist.add(depth);

		System.out.println("depth : " + depth + " list : "+ Arrays.toString(arr));
		
		if (!visit[cnt + n]) {
			System.out.println("?? " + (cnt));
			visit[cnt + n] = true;
			list[cnt + n] = new ArrayList<>();
			for (int i = 0; i < alist.size(); ++i) {
				list[cnt + n].add(alist.get(i));
			}

			dfs(depth + 1, alist);
		}
		
		alist.remove(alist.size() - 1);
		arr = test.clone();		
		dfs(depth + 1, alist);
		
	}

}