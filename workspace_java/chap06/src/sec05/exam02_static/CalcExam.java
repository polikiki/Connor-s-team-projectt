package sec05.exam02_static;

public class CalcExam {

	// 자바가 즉 java.exe가 특정 클래스를 실행할때
	// 예를 들어 CalcExam 클래스를 실행할때
	// CalcExam.main(스트링배열)을 실행한다
	// new CalcExam() 하지 않는다
	public static void main(String[] args) {
		
	Calc calc1 =new Calc();
	Calc calc2 =new Calc();
	
	calc1.color = "빨강";
	calc2.color = "파랑";
	
	// 지역변수 : 해당 블럭에서만 사용 가능, 블럭이 끝나면 사라짐
	// 필드변수 : new가 된 순간(인스턴스)부터 사용 가능
	//            클래스 소멸 시 사라짐
	// static 변수 == 클래스변수 == 공용변수
	//			java 실행 시 사용 가능
	//			java 종료 시 사라짐

	System.out.println(calc1.pi);
	
	System.out.println(Calc.pi);
	
	calc1.pi = 3;
	System.out.println(calc1.pi);
	System.out.println(calc2.pi);
	}
	
}
