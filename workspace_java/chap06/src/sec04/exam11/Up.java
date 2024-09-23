package sec04.exam11;

import java.util.Scanner;

public class Up {
	// int number = (int)(Math.random() *100) %10; //선생님 풀이
	int a = 0;
	int c = 0;
	
	// number의 숫자를 지정하는 기능
//	void setNumber(int num) {
//		number = num;
//	}
	
	// 임의의 수로 교체
//	void initNumber() {
//		number = (int)(Math.random()*100) %10;
//	}
	
	// up down 정답을 판단하는 기능
	// 전달인자 : int(추측한 숫자)
	// 리턴타입 : 없음
//void answer(int num) {
//	if (number == num) {
//		System.out.println("정답입니다");
//	} else if (number > num) {
//		System.out.println("UP");
//	} else if (number < num) {
//		System.out.println("DOWN");
//	}
//}
//	void hint() {
//		System.out.println("number :"+number));
//	}
	double num() {
		int b = ((int) (Math.random() * 10000)) % 10;
		System.out.println(b);
		a = b;
		return b;
	}

	void 사회자양반여기정답() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int b = scan.nextInt();
			c++;
			if (a < b) {
				System.out.println("Down(시도회수:"+c+")");
			} else if (a == b) {
				System.out.println("정답입니다(시도회수:"+c+")");
				return;
			} else {
				System.out.println("UP(시도회수:"+c+")");
			}
		}
	}
}
