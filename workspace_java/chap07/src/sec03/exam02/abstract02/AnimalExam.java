package sec03.exam02.abstract02;

public class AnimalExam {

	public static void main(String[] args) {
		
		Dog dog = new Dog();
		dog.sound();
		dog.breathe();
		
		Animal a = dog;
		a.sound();
		
		// abstract class는 new가 될수 없다
		// 왜냐하면 추상 메소드를 가질 수 있기 때문이다
//		Animal a2 = new Animal();
	}
}
