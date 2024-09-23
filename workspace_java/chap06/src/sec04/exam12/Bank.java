package sec04.exam12;

import java.util.Scanner;

public class Bank {
	String bankName;
	long money = 0;
	boolean isDebug = false; // false 조건과 true조건을 줬을때 
							  // 출력을 보이게 하는냐 안보이게 하느냐는 아이디어
	
	Bank(String bankName){
		this.bankName = bankName;
	}
	/*
	 * 입금 : 단 음수 입력 막기
	 * 출금 : 단 음수, 잔액보다 큰 수 출금 막기
	 * 확인 : 잔액 출력
	 */
	
	// 입금
	// 기존의 잔액에
	// 입금액을 더하기 한다
	// 전달인자가 음수인 경우 더하지 않는다
	// 전달인자 : int 입금액
	// 리턴타입 : 없음
	/**
	 * @param int 입금액
	 * @return void
	 */
	void income(long money) {
		System.out.println("받은돈 :"+money);
		if(money>0) {
		this.money = money;
		}
	}
	
	/**
	 * 출금 : 단 음수, 잔액보다 큰 수 출금 막기
	 * 기존의 잔액에
	 * 출금액을 빼서 저장한다
	 * 단, 전달인자가 음수 또는 잔액보다 큰 경우 제외한다
	 * 
	 * @param int 출금액
	 * @return void
	 */
	
	void outcome(long money) {
		System.out.println("출금 : 받은돈 :"+money);
		if(money> 0) {
			if(this.money>=money) {	
				this.money -= money;
			}
		}
	}
	
	/**
	 * 확인 : 잔액 출력
	 * @param 없음
	 * @return int 잔액
	 */
	long view() {
		System.out.println("현재잔액 : "+this.money);
		return this.money;
	}
	
//	long a = 0;
//	
//	long insert () {
//		Scanner scan = new Scanner(System.in);
//		long b = scan.nextLong();
//		System.out.println("입금할 금액을 입금해 주세요");
//		if(b>0) {
//			a = b;
//			return a;
//		}else {
//			System.out.println("양수를 입력해 주십쇼");
//			return 0;
//		} 
//	}
//	
//	long withDraw () {
//		Scanner scan = new Scanner(System.in);
//		long b = scan.nextLong();
//		if(b>=0 && a>b) {
//		 a = a - b;
//			return a;
//		}else if(b<0) {
//			System.out.println("양수를 입력해 주십쇼");
//			return 0;
//		}else if (a<b) {
//			System.out.println("잔액이 부족합니다");
//			return 0;
//		} return 0;
//	}
//	
//	long balance () {
//		System.out.println(a);
//		return a ;
//	}
}
