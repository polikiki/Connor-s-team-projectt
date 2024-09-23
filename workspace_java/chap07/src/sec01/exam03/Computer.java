package sec01.exam03;

public class Computer extends Calc{

	@Override
	double areaCircle(double radius) {
		System.out.println("Computer의 areaCircle 실행");
		return Math.PI * radius *radius ;
	}
}
