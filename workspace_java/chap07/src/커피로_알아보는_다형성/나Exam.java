package 커피로_알아보는_다형성;

public class 나Exam {

	public static void main(String[] args) {

		나 my = new 나();
		Two T = new Two();
		Star star = new Star();
		커피프린스1호점 first = new 커피프린스1호점();
		
		my.isDT(T);
		my.isDT(star);
		my.isDT(first);

	}

}
