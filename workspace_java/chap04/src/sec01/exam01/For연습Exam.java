package sec01.exam01;

import java.util.Scanner;

public class For연습Exam {

	public static void main(String[] args) {

		/*
		 * 주사위 두개 굴림 1단계 주사위 2개로 굴려서 나올 수 있는 모든 조합 출력
		 * 
		 * 2단계 합 별로 나올 수 있는 조합 합이 2 : [1,1] 합이 3 : [1,2] [2,1]
		 */

		// 주어진 수가 양수(0포함), 음수 여부 출력

//		Scanner scan = new Scanner(System.in);
////		int a = -3;
//		System.out.println("숫자를 입력하세요");
//		int a = scan.nextInt();
//		if (a >= 0) {
//			System.out.println("주어진 수는 양수");
//		} else {
//			System.out.println("주어진 수는 음수");
//		}

//		for(int i=1; i<=3; i++) {
//			System.out.println("숫자를 입력하세요");
//			int a = scan.nextInt();
//			if (a >= 0) {
//				System.out.println("주어진 수는 양수");
//			} else {
//				System.out.println("주어진 수는 음수");
//			}
//	}

		// 입력받은 숫자가 0이 아닌 동안 계속 반복
//		for(int a=1; a !=0; ) {
//			System.out.println("숫자를 입력하세요");
//			a = scan.nextInt();
//			if (a >= 0) {
//				System.out.println("주어진 수는 양수");
//			} else {
//				System.out.println("주어진 수는 음수");
//			}
//		}
//		System.out.println("종료되었습니다");

//		for(int p=0 ; p <=4 ; p++) {  // 0단계
////			if(p>=0) {
//			System.out.println("+");
////			}
//		}

//		for(int p=0 ; p <=4 ; p++) {  // 1단계
////		if(p>=0) {
//			System.out.print("+");
////			}
//		}

//		for(int p=0 ; p <=2 ; p++) {  // 2단계
////			if(p>=0) {
//			System.out.println("+++++");
////			}
//		}

//		for(int j=1; j<=3; j++) {      // 2단계
//			for(int i=1; i<=5; i++) {
//				System.out.print("+");
//			} System.out.println();
//		}

//		for(int i=1; i<=5; i++) {     // 2-1단계
//			System.out.print("+");
//			System.out.print(" ");
//		}

//		for(int p=0 ; p <=4 ; p++) {  // 2-1단계
////			if(p>=0) {
//			System.out.print("+ ");
////			}
//		}

//		for(int p=1; p<=5 ; p++) {   // 3단계
//			for(int q=1; q<=p; q++) {
//			System.out.print("+");
//			} System.out.println("");
//		}

//		System.out.println("+");
//		System.out.println("++");

		// 첫번째 줄 1번줄
		// + 출력
		// 한번 출력 1번 출력
//		System.out.print("+");
//		System.out.println();
//		
		// 2번줄
		// +출력
		// 2번 출력

//		System.out.print("+");
//		System.out.print("+");
//		System.out.println();
//		

//		for(int i=1; i<=2;i++) {
//			System.out.print("+");
//		}
//		System.out.println();
//		int j = 2;
//		
//		j++;
//		
//		for(int i=1; i<=j; i++)

//		for (int p = 1; p <= 5; p++) {    // 4단계
//			for (int q = 1; q <= 5; q++) {
//				if (q <= p) {
//					System.out.print("+");
//				} else {
//					System.out.print(".");
//				}
//				
//			}System.out.println("");
//		}

//		for (int p = 1; p <= 5; p++) {    // 5단계
//			for (int q = 4; q >= 0; q--) {
//				if (q < p) {
//					System.out.print("+");
//				} else {
//					System.out.print(".");
//				}
//				
//			}System.out.println("");
//		}

//		for (int p = 1; p <= 5; p++) {    // 6단계
//			for (int q = 5-p; q > 0; q--) {
//				System.out.print(".");	
//			}
//			for(int q=1; q<=p*2-1; q++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}

//		for (int p = 1; p <= 5; p++) {    // 7단계
//			for (int q = 5-p; q > 0; q--) {
//				System.out.print(".");	
//			}
//			for(int q=1; q<=p*2-1; q++) {
//				System.out.print("*");
//			}
//			for(int q = 5-p; q >0; q--) {
//				System.out.print(".");
//			} System.out.println();
//		}

//		for (int dan = 2; dan <= 9; dan++) {  // 구구단 1번 문제
//			System.out.println(" ");
//			for (int k = 1; k <= 9; k++) {
//				System.out.print(dan + "*" + k + "=" + (dan * k)+" ");
//			}
//		}

//		for (int j = 2; j <= 9; j = j + 3) {
//			for (int dan = 1; dan <= 9; dan++) { // 구구단 2번 문제
//				int l = j + 3;
//				if (l >= 9) {
//					l = 9;
//				}
//				for (int k = j; k <= l; k++) {
//					System.out.print(k + "*" + dan + "=" + (dan * k) + " ");
//				}
//				System.out.println();
//			}
//		}
//		for (int i = 1; i <= 6; i++) {      // 주사위 1번 문제
//			for (int j = 1; j <= 6; j++) {
//				System.out.println("(" + i+","+ j + ")");
//			}
//		}
		
		for (int i = 1; i <= 6; i++) {      // 주사위 2번 문제
			for (int j = 1; j <= 6; j++) {
				System.out.println("(" + i+","+ j + ")");
			}
		}
	}
}
