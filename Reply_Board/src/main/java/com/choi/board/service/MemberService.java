package com.choi.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choi.board.common.AuthUser;
import com.choi.board.common.Member;
import com.choi.board.dataservice.IMemberDAO;
import com.choi.board.dataservice.MemberDAO;

@Service
public class MemberService {

	@Autowired
	IMemberDAO memberDAO;

	public Member 로그인하다(String id, String password) {
		return memberDAO.로그인하다(id, password);
	}

	public int 회원가입하다(Member member) {
		Member m = memberDAO.찾는다ById(member.getId());
		if (m.getId() != null) {
			return 0;
		}
		return memberDAO.회원가입하다(member);
	}

	public int 비밀번호변경하다(Member member) {
		return memberDAO.비밀번호변경하다(member);
	}

	public Member 찾는다ById(String id) {
		return memberDAO.찾는다ById(id);
	}

	public int 회원탈퇴하다(String id) {
		return memberDAO.회원탈퇴하다(id);
	}
}
