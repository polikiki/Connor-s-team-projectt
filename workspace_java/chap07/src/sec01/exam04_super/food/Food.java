package sec01.exam04_super.food;

public class Food {
	
	String name;
	int price;
	String recipe;
	String type;
	
	Food() {
		System.out.println("Food 생성자 실행");
	}
	
	int eat() {
		System.out.println(this.name + "을(를) 맛있게 먹는다");
		return (int)(Math.random()*5)+1; // 별점
	}
	
	int order(String method, int money) {
		int change = 0;
		if(money < this.price) {
			System.out.println("금액 부족으로 취소합니다");
		} else {
			System.out.println(method+"와 같은 방법으로"+this.price+" 어치 주문했다");
			change = money - this.price;
		}
		
		return change;
	}
	/**
	 * 
	 * @param int master 요리 숙련도
	 * @return String 조리 결과
	 */
	String cook(int master) {
		if(master>7) {
			return "기가막히게 잘됨";
		}else if(master >4) {
			return "먹을만하게 됨";
		} else {
			return "나 혼자  먹자";
		}
	}
	
	/*
	 * 이름 name
	 * 가격 price
	 * 주재료 recipe
	 * 종류 type
	 */
	
	/*
	 * 먹는다eat()
	 * 주문한다 order()
	 * 요리한다 cook()
	 */
}
