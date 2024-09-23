package sec02.exam01;

public class AnimalExam {

	public static void main(String[] args) {
		 
		Dog dog = new Dog();
		Cat cat = new Cat();
		
//		dog = cat
		
		Animal a1 = (Animal) new Dog(); // Dog에서 온 Animal 이라는 뜻이라 sound 메소드 밖에 쓸 수 없음
										// Animal 클래스 에서는 sound 메소드 밖에 없기 때문에(override된 sound 메소드때문에 출력이 바뀌었음)
										// 만약 override가 되지 않았다면 Animal 클래스의 sound 메서드가 실행될 것
		Animal a2 = new Cat();
		
		// 같은 타입이니까 당연히 가능
//		a1 = a2;
		
		a1.sound();
//		a1.walk();

	}

}
