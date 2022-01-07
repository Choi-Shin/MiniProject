package com.choi.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPopup() {
		return "로그인팝업";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login() {
		return "home";
	}
}
