package com.choi.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choi.board.common.AuthUser;
import com.choi.board.dataservice.MemberDAO;

@Service
public class MemberService {
	@Autowired
	MemberDAO dao;
	
//	public AuthUser login() {
//		
//	}
}
