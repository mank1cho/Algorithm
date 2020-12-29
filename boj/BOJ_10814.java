// https://www.acmicpc.net/problem/10814  나이순 정렬
// Stable Sort

package boj;

import java.io.*;
import java.util.*;

public class BOJ_10814 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder[] person = new StringBuilder[201];
		for(int i = 0; i<person.length; ++i) {
			person[i] = new StringBuilder();
		}
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			person[age].append(age).append(' ').append(st.nextToken()).append('\n');
		}
		
		StringBuilder sb = new StringBuilder();
		for(StringBuilder val : person) {
			sb.append(val);
		}
		
		System.out.print(sb);
	}
}
//메모리 : 41584KB, 시간 : 460ms

/*		방법 2
public class BOJ_10814 {
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Person[] person = new Person[N];
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			person[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		
		Arrays.sort(person, (p1, p2) -> {
			return p1.age - p2.age;
		});

		
//		일반 Comparator를 이용한 정렬		
//		Arrays.sort(person, new Comparator<Person>() {
//
//			@Override
//			public int compare(Person p1, Person p2) {
//				return p1.age - p2.age;
//			}
//			
//		});
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; ++i) {
			sb.append(person[i].toString());
		}
		
		System.out.print(sb);
	}
	
	public static class Person{
		int age;
		String name;
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}
}
// 메모리 : 51728KB, 시간 : 764ms
*/


/*		방법 3
public class BOJ_10814 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][2];
		
		for(int i = 0; i<N; ++i) {
			arr[i] = br.readLine().split(" ");
		}
		
		Arrays.sort(arr, (String[] s1, String[] s2) -> {
			return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; ++i) {
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		}
		System.out.print(sb);
	}
}
// 메모리 : 58008KB, 시간 : 872ms
*/