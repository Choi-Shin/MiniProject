package com.choi.board.dataservice;

import com.choi.board.common.AuthUser;
import com.choi.board.common.Member;

public interface IMemberDAO {
	Member 찾는다ById(String id);
	Member 로그인하다(String id, String password);
	int 회원가입하다(Member member);
	int 비밀번호변경하다(Member member);
	int 회원탈퇴하다(String id);
}