// https://www.acmicpc.net/problem/4358
// 생태학
// TreeMap
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeMap;

public class BOJ_4358_G4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, Integer> map = new TreeMap<>();
		
		int cnt = 0;
		String s = null;
		while((s = br.readLine()) != null) {
			if(s.equals("0")) break;
			++cnt;
			if(map.containsKey(s))
				map.put(s, map.get(s)+1);
			else
				map.put(s, 1);
		}
		
		StringBuilder sb = new StringBuilder();
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String tree = iter.next();
			int c = map.get(tree);
			sb.append(tree).append(' ').append(String.format("%.4f", (double) c*100/cnt)).append('\n');
		}
		
		System.out.println(sb);
	}
}