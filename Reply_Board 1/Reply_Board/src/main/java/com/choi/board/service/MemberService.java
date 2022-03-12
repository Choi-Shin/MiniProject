package com.choi.board.service;

import java.util.Random;

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

	public String 임시비밀번호생성하고db처리한다(String id) {
		Random random = new Random();
		StringBuffer b = new StringBuffer();
		int num = 0;
		while(b.length() < 6) {
			num = random.nextInt(10);
			b.append(num);
		}
		Member m = 찾는다ById(id);
		m.setPassword(b.toString());
		비밀번호변경하다(m);
		return b.toString();
	}

	@Override
	public int 이메일주소변경하다(Member m) {
		return dao.이메일주소변경하다(m);
	}

	@Override
	public String 중복아이디를확인하다(String id) {
		return dao.중복아이디를확인하다(id);
	}

	@Override
	public boolean 가입인증하다(String email, int authKey) {
		return dao.가입인증하다(email, authKey);
	}
}
