package quiz;

public class CharacterExam {

	public static void main(String[] args) {

		Character hong = new Character("홍길동");
		Character lee = new Character("이순신장군님");

//		lee.hit(hong.attack());

//		int dam = hong.attack();
//		boolean isAlive = lee.hit(dam);

//		boolean isAlive = lee.hit(hong.attack());
//		if(isAlive) {
//			lee.hit(hong.attack());

//			hong.hit(lee.attack());
//			lee.hit(hong.attack());
//			lee.heal();

		boolean isAlive_hong = true, isAlive_lee = true;

		while (isAlive_hong && isAlive_lee) {
			isAlive_hong = hong.hit(lee.attack());
			if (isAlive_hong) {
				isAlive_lee = lee.hit(hong.attack());
			}
		}
	}
}
