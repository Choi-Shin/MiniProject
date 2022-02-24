package com.choi.board.service;

import com.choi.board.common.AuthUser;
import com.choi.board.common.Member;

public interface IMemberService {
	Member 로그인하다(AuthUser user) throws Exception;
	int 회원가입하다(Member m);
	int 비밀번호변경하다(Member m);
	int 프로필사진변경하다(Member m);
	Member 찾는다ById(String id);
	int 회원탈퇴하다(String id);
}
