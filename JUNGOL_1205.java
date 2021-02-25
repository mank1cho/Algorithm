// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=488&sca=99
// 조커
// 투포인터

import java.io.*;
import java.util.*;
 
public class JUNGOL_1205 {
 
    static boolean[] arr = new boolean[1001001];
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int zeroCnt = 0;
        int max = 1;
        int min = 1<<30;
         
        while(N-->0) {
            int x = Integer.parseInt(st.nextToken());
            if(x==0) zeroCnt++;
            else {
                arr[x] = true;
                max = Math.max(x, max);
                min = Math.min(x, min);
            }
        }
         
        int ans = zeroCnt;
        int left = min;
        int right = min;
         
        while(right<=max+zeroCnt && left<=max) {
            if(arr[right]) {
                ++right;
            }
            else {
                if(zeroCnt>0) {
                    ++right;
                    --zeroCnt;
                }
                else {
                    if(!arr[left]) {
                        ++zeroCnt;
                    }
                    ++left;
                }
            }
            ans = Math.max(ans, right-left);
        }
         
        System.out.println(ans);
    }
}