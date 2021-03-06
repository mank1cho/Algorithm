// https://www.acmicpc.net/problem/1449
// 수리공항승
// 그리디
package boj;

import java.io.*;
import java.util.*;
 
public class BOj_1449 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i<N; ++i) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = 0;
        int tape = 0;
        for(int i = 0; i<N; ++i) {
        	if(arr[i]>tape) {
        		++ans;
        		tape=arr[i]+L-1;
        	}
        }
        System.out.println(ans);
    }

}