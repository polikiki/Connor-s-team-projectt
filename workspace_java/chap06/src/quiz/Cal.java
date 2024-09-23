package quiz;

public class Cal {
	/**
	 * 첫번째 숫자, 두번째 글씨, 세번째 숫자
	 * 메소드명(3, "+", 5)
	 * 알아서 두번째 글씨에 해당하는 연산 결과(1번에서 만든 메소드 사용)를 돌려줌
	 * @param int 첫번째 숫자, String 연산자, int 두번째 숫자
	 * @return double 결과
	 */
	
	double compute (int x, String op, int y) {
		double result = 0;
//		if(op.equals("+")) {
//			result = add(x,y);
//		}else if(op.equals("-")) {
//			result = minus(x,y);
//		}
		if (op != null) {
			if ("+".equals(op)) {
				result = add(x, y);
			} else if ("-".equals(op)) {
				result = minus(x, y);
			}
		}
		return result;
	}
	
	double add(double x, double y) {
		double result = x + y;
		System.out.println(result);
		return result;
	}
	
	double minus(double x, double y) {
		double result = x - y;
		System.out.println(result);
		return result;
	}
	
	double multifly (double x, double y) {
		double result = x * y;
		System.out.println(result);
		return result;
	}
	
	double divide (double x, double y) {
		double result = x / y;
		System.out.println(result);
		return result;
	}
	
	double remainder (double x, double y) {
		double result = x % y;
		System.out.println(result);
		return result;
	}
	
	double all (double x, String z,  double y) {
		switch(z){
		case "+":
			add(x,y);
			break;
		case "-":
			minus(x, y);
			break;
		case "*":
			multifly(x, y);
			break;
		case "/":
			divide(x, y);
			break;
		case "%":
			remainder(x, y);
			break;
		}return 0;
	}
	
}
