package com.choi.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.choi.board.common.AuthUser;
import com.choi.board.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	MemberService ms;
	
	@GetMapping(value = "/login")
	public String 로그인팝업창띄우다() {
		return "/member/로그인팝업";
	}
	@PostMapping(value = "/login")
	public ModelAndView 로그인시도하다(AuthUser 유저) {
		ModelAndView mv = new ModelAndView();
		AuthUser 로그인결과 = ms.login(유저);
		if(로그인결과 == null) {
		} else {
			mv.addObject("authUser", 로그인결과);
		}
		return mv;
	}

//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	public String registerPopup() {
//		return "/member/회원가입창";
//	}
}
