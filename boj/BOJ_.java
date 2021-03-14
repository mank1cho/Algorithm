// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.*;
import java.util.*;

public class BOJ_ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int gx = 254;
		int gy = 0;
		
		int whiteBall_x = 64;
		int whiteBall_y = 64;
		
		int tx = 198;
		int ty = 53;
		
		int subx = Math.abs(gx-tx);
		int suby = Math.abs(gx-tx);
		
		double dis = subx*subx + suby*suby;
		System.out.println(dis);
		
		double diameter = 5.73*5.73;
		double ratio = diameter/dis;
		
		double targetBall_x = tx - subx*ratio;
		double targetBall_y = ty + suby*ratio;
		
		double angle = 0;

		double width = Math.abs(targetBall_x - whiteBall_x);
		double height = Math.abs(targetBall_y - whiteBall_y);
		double radian = 0d;

		if (targetBall_x > whiteBall_x && targetBall_y >= whiteBall_y) { // 1사분면
		   radian = Math.atan(width / height);
		   angle = (float) ((180.0 / Math.PI) * radian);
		} else if (targetBall_x < whiteBall_x && targetBall_y >= whiteBall_y) { // 2사분면
		   radian = Math.atan(width / height);
		   angle = (float) (360 - ((180.0 / Math.PI) * radian) );
		} else if (targetBall_x > whiteBall_x && targetBall_y < whiteBall_y) { // 4사분면
		   radian = Math.atan(height / width);
		   angle = (float) (((180.0 / Math.PI) * radian) + 90);
		} else { // 3사분면
		   radian = Math.atan(height / width);
		   angle = (float) ( 270 - ((180.0 / Math.PI) * radian));
		}
		
		System.out.println(angle);
		System.out.println(Math.tan(Math.PI/4));
	}

}

