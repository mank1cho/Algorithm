//https://www.acmicpc.net/problem/2557  Hello World!
package boj;

public class BOJ_2557 {
	public static void main(String args[]) throws Exception {
		//1
		System.out.println("Hello World!");
		
		/*
		2.
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("Hello World!");
		bw.flush();
		
		3.
		StringBuilder sb = new StringBuilder();
		sb.append("Hello World!");
		System.out.print(sb);
		
		4.
		StringBuffer sb = new StringBuffer();
		sb.append("Hello World!");
		System.out.print(sb);
		
		----
		String str1 = "string";
		String str2 = "string";
		String str3 = new String(string);
		String str4 = new String(string);
		str1과 str2는 같은 주소값을 가짐.
		str3과 str4는 새로운 객체를 생성한 것이므로 다른 주소값을 가짐.
		하지만 모든 문자열의 hashcode는 동일함.
		hashCode : 객체를 저장하는 hash table에서 각 객체에 대응되는 고유한 정수값.
		String 클래스는 내부적으로 hashCode 메서드를 재정의하여 같은 hashCode를 갖도록 설정되어있다.

		== 연산자는 같은 주소인지를 판별함
		equals는 같은 내용인지를 판별함.
		
		equals(Object)메소드가 true이면 두 객체의 hashCode 값은 같아야 한다.
		equals(Object)메소드가 false이면 두 객체의 hashCode가 꼭 다를 필요는 없다. (즉 내용이 달라도 hash code가 같을 수 있다.)
		하지만 서로 다른 hashCode 값이 나오면 해시 테이블(hash table)의 성능이 향상될 수 있다는 점은 이해하고 있어야 한다.
		
		참고
		https://gbsb.tistory.com/255
		https://blog.naver.com/travelmaps/220930144030
				
		----		
		일반 String과 StringBuilder, StringBuffer의 차이점 : String은 새로운 값을 할당할 때마다 새로 생성됨.
		+연산자로 문자열을 이어붙일때마다 새로운 String이 생성되므로 메모리 관리 측면에서 적절하지 않음. java에서 대표적인 immutable한 객체임.
		
		StringBuilder와 StringBuffer는 mutable한 객체이다. 문자열을 이어붙일 수 있다.
		???*JDK 1.5 버전 이후에는 String 객체를 사용하더라도 컴파일 단계에서 StringBuilder로 컴파일하도록 변경되었다.???
		
		StringBuilder 와 StringBuffer의 가장 큰 차이점 : Thread-safe.
		StringBuilder는 Thread-safe하지 않다.
		StringBuffer는 Thread-safe하다.
		
		참고 https://novemberde.github.io/2017/04/15/String_0.html
		*/
	}
}
