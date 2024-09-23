package sec04.exam04;

public class CalcExam {

	public static void main(String[] args) {
		Calc calc = new Calc();
		// 실행
		//()을 쓰는 이유는 전달인자가 없기때문이다 
		calc.execute();
		calc.println("abc");
		calc.avg(4,50);
		int a = 1;
		double b = a;
		calc.plus(1, 1.5);
	}

}
