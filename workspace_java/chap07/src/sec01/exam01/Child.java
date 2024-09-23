package sec01.exam01;

public class Child extends Parent {

	// 부모의 필드를 가리는 현상
	// overshadow
	String name = "Child의 name";
	
 // 기본생성자
	public Child(){
		// 부모 생성자를 호출하는 것
		// 맨 첫줄에 있어야만 한다
		super("");
	}
//	Child(){
//		super();
//		System.out.println("child 기본 생성자");
//	}
	
	// 부모의 name을 변경하는 메소드
	void setName(String name) {
		this.name = name;
	}
	
	void setName2(String n) {
		name = n;
	}
	
	// 전달인자가 필드를 가리는 현상
	// shadow (this를 쓰지 않으면 지역변수가 필드에 있는 변수를 덮어쓰는 현상)
	void setName3(String name) {
		this.name = name;
	}
	
	// 자식 클래스에서 필드 값이 있을때 부모의 필드값에 접근하는 방법이 있다 (super())
	void printName() {
		System.out.println("this.name :" + this.name);
		System.out.println("super.name :" + super.name);
	}
}
