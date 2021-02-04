// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD
// 암호생성기
// Greedy

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t<=10; ++t) {
			br.readLine();
			int arr[] = new int[8];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int min = Integer.MAX_VALUE;
			for(int i = 0; i<8; ++i){
				arr[i] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i]);
			}
			
			int x = min/15;
			for(int i = 0; i<8; ++i) {
				arr[i] -= 15*(x-1);
			}
						
			int m = 1, c = 0;
			a:while(true) {
				for(int i = 0; i<8; ++i) {
					c++;
					arr[i]-=m;
					if(arr[i] <= 0) {
						arr[i] = 0;
						break a;
					}
					m++;
					if(m==6) m = 1;
				}
			}
			
			sb.append("#"+t+" ");
			for(int i = c%8; i<8; ++i) sb.append(arr[i]).append(" ");
			for(int i = 0; i<c%8; ++i) sb.append(arr[i]).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
