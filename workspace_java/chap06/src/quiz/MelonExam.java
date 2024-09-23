package quiz;

public class MelonExam {

	public static void main(String[] args) {
		
		Melon s1 = new Melon();
		s1.setTitle("슈퍼노바");
		s1.setName("에스파");
		s1.setType("k-pop");
		s1.setLyrics("슈퍼노바");
		s1.setLength(193);
		
		
		Melon melon = new Melon();
		Melon melon1 = new Melon();
		Melon melon2 = new Melon();
		
		melon.title_Db("서른즈음에");
		melon1.title_Db("천상연");
		melon2.title_Db("질풍가도");
		
		melon.name_Db("김광석");
		melon1.name_Db("이창섭");
		melon2.name_Db("유정석");
		
		melon.type_Db("발라드");
		melon1.type_Db("발라드");
		melon2.type_Db("OST");
		
		melon.lyrics_Db("또 하루 멀어져 간다");
		melon1.lyrics_Db("아니길 바랬었어");
		melon2.lyrics_Db("한번 더 나에게 질풍같은 용기를");
		
		
		melon.length_Db(287);
		melon1.length_Db(271);
		melon2.length_Db(192);
		
		melon.all();
		melon1.all();
		melon2.all();
	}

}
