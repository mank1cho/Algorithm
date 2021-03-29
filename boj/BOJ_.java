package boj;

import java.io.*;
import java.util.*;

class info{
   int num;
   int visited;
   
   public info(int num, int visited) {
      super();
      this.num = num;
      this.visited = visited;
   }
   
   
}
public class BOJ_ {

   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   static StringBuilder sb = new StringBuilder();
   static int N,M;
   static int[] weight;
   static boolean[] check;
   public static void main(String[] args) throws Exception{

      N = Integer.parseInt(br.readLine());
      weight = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      for(int i=0;i<N;++i) {
         weight[i]=Integer.parseInt(st.nextToken());
      }
      
      Arrays.sort(weight);
      
      //500g의 추가 최대 30개까지 있다 가정했을 때 만들 수 있는 최대 무게는 15000g이다
      check = new boolean[15001];
      
      //bfs를 통해 만들 수 있는 경우의 수 구함
      Queue<info> q = new LinkedList<>();
      
      //queue 초기 작업
      for(int i=0;i<N;++i) {
         check[weight[i]]=true;
         q.add(new info(weight[i],1<<i));
      }
      
      
      //추의 최대 개수가 30개임으로 int 변수 하나로 방문 체크 가능(bit 연산, 2^31-1이 int 최대 값이기 때문)
      while(!q.isEmpty()) {
         info item = q.poll();      
         for(int i=0;i<N;++i) {
            //아직 쓰이지 않은 추이면 bit는 0
            int bit = item.visited&(1<<i);
            //아직 체크되지 않은 무게라면 갱신해준다.
            if(bit==0 && !check[item.num+weight[i]]){
               check[item.num+weight[i]]=true;
               q.add(new info(item.num+weight[i],item.visited|(1<<i)));
            }
            //현재 계산된 무게에서 i번째 추를 저울 반대쪽에 달았을 경우도 고려함
            if(bit==0 && !check[Math.abs(item.num-weight[i])]) {
               check[Math.abs(item.num-weight[i])]=true;
               q.add(new info(Math.abs(item.num-weight[i]),item.visited|(1<<i)));
            }
         }
         
      }
      
      M = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      
      for(int i=0;i<M;++i) {
         int num = Integer.parseInt(st.nextToken());
         //만들 수 있는 최대 추의 무게를 벗어나거나 가지고 있는 추로 만들수 없는 경우
         if(num>15000 || !check[num])System.out.print("N " );
         else System.out.print("Y ");
      }

   }


}