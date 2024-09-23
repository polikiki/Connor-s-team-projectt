package sec05.exam01_this;

public class Car {

	String model;
	int speed;
	Car() {};
	
//	Car(String m){
//		model = m; 
//	}
	Car(String model){
//		model = model;
		
		int a = 10;
		a = a;
		
		Car c1 = new Car();
		c1.model = model;
		
		this.model = model; // 필드에 접근하기 위해서 this.을 쓴다
	}
	
	void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
