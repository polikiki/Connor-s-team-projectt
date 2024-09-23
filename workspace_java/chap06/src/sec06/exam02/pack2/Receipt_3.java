package sec06.exam02.pack2;

public class Receipt_3 {
	// 생성자 없을때 pack1에서 new 가능했음
	
//	Receipt_3() {
//		// defalt 접근 제한자라고 읽는
//		// 아무런 접근 제한자를 적지 않은 경우
//		// 다른 패키지에서는 접근이 불가능함
//		// not visible이라는 오류 발생
//	}
	
	// 기본 생성자
//	public Receipt_3() {
		// public 접근 제한자는 다른 패키지에서 접근 가능
//	}
	
	void test() {
		donation();
	}
	
	//private 접근 제한자는
	// 내 클래스 외에는 못쓰게 막아준다
	private void donation() {
		
	}
}
