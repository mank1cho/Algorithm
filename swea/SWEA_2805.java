// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB
// 농작물 수확하기
// 시뮬레이션
package swea;

import java.io.*;

public class SWEA_2805 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; ++t) {
        	int N = Integer.parseInt(br.readLine());
        	char[][] map = new char[N][N];
        	for(int i = 0; i<N; ++i) {
        		map[i] = br.readLine().toCharArray();
        	}

        	int ans = 0;
        	for(int i = 0; i<N; ++i)
        		for(int j = 0; j<N; ++j)
        			if(Math.abs(N/2-i)+Math.abs(N/2-j)<=N/2)
        				ans+=map[i][j]-'0';

            sb.append("#"+t+" ").append(ans).append("\n");
        }
        
        System.out.println(sb);
    }
}
