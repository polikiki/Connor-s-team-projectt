package sec01.exam04_super.food;

public class 제육 extends Food {

	제육() {
//		super();
		System.out.println("제육 생성자 실행");
		this.name ="제육";
		this.price = 8000;
		this.recipe = "돼지고기";
		this.type = "한식";
	}

	void setSpicy(String spicy) {
		this.name += " - "+spicy;
	}
	
	@Override
	int eat() {
		System.out.println("갓지은 밥을 상추와 마늘에 싸서");
//		System.out.println(this.name + "을(를) 맛있게 먹는다");
//		return (int)(Math.random()*5)+1; // 별점
		return super.eat();
	}
}
