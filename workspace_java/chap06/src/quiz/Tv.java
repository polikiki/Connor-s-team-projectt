package quiz;

public class Tv {
	int a = 0;
	int b = 0;
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

	void 볼륨up() {
		if (a >= 0 && a<=10) {
			System.out.println("현재볼륨은"+a+"입니다");
			a++;
		} else if (a > 10) {
			a = 10;
			System.out.println("볼륨을 더이상 높일 수 없습니다");
		} else {
			System.out.println();
		}
	}

	void 볼륨down() {
		if (a > 0) {
			a--;
			System.out.println("현재볼륨은"+a+"입니다");
		} else if (a <= 0) {
			a = 0;
			System.out.println("볼륨을 더이상 낮출 수 없습니다");
		}
	}

	void 채널up() {
		b++;
		System.out.println("현재채널은"+b+"입니다");
	}

	void 채널down() {
		b--;
		System.out.println("현재채널은"+b+"입니다");
	}
	
	int 직접입력(int x) {
		b= b+x;
		System.out.println("현재채널은"+b+"입니다");
		return b;
	}
	
	void 정보보기() {
		System.out.println("전원상태:"+turn+"볼륨은"+a+"채널은"+b+"입니다" );
	}

}
