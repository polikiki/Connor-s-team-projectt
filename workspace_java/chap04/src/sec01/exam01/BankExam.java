package sec01.exam01;

import java.util.Scanner;

public class BankExam {

	public static void main(String[] args) {
		
		// 은행 계좌의 잔고 관리 시스템
		// 1. 입금, 2.출금, 3.조회, 4.종료
		// 입금: 잔액에 더하기
		//			* 0, 음수는 실행되지 않게 - 금액을 확인하세요 
		// 출금: 잔액에서 빼기
		//			* 잔액보다 큰 금액은 실행되지 않게 - 잔고가 부족합니다
		// 조회: 잔액 출력
		// 종료: 반복 종료
		
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		int balnce =0 ;
		while (run) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2. 출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.println("선택> ");
			
			int menu = scan.nextInt();
			
				if( menu == 1 ) {
					System.out.println("입금액>");
					long insert = scan.nextLong();
					if(insert<=0) {
						System.out.println("금액을 확인하세요");
						continue;
					}
					balnce += insert;
				} else if(menu == 2) {
					System.out.println("출금액>");
					long draw = scan.nextLong();
					if(draw > balnce) {
						System.out.println("잔고가 부족합니다");
						continue;
					}
					balnce -= draw;
				} else if(menu == 3) {
					System.out.println("조회>");
					System.out.println(balnce);
				} else if(menu == 4) {
					System.out.println("프로그램 종료");
					break;
				}
				
				else {
				System.out.println("메뉴를 다시 선택해주세요");
			}
		}
		
}
}