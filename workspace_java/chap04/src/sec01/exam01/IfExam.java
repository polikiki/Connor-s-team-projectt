package sec01.exam01;

import java.util.Scanner;

public class IfExam {

	public static void main(String[] args) {
		
		int score = 90;
		
//		if(score > 90)
		if(score >= 90)
		{ 
			System.out.println("90점 이상입니다");
			
			if(score >= 95 ) {
				System.out.println("95점 이상입니다");
			}
		}
			if(score < 90) {
			System.out.println("90점 미만입니다");
		}
		
		//참고로
			boolean up90 = score >= 90;
			if(up90) {
			
			System.out.println("up90");
		}
			if(!up90) {
			System.out.println("!up90");
		}
			
			if( up90 ) {
				System.out.println("참");
			} else {
				// 위의 조건이 하난도 만족하지 않는 경우 무조건 실행
				System.out.println("거짓");
			}
			
			if(score >= 90) {
				System.out.println("90점 이상입니다");
				System.out.println("학점은 A");
			}
			 //위의 결과가 상관없이 실행된다
			if (score < 90 && score >= 80 ) {
				System.out.println("90점 미만 90점 이상입니다");
				System.out.println("학점은 B");
			}
			
			if	( score < 90 && score >= 80);{
			}
			
			
			
			if(score >= 90) {
				System.out.println("학점은 A");
			}
			else if (score < 90 && score >= 80 ) {
				System.out.println("90점 미만 90점 이상입니다");
				System.out.println("학점은 B");
			}
			
			else {
				System.out.println("학점은 C");
		}
		
			// if, else if, else 이런식으로 묶여있으면 
			// 그 중 하나만 실행된다
			if(score >= 90) {
				System.out.println("학점은 A");
			}
			else if (score >= 80 ) {
				// 이거 위에 조건이 거짓일때만 여기로 온다
				System.out.println("90점 미만 90점 이상입니다");
				System.out.println("학점은 B");
			}
			
			else {
				System.out.println("학점은 C");
		}
			
			// 3은 짝수인가?
			int num = 4;
//			Scanner input = new Scanner(System.in);
//			num = input.nextInt();
			if(num % 2 == 1) {
				System.out.println("홀수");
			} else {
					System.out.println("짝수");
				}
			
			String a ="abc";
			String b ="abc";
//			if( a== b)
			if(a.equals(b)) {
				System.out.println("a와 b가 같다");
			} else {
				System.out.println("a와 b가 다르다");
			}
			
			double rand = Math.random();
			System.out.println("rand :"+ rand);
			// 0 이상 1미만
			
			// 주사위 : 1~6 까지
						
			int dice = (int)(rand *6)+1;
			System.out.println("주사위 숫자는 :"+ dice);
			
			if (dice == 6 ) {
				System.out.println("와 6이 나왔군요");
			}
			
			rand = Math.random();
			int rsp = (int)(rand * 3); // 0 ~ 2 
			if(rsp == 0) {
				System.out.println("가위");
			} else if(rsp == 1) {
				System.out.println("바위");
			}else {
				  System.out.println("보");
			  }
			
			int my = 1; //바위
			
			//이런 식으로 가지수를 늘리면 가능
			
			if ( rsp == 0 && my==0) {
				System.out.println("비김");
			} else if ( rsp == 0 && my==1) {
				System.out.println("내가 이김");
			} else if ( rsp == 0 && my==2) {
					System.out.println("내가 짐");
			  }
		
		// 스스로 고안한 가위바위보 알고리즘	
			int rock = (int)(rand*3);
			String game = "";
			if(rock == 2) {
			  game = "바위";
			} else if(rock == 1){
				  game = "가위";
				} else {
					game = "보";
				}
			
			
			int sic = (int)(Math.random()*3);
			String play = "";
			if(sic == 2) {
			  play = "바위";
			} else if(sic == 1){
				  play = "가위";
				} else {
					play = "보";
				}
			System.out.println(game);
			System.out.println(play);
			
			if (rock > sic) {
				System.out.println("왼쪽이 이겼습니다");
			} else if(rock == sic) {
				System.out.println("비겼습니다");
			} else {
				System.out.println("오른쪽이 이겼습니다");
			}
			
			double rand2 = Math.random();
			System.out.println("rand :"+ rand);
			// 0 이상 1미만
			
			// 주사위 : 1~6 까지
						
			int dice2 = (int)(rand2 *6)+1;
			System.out.println("주사위 숫자는 :"+ dice);
			
			if (dice2 == 1 ) {
				System.out.println("주사위 1이 나왔습니다");
			} else if(dice2 == 2) {
				System.out.println( "주사위 2이 나왔습니다");
			}
			
			// if중에서 == 또는 equals인 경우 switch로 바꿀 수 있다
			switch(dice2) {
				case 1 :
					System.out.println("주사위 1이 나왔습니다");
					break;
				case 2 :
					System.out.println("주사위 2이 나왔습니다");
					break;
				case 3 :
					System.out.println("주사위 3이 나왔습니다");
					break;
				case 4 :
					System.out.println("주사위 4이 나왔습니다");
					break;
				case 5 : // else if (dice2 == 5)
					System.out.println("주사위 5이 나왔습니다");
					break;
				default : // if의 else
					System.out.println("주사위 6이 나왔습니다");
					break;
			}
			
			int month = 3;
			
			if( month >= 3 && month <= 5) {
				System.out.println("봄");
			} else if (month >= 6 && month <= 8) {
				System.out.println("여름");
			} else if (month >= 9 && month <= 11) {
					System.out.println("가을");
//				} else if (month >= 12 && month <= 2) {
//				} else if (month == 12 || month >= 1 && month <=2) {
				} else {
					System.out.println("겨울");
				}
			
			switch(month){
			case 3 :
				System.out.println("봄");
				break;
			case 4 :
				System.out.println("봄");
				break;
			case 5 :
				System.out.println("봄");
				break;
			case 6 :
				System.out.println("여름");
				break;
			}
			switch(month){
			case 3 :
			case 4 :
			case 5 :
				System.out.println("봄2");
				break;
			case 6 :
			case 7 :
			case 8 :				
				System.out.println("여름2");
				break;
			case 9 :				
			case 10 :				
			case 11 :				
				System.out.println("가을2");
				break;
			default :
				System.out.println("겨울2");
				break;
			}
			
			// char, byte, short, int(즉, int이하), string만 허용됨
			// boolean, long, float, double은 못씀
			
						
	}
}
