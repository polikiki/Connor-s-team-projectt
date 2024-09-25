package kr.or.human.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


// 보통 DAO 클래스에서 사용
//@Repository
@Repository
@Primary
public class MemberDAOImpl2 implements MemberDAO {

	@Override
	public List selectMember() {
		
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		
		return list;
	}
	
}
