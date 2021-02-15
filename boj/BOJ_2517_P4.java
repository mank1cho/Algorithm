// https://www.acmicpc.net/problem/2517
// 달리기
// 좌표압축, Segment Tree
package boj;

import java.io.*;
import java.util.*;

public class BOJ_2517_P4 {
	
	static int[] arr;
	static int[] tree;
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       arr = new int[N];
       for (int i = 0; i < N; ++i) {
    	   arr[i] = Integer.parseInt(br.readLine());
       }
       
       // 트리 최대 높이 구한 후 사이즈 초기화
       int h = (int) Math.ceil(Math.log(N)/Math.log(2));
       tree = new int[1<<(h+1)];
       
       // 좌표압축을 위한 arr clone
       int[] copy = arr.clone();
       Arrays.sort(copy);
       
       // HashMap을 이용한 좌표압축 (겹치는요소 없음, 요소의 수는 50만 이하)
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i<N; ++i) {
    	   map.put(copy[i], i+1);
       }
       
       // [선수의 현재 등수 - 나보다 등력치가 낮은 선수의 수] 가 최선의 등수.
       // 1. 현재 등수 순으로 탐색을 진행함. 1등~N등까지 (N)
       // 2. Segment Tree를 이용하여 나보다 능력치가 높은 선수의 수를 구함 (logN)
       // 3. 나보다 능력치가 높은 선수의 수를 구한 후, Segment Tree에 나의 능력치를 update 해줌 (logN)
       // 따라서 전체 시간복잡도는 N*(logN+logN)
       StringBuilder sb = new StringBuilder();
       for(int i = 0; i<N; ++i) {
    	   sb.append(i-sum(1,0,N-1,0,map.get(arr[i]))+1).append('\n');
    	   update(1,0,N-1,map.get(arr[i]));
       }
       System.out.println(sb);
    }
    
    // 업데이트
    static void update(int node, int start, int end, int index) {
		if (index < start || index > end) return;
		tree[node] = tree[node] + 1;
		if(start!=end) {
			update(node*2, start, (start+end)/2, index);
			update(node*2+1, (start+end)/2+1, end, index);
		}
	}
    
    // 구간합 구하기
    static long sum(int node, int start, int end, int left, int right) {
		if(left>end || right<start) return 0;
		if(left<=start&&end<=right) return tree[node];
		return sum(node*2, start, (start+end)/2, left, right) + sum(node*2+1, (start+end)/2+1, end, left, right);
	}
}