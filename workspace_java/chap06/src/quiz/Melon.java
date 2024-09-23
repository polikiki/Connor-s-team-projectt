package quiz;

public class Melon {

	// 제목, 가수명, 장르, 가사, 곡 길이
	
	String title = "";
	String name = "";
	String type = "";
	String lyrics = "";
	int length = 0;
	
//	Private String title = "";
//	Private String name = "";
//	Private String type = "";
//	Private String lyrics = "";
//	Private int length = 0;
	
	// title getter
	// get + 필드명(대문자로 시작)
	// 전달인자 : 없음
	// 리턴타입 : 필드의 타입
	String getTitle() {
		return this.title;
	}
	
	// title setter
	// set+ 필드명(대문자로 시작)
	// 전달인자 : 필드의 타입
	// 리턴타입 : 없음
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	String title_Db (String t) {
		title = t;
		return title;
	}
	
	String name_Db (String n) {
		name = n;
		return name;
	}
	
	String type_Db (String ty) {
		type = ty;
		return type;
	}
	
	String lyrics_Db (String l) {
		lyrics = l;
		return lyrics;
	}
	
	int length_Db (int le) {
		length = le;
		return length;
	}
		
	void all () {
		System.out.println(title+","+name+","+type+","+lyrics+","+length);
	}
}
