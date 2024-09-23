package sec05.exam02_static;

public class Calc {
	
//	static double pi = 3.141592;
	static double pi;
	
	static {
		pi = 3.141592;
		System.out.println(123); // 실행블럭을 만드는 방법 (부팅과 동시에 실행이 되는)
	}
	String color;
	
	Calc(){
		System.out.println(pi); // 생성자는 후발대고 pi는 가장 먼저 만들어지니까
	}
	
	// static 에서는
	// static 밖에 못쓴다
	// this 못쓴다 (this는 new가 된 이후에나 사용가능한데 static는 new가 되지 않아도 사용할 수 있어야 하기 때문에)
	static void test() {
		System.out.println(pi);
//		this.color = "흰색"
//		color = "흰색"; // this는 new가 된 나를 뜻하기 때문에 static에서는 쓸 수 없다
//		test2();
	}
	
	// static이 아닌것은
	// static을 마음대로 사용할 수 있다
	void test2() {
		test();
	}
}
