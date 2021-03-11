// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_ {

	static int N;
	static int[] arr;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		for (int x = 1; x <= 10; ++x) {
			N = x;
			arr = new int[N - 1];
			list = new ArrayList<>();
			int[] cnt = new int[3];
			dfs(0);
			int new2 = 0;
			for (int i = 0; i < list.size(); ++i) {
				// System.out.println(Arrays.toString(list.get(i)));
				cnt[list.get(i)[list.get(i).length - 1]]++;
				int temp = 0;
				for(int j =0; j<list.get(i).length; ++j) {
					if(list.get(i)[j] == 2) {
						temp++;
					}
				}
				if(temp == 1 && list.get(i)[list.get(i).length-1] == 2) {
					new2++;
				}
			}
			System.out.println("=============================");
			System.out.println("N = " + x + "일 때");
			System.out.println("총 갯수  = " + list.size());
			for (int i = 0; i < 2; ++i) {
				System.out.println("끝자리에 " + i + " 붙음 = " + cnt[i]);
			}
			System.out.println("끝자리에 2 붙음 = " + (cnt[2] - new2));
			
			System.out.println("0 : " + cnt[0]);
			//System.out.println("1+2 : " + (cnt[1] + cnt[2]));
			System.out.println("기존거에서 붙은 것 " + (list.size() - new2));
			System.out.println("새로 추가된 것  " + new2);
			
		}
	}

	static void dfs(int x) {
		if (x == N - 1) {
			int[] t = arr.clone();
			boolean flag = false;
			for (int i = 0; i < t.length; ++i) {
				if (t[i] == 2) {
					flag = true;
				}
			}
			if (!flag)
				return;
			flag = false;
			for (int i = 0; i < t.length; ++i) {
				if (i > 0) {
					if (t[i] == 2 && t[i - 1] == 2)
						return;
				}
				if (i > 1) {
					if (t[i] > 0 && t[i - 1] > 0 && t[i - 2] > 0)
						return;
				}
			}

			list.add(t);
			return;
		}

		for (int i = 0; i < 3; ++i) {
			arr[x] = i;
			dfs(x + 1);
		}

	}

}