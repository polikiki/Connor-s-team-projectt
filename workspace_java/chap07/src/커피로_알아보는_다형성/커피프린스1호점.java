package 커피로_알아보는_다형성;

public class 커피프린스1호점 extends Shop {
	// 해당 클래스에 드라이브 스루가 있다면 true를
		// 없다면 false를 반환한다
		@Override
		boolean isDT() {
			System.out.println("점장이 혼란에 빠졌습니다");
			return false;
		}
}
