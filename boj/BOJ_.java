// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_ {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
	}
	
}

class Solution123 {
    public String solution(String[] table, String[] languages, int[] preference) {
               
        String[][] arr = new String[7][5];
        for(int i = 0; i<5; ++i) {
        	StringTokenizer st = new StringTokenizer(table[i]);
        	for(int j = 6; j>0; --j) {
        		arr[j][i] = st.nextToken();
        	}
        }
        
        int max = 0;
        int maxIdx = -1;
        
        for(int i = 0; i<5; ++i) {
        	int sum = 0;
        	for(int k = 0; k<languages.length; ++k) {
        		for(int j = 1; j<6; ++j) {
        			if(arr[j][i].equals(languages[k])) {
        				sum+=j*preference[k];
        				break;
        			}
        		}
        	}
        	if(sum>max) {
        		max = sum;
        		maxIdx = i;
        	}
        }
        
        String s = "";
        s.compareTo("");
        
        return arr[6][maxIdx];
    }
}

class Solution2 {
    public int[] solution(String inp_str) {
        
        // 같은 문자 연속 여부
        // 같은 문자 5개 이상 포함되면 x 이건 배열로.
        // 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자 중 3 종류 이상 포함.
        boolean[] isRight = new boolean[6];
        Arrays.fill(isRight, true);
        
        if(inp_str.length() < 8 || inp_str.length()>15) {
        	isRight[1] = false;
        }

        boolean[] charset = new boolean[255];
        int[] charCount = new int[255];
        charset['~'] = true;
        charset['!'] = true;
        charset['@'] = true;
        charset['#'] = true;
        charset['$'] = true;
        charset['%'] = true;
        charset['^'] = true;
        charset['&'] = true;
        charset['*'] = true;
        
        for(int i = 'A'; i<='Z'; ++i) {
        	charset[i] = true;
        }
        
        for(int i = 'a'; i<='z'; ++i) {
        	charset[i] = true;
        }
        
        for(int i = '0'; i<='9'; ++i) {
        	charset[i] = true;
        }
        
        boolean[] kindOfchar = new boolean[4];
        
        
        
        int cnt = 1;
        for(int i = 0; i<inp_str.length(); ++i){
            char c = inp_str.charAt(i);
            if(charset[c] == false){
                isRight[2] = false;
            }
            
            if(Character.isLowerCase(c)){
                kindOfchar[0]= true;
            }
            else if(Character.isUpperCase(c)){
                kindOfchar[1]= true;
            }
            else if(Character.isDigit(c)){
                kindOfchar[2]= true;
            }
            else if(charset[c]){
                kindOfchar[3]= true;
            }
            
            if(i!=0){
                if(c == inp_str.charAt(i-1)){
                    ++cnt;
                    if(cnt == 4) isRight[4] = false;
                }
                else{
                    cnt = 1;
                }
            }
        }
        
        int kindCount = 0;
        for(int i = 0; i<4; ++i){
            if(kindOfchar[i]){
                kindCount++;
            }
        }
        
        if(kindCount<3) isRight[3] = false;
        
        for(int i = 0; i<255; ++i){
            if(charCount[i]>=5){
                isRight[5] = false;
                break;
            }
        }
        
        int falseCount = 0;
        for(int i = 1; i<=5; ++i){
            if(isRight[i] == false){
                falseCount++;
            }
        }
        
        if(falseCount == 0){
            return new int[]{0};
        }
        
        
        int[] answer = new int[falseCount];
        int idx = 0;
        for(int i = 1; i<=5; ++i){
            if(isRight[i] == false){
                answer[idx++] = i;
            }
        }
        
        return answer;
    }
}

class Solution3 {
    public int[] solution(int[] enter, int[] leave) {
        
        int size = enter.length;
        
        int[] answer = new int[size];
        
        Set<Integer> nowInPeoples = new HashSet<>();
        
        int enterIdx = 0;
        for(int i = 0; i<size; ++i) {
        	int nowOut = leave[i];
        	while(!nowInPeoples.contains(nowOut)) {
        		answer[enter[enterIdx]-1] += nowInPeoples.size();
        		Iterator<Integer> it = nowInPeoples.iterator();
        		while(it.hasNext()) {
        			answer[it.next()-1]++;
        		}
        		nowInPeoples.add(enter[enterIdx++]);
        	}
        	
        	nowInPeoples.remove(nowOut);
        }
        
        return answer;
    }
}


class Solution4 {
	
	static class INFO{
		int id, pid;
		String name;
		INFO(int id, String name, int pid){
			this.id = id;
			this.pid = pid;
			this.name = name;
		}
	}
	
    public String[] solution(String[] data, String word) {
        String[] answer = {};
        int size = data.length;
        INFO[] arr = new INFO[size+1];
        
        for(int i = 1; i<=data.length; ++i) {
        	StringTokenizer st = new StringTokenizer(data[i]);
        	arr[i] = new INFO(Integer.parseInt(st.nextToken()), st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        ArrayList<INFO>[] list = new ArrayList[size+1];
        
        for(int i = 0; i<=size; ++i) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<size; ++i) {
        	int u = arr[i].id;
        	int v = arr[i].pid;
        	if(v == 0) continue;
        	list[v].add(arr[v]);
        }
        
        for(int i = 1; i<=size; ++i) {
        	
        }
        
        return new String[] {"Your search for (" + word + ") didn't return any results"};
    }
    
    static void dfs(int idx) {
    	
    }
}










































class Solution5 {
    public boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = {};
        
        for(int i = 0; i<commands.length; ++i) {
        	String command = commands[i];
        	
        	
        }
        
        
        return answer;
    }
    
}
























