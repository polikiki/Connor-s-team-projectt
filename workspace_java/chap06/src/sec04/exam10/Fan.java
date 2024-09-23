package sec04.exam10;

public class Fan {

	boolean turn = false;

	boolean turnOn() {
		System.out.println("전원을 킵니다");
		turn = true;
		return turn;
	}

	boolean turnOff() {
		System.out.println("전원을 끕니다");
		turn = false;
		return turn;
	}

	void 약풍() {
		if (turn == true) {
			System.out.println("약풍으로 변경되었습니다");
		} else {
			System.out.println("전원을 켜주시길 바랍니다");
		}
	}

	void 강풍() {
		if (turn == true) {
			System.out.println("강풍으로 변경되었습니다");
		} else {
			System.out.println("전원을 켜주시길 바랍니다");
		}
	}
}
