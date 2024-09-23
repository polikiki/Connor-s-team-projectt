package sec04.exam04;

public class Calc {
	
	// 정확히 int, int를 보내면 
	// 자료형이 동일한 것 우선 찾아서 실행
	// 만약에 없으면 자동형변환해서 들어갈 수 있는 
	// 메소드 찾아서 실행
	int plus(int x, int y) {
		System.out.println("int int");
		int result = x + y;
		return result;
	}
	
	double plus(double x, double y) {
		System.out.println("double double");
		double result = x + y;
		return result;
	}
	
	double avg(int x, int y) {
		double sum = plus(x,y);
		double result = sum / 2;
		return result;
	}
	
	void execute() {
		double result = avg(7,10);
		System.out.println("실행결과:"+ result);
	}
	
	void println(String message) {
		System.out.println(message);
	}
	
	/*
	 * 오버로딩
	 * 1. System.out.println처럼 전달인자를 신경쓰지 않게 하기 위함
	 * 2. 전달인자가 너무 많고 기본값을 입력하는 경우가 빈번할때
	 *    전달인자를 줄이는 목적으로도 사용함
	 */
	
	void join( String id, String pw, String address, int age, int gender) {
		System.out.println("아이디:"+id);
		System.out.println("비밀번호:"+pw);
		System.out.println("주소:"+ address);
		System.out.println("나이:"+ age);
		System.out.println("성별:"+ gender);
	}

	void join(String id, String pw) {
		join(id, pw, null,-1,-1);
	}
}
