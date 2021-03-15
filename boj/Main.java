// https://www.acmicpc.net/problem/
// 
// 
package boj;

public class Main {

	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		int x1 = -5;
		int y1 = 5;
		int width = (x - x1);	// int 붙여주면 뭔가 달라짐
		int height = (y - y1);
		double angle = ((180.0/Math.PI)*Math.atan2(width, height));
		System.out.println(angle);
		
		 width = (-x + x1);	// int 붙여주면 뭔가 달라짐
		 height = (-y + y1);
		 angle = ((180.0/Math.PI)*Math.atan2(width, height));
		System.out.println(angle);
	}
}