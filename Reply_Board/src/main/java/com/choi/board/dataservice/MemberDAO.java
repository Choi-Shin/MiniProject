package com.choi.board.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choi.board.common.AuthUser;
import com.choi.board.common.Member;

@Repository
public class MemberDAO implements IMemberDAO {
	@Autowired IMemberMapper memberDAO;
	@Override
	public Member 찾는다ById(String id) {
		return memberDAO.찾는다byId(id);
	}
	
	@Override
	public Member 로그인하다(String id, String password) {
		return memberDAO.로그인하다(id, password);
	}

	@Override
	public int 회원가입하다(Member member) {
		return memberDAO.회원가입하다(member);
	}

	@Override
	public int 비밀번호변경하다(Member member) {
		return memberDAO.비밀번호변경하다(member);
	}

	@Override
	public int 회원탈퇴하다(String id) {
		return memberDAO.회원탈퇴하다(id);
	}

}
