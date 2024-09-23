package quiz;

public class LoginExam {

	public static void main(String[] args) {
		
		Login login = new Login("대한민국", "14344");
		
		boolean a = login.login("대한미국","14344");
		System.out.println(a);
//		System.out.println(login.check);
		
		boolean c = login.login("대한민국","14344");
		System.out.println(c);
	}

}
