// https://www.acmicpc.net/problem/2243
// 사탕상자
// 세그먼트트리
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_2243_P5 {
 
	static final int size = 1000001;
	static int tree[];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int h = (int) (Math.ceil(Math.log(size)/Math.log(2))+1);
        int tree_size = (1<<(h+1));
        tree = new int[tree_size];
        
        StringBuilder sb = new StringBuilder();
        while(n-->0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	if(a==2) {
        		int c = Integer.parseInt(st.nextToken());
        		if(c>0) {	// b맛인 사탕을 넣음
        			update(1,0,size-1,b,c);
        		}
        	}
        	else {			// 순위가 b인 사탕을 뺌
        		int ans = lowerbound(b);
        		sb.append(ans).append('\n');
        		update(1,0,size-1,ans,-1);
        	}
        }
        System.out.println(sb);
    }
    
    static void update(int node, int start, int end, int index, int num) {
    	if(index < start || index >end) return;
    	tree[node]+=num;
    	int mid = (start+end)/2;
    	if(start!=end) {
    		update(node*2, start, mid, index, num);
    		update(node*2+1, mid+1, end, index, num);
    	}
    }
    
    static int sum(int node, int start ,int end, int left, int right) {
    	if(left>end||start>right) return 0;
    	if(left<=start&&end<=right) return tree[node];
    	int mid = (start+end)/2;
    	return sum(node*2, start, mid, left, right)+sum(node*2+1, mid+1, end, left, right);
    }
    
    static int lowerbound(int ans) {
    	int low = 0, high = size;
    	while(low<high){
    		int mid=(low+high)/2;
    		if(sum(1,0,size-1,1,mid)<ans) low=mid+1;
    		else high=mid;
    	}
    	return low;
    }
}