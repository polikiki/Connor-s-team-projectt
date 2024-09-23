package Translate;

public class Dictionary {
	
	String[] word = {"사랑","우정"};
	
	String[] word_Eng = {"LOVE", "FRIENDSHIP"};
	
	String[] word_Jpn = {"아이싯떼루", "아이조쿠"};
	
	void search(String word) {
		for(int i=0;i< word_Eng.length;i++) {
			if(this.word[i] == word) {
				System.out.println(this.word_Eng[i]);
				System.out.println(this.word_Jpn[i]);
				break;
			}else if(this.word_Eng[i] == word) {
				System.out.println(this.word[i]);
				System.out.println(this.word_Jpn[i]);
				break;
			}else if(this.word_Jpn[i] == word) {
				System.out.println(this.word[i]);
				System.out.println(this.word_Eng[i]);
				break;
			} else {
				System.out.println("찾을수 없는 단어 입니다");
				break;
			}
		}
	}
}
