// https://www.acmicpc.net/problem/17478
// 재귀함수가 뭔가요?
// 재귀

package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_17478 {						
	static StringBuilder sb = new StringBuilder();
	static int N, x;
	public static void main(String args[]) throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		chatbot(N);
		System.out.println(sb);
	}
	static void chatbot(int n) {
		line(x);
		sb.append("\"재귀함수가 뭔가요?\"\n");
		if(n == 0) {
			line(x);
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			for(int i = 0; i<=N; ++i) {
				line(x);
				sb.append("라고 답변하였지.\n");
				x--;
			}
			return;
		}
		line(x);
		sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		line(x);
		sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		line(x);
		sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		x++;
		chatbot(n-1);
	}
	static void line(int x) {
		while(x-->0)
			sb.append("____");
	}
}
