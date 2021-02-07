package boj;

import java.io.*;

public class BOJ_3687_G2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] max = new String[102];
        StringBuilder s1 = new StringBuilder("1");
        StringBuilder s2 = new StringBuilder("7");
        for(int i = 2; i<101; i+=2) {
        	max[i] = s1.toString();
        	max[i+1] = s2.toString();
        	s1.append("1");
        	s2.append("1");
	    }
        
        StringBuilder[] min = new StringBuilder[101];
        min[2] = new StringBuilder("1");
        min[3] = new StringBuilder("7");
        min[4] = new StringBuilder("4");
        min[5] = new StringBuilder("2");
        min[6] = new StringBuilder("6");
        min[7] = new StringBuilder("8");
        min[8] = new StringBuilder("10");
        min[9] = new StringBuilder("18");
        min[10] = new StringBuilder("22");
        min[11] = new StringBuilder("20");
        for(int i = 12; i<101; ++i) {
        	if(i%7==3) {
        		min[i] = new StringBuilder(min[i-6]);
        		min[i].insert(1,"0");
        	}else {
        		min[i] = new StringBuilder(min[i-7]);
        		min[i].append("8");
        	}
        }

        short N = Short.parseShort(br.readLine());
	    StringBuilder sb = new StringBuilder();
	    while(N-->0) {
	    	short n = Short.parseShort(br.readLine());
	    	sb.append(min[n]).append(" ").append(max[n]).append("\n");
	    }
        System.out.println(sb);
    }
}
