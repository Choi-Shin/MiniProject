package com.choi.board.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.choi.board.common.AuthUser;
import com.choi.board.common.Member;
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
	public ModelAndView 로그인시도하다(AuthUser user) {
		ModelAndView mv = new ModelAndView();
		System.out.println(user.getId());
		boolean 로그인결과 = ms.로그인하다(user);
		if (로그인결과 == false) {
			mv.addObject("fail", "아이디나 비밀번호가 틀립니다.");
			mv.setViewName("/member/로그인결과");
			return mv;
		} else if (로그인결과 == true) {
			String welcome = "환영합니다. " + user.getId() + "님";
			mv.addObject("success", welcome);
			mv.addObject("loginUser", user);
			mv.setViewName("/member/로그인결과");
		}
		return mv;
	}

	@GetMapping(value = "/register")
	public String registerPopup() {
		return "/member/회원가입창";
	}
	
	@PostMapping(value = "/register")
	public ModelAndView 회원가입하다(Member member) {
		ModelAndView mv = new ModelAndView();
		int result = ms.회원가입하다(member);
		mv.setViewName("/member/회원가입결과");
		if(result == -1) {
			mv.addObject("fail", "가입에 실패하였습니다.");
		} else if(result == 0) {
			mv.addObject("fail", "이미 존재하는 아이디입니다.");
		}	else if (result > 0){
			mv.addObject("success", "가입되었습니다.");
		}
		return mv;
	}
}
