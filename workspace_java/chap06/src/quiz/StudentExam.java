package quiz;

public class StudentExam {

	public static void main(String[] args) {
		
	Student s1 = new Student("박말순");
	System.out.println(s1.name);
	System.out.println(s1.age);
	System.out.println(s1.hasGlasses);
	
	s1.name = "최민수";
	s1.age = 20;
	s1.hasGlasses = true;
	
	System.out.println(s1.name);
	System.out.println(s1.age);
	System.out.println(s1.hasGlasses);
	
	// s1.name과 내 지역변수 name은 아무 관계없음
	String name = "아무거나";
	System.out.println(s1.name);
	
	// 지역변수는 초기화 없이 사용 불가능
	// 필드는 초기화 없는 경우 0, null,false로
	// new 하는 순간 자동 초기화 됨
	
//	int a;
//	System.out.println(a); //지역변수가 초기화가 되어 있지 않다(에러)					  
	
	Student s2 = new Student("박춘식",23);
	System.out.println(s2.name);
	
	s2.name = "박춘보";
	s2.age = 50;
	
	System.out.println(s2.name);
	System.out.println(s2.age);
	
	System.out.println(s1.name);
	
	System.out.println(s1);
	int intel = s1.study("java 클래스");
	System.out.println("공부했더니 지식:"+ intel);
	System.out.println(s1);
	
	int eat = s1.eat("제육볶음");
	System.out.println("밥을 먹었더니 공복감이"+eat+"가 되었다");
	System.out.println(s1);
	
	int game = s1.game("젤다의 전설", 4);
	System.out.println("현재스트레스는"+game);
	
	s1.game("메이플 스토리", 30);
	
	System.out.println(s1);
	
	int h = s1.study(3,"동물의 숲");
	System.out.println(s1);
	
	System.out.println(s1);
	System.out.println(s1.toString());
	
		view(s1);
	}
	
	static void view(Student s) {
		String str = s.toString();
		int stress = s.game("오버워치",4);
		System.out.println("이 학생의 스트레스 수치는 : "+ stress);
	}

}
