package com.choi.board.dataservice;

import org.springframework.beans.factory.annotation.Autowired;

import com.choi.board.common.Member;

public class MemberDAO implements IMemberDAO {
	@Autowired IMemberMapper memberDAO;
	@Override
	public Member 찾는다ById(String id) {
		return memberDAO.찾는다ById(id);
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
