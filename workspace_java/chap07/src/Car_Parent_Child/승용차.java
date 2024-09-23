package Car_Parent_Child;

public class 승용차 extends Car {
	
	승용차() {
		System.out.println("승용차 생성자 실행");
		this.name = "승용차";
		this.type = "휘발유";
		this.oil_volume = 60;
		this.left = 40;
		this.exhaust_gas = 140; 
	}
}
