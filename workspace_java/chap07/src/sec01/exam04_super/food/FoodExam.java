package sec01.exam04_super.food;

public class FoodExam {

	
	public static void main(String[] args) {
		
		제육 food1 = new 제육();
		food1.setSpicy("맛있게 매운맛");
		
		int change = food1.order("배달의민족", 10000);
		System.out.println("거스름돈"+ change +"받았다");
		
		int rank = food1.eat();
		System.out.println(food1.name +"의 별점은 :"+ rank);
		
//		회탕후루 food2 = new 회탕후루();
//		food2.order("요기요", 10000);
//		food2.order("요기요", 21000);
//		rank = food2.eat();
//		System.out.println(food2.name+"의 별점은 :"+ rank);
//		if(rank<3) {
//			food2.goGarbage();
//		}
	}

}
