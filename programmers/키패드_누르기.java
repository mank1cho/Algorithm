// https://programmers.co.kr/learn/courses/30/lessons/67256?language=java  키패드 누르기
// 구현

package programmers;

public class 키패드_누르기 {
	public static class KeyPad {
        int x, y;
        KeyPad(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int getDis(KeyPad p1, KeyPad p2){
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
    
    public String solution(int[] numbers, String hand) {
        KeyPad[] keyPad = new KeyPad[10];
        for(int i = 0; i<3; ++i){
            for(int j = 0; j<3; ++j){
                keyPad[i*3+j+1] = new KeyPad(i, j);
            }
        }
        keyPad[0] = new KeyPad(3, 1);
        KeyPad[] h = {new KeyPad(3,0), new KeyPad(3,2)};
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<numbers.length; ++i){
            int now = numbers[i];
            if(now % 3 == 1){
                sb.append("L");
                h[0] = keyPad[now];
            }
            else if (now!=0 && (now % 3 == 0)){
                sb.append("R");
                h[1] = keyPad[now];
            }
            else{
                int ld = getDis(h[0], keyPad[now]);
                int rd = getDis(h[1], keyPad[now]);
                if(ld < rd){
                    sb.append("L");
                    h[0] = keyPad[now];
                }
                else if(ld > rd){
                    sb.append("R");
                    h[1] = keyPad[now];
                }
                else{
                    if(hand.equals("right")){
                        sb.append("R");
                        h[1] = keyPad[now];
                    }
                    else{
                        sb.append("L");
                        h[0] = keyPad[now];
                    }
                }
            }
        }
        return sb.toString();
    }
}
