// https://www.acmicpc.net/problem/16562
// 친구비
// Union find
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_16562_G3 {
 
	static int[] union;
	static int[] money;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        money = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; ++i) {
        	money[i] = Integer.parseInt(st.nextToken());
        }
        
        union = new int[N+1];
        for(int i = 1; i<=N; ++i) {
        	union[i] = i;
        }
        
        while(M-->0) {
        	st = new StringTokenizer(br.readLine());
        	union[find(Integer.parseInt(st.nextToken()))] = find(Integer.parseInt(st.nextToken()));
        }

        System.out.println(Arrays.toString(union));
        int ans = 0;
        int[] check = new int[N+1];
        for(int i = 1; i<=N; ++i) {
        	int p = find(union[i]);
        	if(check[p] == 0) {
        		ans+=money[i];
        		check[p] = money[i];
        	}
        	else if(check[p] > money[i]) {
        		ans-=check[p];
        		ans+=money[i];
        		check[p] = money[i];
        	}
        }

        System.out.println(Arrays.toString(union));
        if(k<ans) System.out.println("Oh no");
        else System.out.println(ans);
    }
    
    static int find(int x) {
    	if(x!=union[x]) return union[x] = find(union[x]);
    	else return x;
    }

}