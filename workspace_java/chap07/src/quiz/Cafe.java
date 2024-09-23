package quiz;

public class Cafe {

	String name;
	
	// 따아 : 3000
	// 아아 : 3500
	// 라떼 : 4000
	
	void order(String coffee) {
		System.out.println("주문 :"+ coffee);
	}
	
	void pat(int money) {
		System.out.println("받은 돈 :"+ money);
		
		// 잔돈을 거슬러주면 좋겠다
		// 그러려면 커피 종류별 가격이 있어야 겠다
		
	}
}
