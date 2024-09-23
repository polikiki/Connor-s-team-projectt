package sec01.exam01;

public class StudentExam {

	int a = 10; // 공통으로 쓸때 이렇게 쓴다 
	
	public static void main(String[] args) {
		
	Student s1 = new Student(); // 새로운 Student 객체를 생성해서 s1에 담기
	
	Student s2 = new Student();
	
	Student s3 = null; // 변수만 만들고 연결은 없음
	
	s3 = s1;
	System.out.println(s3 == s1);
	System.out.println(s1 == s2); //내용물은 관계없이 같은 주소를 공유하고 있느냐만 확인
	
	s2 = null;
	
	}

}
