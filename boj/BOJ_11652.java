// https://www.acmicpc.net/problem/11652
// 카드
// 정렬
package boj;

import java.io.*;
import java.util.*;

public class BOJ_11652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        
        for(int i = 0; i<N; ++i) {
        	arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);
        long ans = arr[0];
        int maxCnt = 0;
        int cnt = 1;
        for(int i = 1; i<arr.length; ++i) {
        	if(arr[i] == arr[i-1]) {
        		++cnt;
        	}
        	else {
        		if(cnt>maxCnt) {
        			maxCnt = cnt;
        			ans = arr[i-1];
        		}
        		cnt = 1;
        	}
        }
        if(cnt>maxCnt) ans = arr[N-1];
        System.out.println(ans);
    }
}
