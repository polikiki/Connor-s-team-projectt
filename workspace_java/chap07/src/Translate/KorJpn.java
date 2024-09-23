package Translate;

import java.util.ArrayList;

public class KorJpn extends Dict {

	ArrayList jp_words = new ArrayList();
	
	KorJpn(){
		jp_words.add("아이");
		jp_words.add("유조우");
		
		this.words = jp_words;
		
		super.words = this.words;
	}
	
	
}
