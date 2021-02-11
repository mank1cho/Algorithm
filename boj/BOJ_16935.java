// https://www.acmicpc.net/problem/16935
// 배열 돌리기 3
// 구현
package boj;

import java.io.*;
import java.util.*;

public class BOJ_16935 {
	
	static int N, M, R, size;
	static int[][] map;
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       R = Integer.parseInt(st.nextToken());
       size = Math.max(N, M);
       map = new int[size][size];
       for(int i = 0; i<N; ++i) {
    	   st = new StringTokenizer(br.readLine());
    	   for(int j = 0; j<M; ++j) {
    		   map[i][j] = Integer.parseInt(st.nextToken());
    	   }
       }
       
       st = new StringTokenizer(br.readLine());
       for(int i = 0; i<R; ++i) {
    	   func(Integer.parseInt(st.nextToken()));
       }
       
       // 정답 출력
       StringBuilder sb = new StringBuilder();
       for(int i=0; i<N; ++i) {
    	   for(int j=0; j<M; ++j) {
    		   sb.append(map[i][j]).append(' ');
    	   }sb.append('\n');
       }
       System.out.println(sb);
    }
    
    static void func(int x) {
    	if(x==1) {
    		
    		for(int j = 0; j<M; ++j) {
    			for(int i = 0; i<N/2; ++i) {
    				int temp = map[i][j];
    				map[i][j] = map[N-1-i][j];
    				map[N-1-i][j] = temp;
    			}
    		}
    		
    	}
    	else if(x==2) {
    		
    		for(int i = 0; i<N; ++i) {
    			for(int j = 0; j<M/2; ++j) {
    				int temp = map[i][j];
    				map[i][j] = map[i][M-1-j];
    				map[i][M-1-j] = temp;
    			}
    		}
    		
    	}
 
    	else if(x==3) {		// 시계방향 90도 회전
    		int[][] temp = new int[N][];
    		for(int i = 0; i<N; ++i)
    			temp[i] = map[i].clone();
    	
    		int t = N;	// N, M SWAP
    		N = M;
    		M = t;
    		
    		for(int i = 0; i<N; ++i) {
    			for(int j = 0; j<M; ++j) {
    				map[i][j] = temp[M-1-j][i];
    			}
    		}
    	}
    	
    	else if(x==4) {		// 반시계방향 90도 회전
    		int[][] temp = new int[N][];
    		for(int i = 0; i<N; ++i)
    			temp[i] = map[i].clone();
    		
    		int t = N;	// N, M SWAP
    		N = M;
    		M = t;
    		
    		for(int i = 0; i<N; ++i) {
    			for(int j = 0; j<M; ++j) {
    				map[i][j] = temp[j][N-1-i];
    			}
    		}
    	}
    	
    	else if(x==5) {	
    		// temp에는 1사분면을 저장해 놓는다.
    		int[][] temp = new int[N/2][M/2];
    		for(int i = 0; i<N/2; ++i) {
    			for(int j = 0; j<M/2; ++j) {
    				temp[i][j] = map[i][j];
    			}
    		}
    		
    		int[] dx = {0,1,1,0}; // 1, 4, 3, 2 사분면
    		int[] dy = {0,0,1,1};
    		for(int d = 0; d<3; ++d) {	// d 는 델타

    			for(int i = 0; i<N/2; ++i) {
    				for(int j = 0; j<M/2; ++j) {
    					int firstX = i+N/2*dx[d];
    					int firstY = j+M/2*dy[d];		// d = 0 일때 얘는 0사분면.
    					
    					int SecondX = i+N/2*dx[d+1];
    					int SecondY = j+M/2*dy[d+1];	// d = 0 일때 얘는 4사분면.

    					map[firstX][firstY] = map[SecondX][SecondY];
    				}
    			}
    			
    		}

    		// 1사분면을 2사분면으로
    		for(int i = 0; i<N/2; ++i) {
    			for(int j = 0; j<M/2; ++j) {
    				map[i][j+M/2] = temp[i][j];
    			}
    		}
    	}
    	
    	else {
    		
    		int[][] temp = new int[N/2][M/2];
    		for(int i = 0; i<N/2; ++i) {
    			for(int j = 0; j<M/2; ++j) {
    				temp[i][j] = map[i][j];
    			}
    		}
    		
    		int[] dx = {0,0,1,1}; // 1,2,3,4
    		int[] dy = {0,1,1,0};
    		
    		for(int d = 0; d<3; ++d) {
    			for(int i = 0; i<N/2; ++i) {
    				for(int j = 0; j<M/2; ++j) {
    					map[i+N/2*dx[d]][j+M/2*dy[d]] = map[i+N/2*dx[d+1]][j+M/2*dy[d+1]];
    				}
    			}
    		}
    		
    		for(int i = 0; i<N/2; ++i) {
    			for(int j = 0; j<M/2; ++j) {
    				map[i+N/2][j] = temp[i][j];
    			}
    		}
    		
    	}
    }
   
}
