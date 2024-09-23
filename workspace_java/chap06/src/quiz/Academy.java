package quiz;

//학원 클래스 만들기
//
//필드 
//
//학원생 Student 배열[10] 또는 ArrayList
//
//학원이름 : “천안” 또는 “수원”
//
//생성자
//
//학원이름 필수
//
//메소드
//
//join(학원생) : 필드에 등록
//
//viewList () : 등록된 학원생들의 이름과 나이 출력

import java.util.ArrayList;

public class Academy {

	String name; // 학원 이름
	int idx = 0;
	Student[] list1 = new Student[10];
	ArrayList list2 = new ArrayList();

	Academy(String Name) {
		this.name = name;
	}

	// join: 학원생을 필드에 등록
	// 전달인자 : Student
	// 리턴타입 : 없음

	void join(Student s) {
		
		// 배열의 길이를 넘지 않도록
		if (idx < this.list1.length) {
//		this.list1[idx] = s;
//		idx++;
			this.list1[idx++] = s;
		} else {
			System.out.println("만석입니다");
		}

		list2.add(s);
	}

	// viewList : 모든 학생들의 이름과 나이만 출력
	// 전달인자 : 없음
	// 리턴타입 : 없음
	void viewList() {
		// 배열 출력
		for (int i = 0; i < list1.length; i++) {
			Student s = list1[i];
			if (s != null) {
				System.out.println("이름 :" + s.name + ", 나이 : " + s.age);
			}
		}
		
		// ArrayList 출력
		for(int i=0; i<list2.size(); i++) {
			Student s = (Student)list2.get(i);
			System.out.println("이름 :" + s.name + ", 나이 : " + s.age);
		}
	}
	
	Student getStudent(int index) {
			return list1[index];
		}
}
