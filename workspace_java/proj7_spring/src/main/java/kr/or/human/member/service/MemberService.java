package kr.or.human.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.human.member.dao.MemberDAO;


public interface MemberService {
	
	// 필드는 자동으로 static final이 붙는다
	static final int a = 0;
	
//	public abstract List listMember();
//	public List listMember();
	List listMember();
	
	public void setMemberDAO(MemberDAO memberDAO);
	
//	defalut void test() {
//		
//	}
}
