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

	public AuthUser login(AuthUser 로그인회원) {
		Member DB회원 = dao.찾는다ById(로그인회원.getId());
		if (DB회원.matchPassword(로그인회원.getPassword())) {
			return 로그인회원;
		}
		return null;
	}
}
