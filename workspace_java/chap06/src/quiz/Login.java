package quiz;

public class Login {
	
	String id;
	String pw;
//	boolean check = false;
	
	
	public Login(String i, String p) {
		id = i;
		pw = p;
	}
	
	boolean login(String i, String p) {
		if(id==i && pw == p) {
			System.out.println("메인페이지");
//			check = true;
			return true;
		}else {
			System.out.println("로그인 화면으로 돌아감");
//			check = false;
			return false;
		}
	}
}
