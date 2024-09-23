package Car_Parent_Child;

public class 버스 extends Car {

	버스() {
		System.out.println("버스 생성자 실행");
		this.name = "버스";
		this.type = "경유";
		this.oil_volume = 300;
		this.left = 250;
		this.exhaust_gas = 876.41;
	}
	
	@Override
	void drive(int length) { // 목적지 까지의 거리 변수 length 단위: km
		System.out.println("운전을 시작합니다");
		System.out.println("경로를 탐색합니다");
		int consume = (int)(Math.random()*100 +length);
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
}
