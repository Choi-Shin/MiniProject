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
	String 임시비밀번호생성하고db처리한다(String id);
	int 이메일주소변경하다(Member m);
	String 중복아이디를확인하다(String id);
	boolean 가입인증하다(String email, int authKey);
}
