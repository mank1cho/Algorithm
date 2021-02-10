// https://www.acmicpc.net/problem/14425
// 문자열 집합
// Set
package boj;

import java.io.*;
import java.util.*;

public class BOJ_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i = 0; i<N; ++i) {
     	   set.add(br.readLine());
        }
        int ans = 0;
        for(int i = 0; i<M; ++i) {
     	   String s = br.readLine();
     	   if(set.contains(s)) ++ans;
        }
        System.out.println(ans);
    }
}
