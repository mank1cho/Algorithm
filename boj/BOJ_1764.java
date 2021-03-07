// https://www.acmicpc.net/problem/1764
// 듣보잡
// Set
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_1764 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        while(N-->0) {
        	set.add(br.readLine());
        }
        
        ArrayList<String> arr = new ArrayList<>();
        while(M-->0) {
        	String s = br.readLine();
        	if(set.contains(s))
        		arr.add(s);
        }
        
        Collections.sort(arr);
        System.out.println(arr.size());
        for(int i = 0; i<arr.size(); ++i) {
        	System.out.println(arr.get(i));
        }
    }
}