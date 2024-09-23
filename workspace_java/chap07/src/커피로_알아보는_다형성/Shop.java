package 커피로_알아보는_다형성;

public class Shop {

	// 기본적으로 false를 돌려주는 드라이브 스루 판별 메소드
	 boolean isDT() {
		return false;
	}
	
	// 음료를 주문받는 메소드
	 void order(String menu) {
		System.out.println(menu+"주문 받았습니다");
	}
}
