// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Integer, Integer> map = new TreeMap<>();
		
		map.put(2, 6);
		map.put(3, 2);
		map.put(1, 4);
		map.put(5, 3);
		map.put(6, 1);
		map.put(4, 2);
		
		System.out.println(map.toString());
		
		
		
		
	}
}