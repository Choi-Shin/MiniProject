package com.choi.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choi.board.common.AuthUser;
import com.choi.board.common.Member;
import com.choi.board.dataservice.MemberDAO;

@Service
public class MemberService implements IMemberService {

	@Autowired
	MemberDAO dao;
	
	public Member 로그인하다(AuthUser 로그인회원) throws Exception {
		return dao.로그인하다(로그인회원);
	}
	
	public int 회원가입하다(Member member) {
		Member m = dao.찾는다ById(member.getId());
		if(m.getId() != null) {
			return 0;
		}
		return dao.회원가입하다(member);
	}
	
	public int 비밀번호변경하다(Member member) {
		return dao.비밀번호변경하다(member);
	}
	@Override
	public int 프로필사진변경하다(Member m) {
		return dao.프로필사진변경하다(m);
	}
	
	public Member 찾는다ById(String id) {
		return dao.찾는다ById(id);
	}

	public int 회원탈퇴하다(String id) {
		return dao.회원탈퇴하다(id);
	}
}
