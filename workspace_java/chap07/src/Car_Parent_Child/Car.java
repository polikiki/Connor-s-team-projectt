package Car_Parent_Child;

public class Car {

	String name; // 자동차 이름(종류)
	String type; // 자동차 주유 타입
	int oil_volume; // 자동차 연료 용량
	int left; // 현재 연료의 량
	double exhaust_gas; // 차량별 배출가스 량
	Car() {
		System.out.println("Car 생성자 실행");
	}
	
	void drive(int length) { // 목적지 까지의 거리 변수 length 단위: km
		System.out.println("운전을 시작합니다");
		System.out.println("경로를 탐색합니다");
		int consume = (int)(Math.random()*25 +20);
		System.out.println("해당 경로까지의 예상 소비 연료량은"+consume+ "입니다");
		left -= consume;
		if(left < 0) {
			System.out.println("연료가 떨어졌습니다 더는 갈 수가 없습니다");
			left = 0;
		}else {
			System.out.println("목적지에 도착하였습니다");
			System.out.println(length+"km 만큼 운전하였고 사용한 총연료는"+ consume+"입니다");
		} get_Fuel();
	}
	
	int filling(int fuel) {
		System.out.println("주유구(연료투입구)를 연다");
		if(fuel > this.oil_volume) {
			System.out.println("용량을 넘어선 만큼 연료를 충전 할 수 없습니다");
		} else {
			System.out.println("연료를"+fuel+"만큼 충전하였습니다");
		} left += fuel;
		get_Fuel();
		return fuel;
	} 
	
	int get_Fuel() {
		System.out.println(this.name +"의 현재 남은 연료의 양은"+ left + "입니다");
		return left;
	}
	
	void get_Exhaust_gas () {
		System.out.println("이 차량의 배출가스 량은"+ exhaust_gas+" g/km 입니다");
	}
}
