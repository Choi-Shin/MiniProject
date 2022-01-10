package com.choi.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choi.board.common.AuthUser;
import com.choi.board.common.Member;
import com.choi.board.dataservice.MemberDAO;

@Service
public class MemberService {

	@Autowired
	MemberDAO dao;

	public boolean 로그인하다(AuthUser 로그인회원) {
		Member DB회원 = dao.찾는다ById(로그인회원.getId());
		if(DB회원.getId() != null) {
			if (DB회원.matchPassword(로그인회원.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public int 회원가입하다(Member member) {
		Member m = dao.찾는다ById(member.getId());
		if(m.getId() != null) {
			return 0;
		}
		return dao.회원가입하다(member);
	}
}
