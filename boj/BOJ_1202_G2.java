// https://www.acmicpc.net/problem/1202
// 보석도둑
// 그리디, 우선순위큐
package boj;

import java.io.*;
import java.util.*;
 
public class BOJ_1202_G2 {
	
	static class INFO{
		int w, v;
		INFO(int w , int v){
			this.w = w;
			this.v = v;
		}
		@Override
		public String toString() {
			return "INFO [w=" + w + ", v=" + v + "]";
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        INFO[] arr = new INFO[N];
        for(int i = 0; i<N; ++i) {
        	st = new StringTokenizer(br.readLine());
        	int w = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	arr[i] = new INFO(w, v);
        }
        
        Arrays.sort(arr, (a, b)->{
        	if(a.w == b.w) return Integer.compare(a.v, b.v);
        	return Integer.compare(a.w, b.w);
        });
        
        int[] bag = new int[K];
        for(int i = 0; i<K; ++i) {
        	bag[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(bag);

        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0,j=0; i<K; ++i) {
        	while(j<N&&bag[i]>=arr[j].w) {
        		pq.add(arr[j++].v);
        	}
        	if(!pq.isEmpty()) {
        		ans+=pq.poll();
        	}
        }
        
        System.out.println(ans);
    }

}