package 커피로_알아보는_다형성;

public class 나 {

	Shop shop = new Shop();
	
	void isDT(Shop d) {
		if(d.isDT()) {
			System.out.println("드라이브쓰루를 이용한다");
			shop.order("따아");
		}else {
			System.out.println("걸어가서 사먹으세요");
		}
	}
}
