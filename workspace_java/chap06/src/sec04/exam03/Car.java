package sec04.exam03;

public class Car {

	
	int gas = 5;
	// 필드 == 멤버 변수 
	// 클래스 생성(new하는 순간에)과 함께 생성되고
	// 클래스 소멸 시 까지 생존
	// 메모리를 차지함
	// 계속 저장된다. 
	// 메소드에서 변경하는 경우
	// 다음번 실행까지 저장해둠.
	// 그래서 계속 초기화 해야하는 상황이 있을 수 있다
	// 장점: 클래스 안의 모든 곳에서 사용 가능하다
	// = 필드는 아껴쓰자 필드에 올릴때는 공동으로 써야해 하는 변수만 쓰여야 한다
	// 안그러면 쓸때마다 초기값을 계속 줘야 한다( 지역변수를 적극사용하자)

	// gas의 값이 0이면 false
	// 그렇지 않으면 true
	boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("gas가 없습니다");
			return false;
		} else {
			System.out.println("gas가 있습니다");
			return true;
		}
	}
	
	// 위 식과 100% 동일하게 움직인다
//	boolean isLeftGas() { 
//		return gas !=0;
//	}
	
	// 주행
	// gas가 없을때까지 달리기
	void run() {
		while(true) {
			if(gas>0) {
				System.out.println("주행중...잔량:"+ gas);
				gas-=1;
			} else {
				System.out.println("주행종료...잔량:"+ gas);
				return;	 // break 대신 사용함
			}
			// 리턴타입이 void이므로
			// 아마값도 돌려주면 안된다
			// return을 만나면 그 즉시
			// 메소드 종료
			
		}
	}
	
	String name;
	
	// name의 값을 변경
	// name 갈아거 0인 경우 변경하지 않음
	// 전달인자 : String
	// 리턴타입 : 없음
	void setName(String nick) {
		System.out.println(nick.length());
		if(nick.length() != 0) {
			name = nick;
		} else {
			System.out.println("이름은 필수입니다");
		}
	}
}
