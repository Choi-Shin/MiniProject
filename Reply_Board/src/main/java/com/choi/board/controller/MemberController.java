package com.choi.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@GetMapping(value ="/admin/login")
	public String 관리자로그인팝업띄우다(AuthUser user) {
		return "/member/관리자로그인팝업";
	}
	
	@PostMapping(value = "/login")
	public ModelAndView 로그인시도하다(AuthUser user) {
		ModelAndView mv = new ModelAndView();
		boolean 로그인결과;
		String welcome;
		try {
			로그인결과 = ms.로그인하다(user);

			if (로그인결과 == false) {
				mv.addObject("msg", "존재하지 않는 아이디이거나 비밀번호가 틀립니다.");
				mv.setViewName("/member/로그인결과");
				return mv;
			} else if (로그인결과 == true) {
				if (user.getId().equals("admin")) {
					welcome = "관리자 로그인에 성공하였습니다.";
					mv.addObject("admin", user);
				} else {
					welcome = "환영합니다. " + user.getId() + "님";
				}
				mv.addObject("msg", welcome);
				mv.addObject("loginUser", user);
				mv.setViewName("/member/로그인결과");
			}
		} catch (Exception e) {
		}
		return mv;
	}
	
	@PostMapping(value = "/admin/login")
	public ModelAndView 관리자로그인시도하다(AuthUser user) {
		ModelAndView mv = new ModelAndView();
		boolean 로그인결과;
		String welcome;
		if (user.getId().equals("admin")) {
			try {
				로그인결과 = ms.로그인하다(user);
				if (로그인결과 == false) {
					welcome = "관리자 로그인에 실패하였습니다.";
					mv.addObject("msg", welcome);
				} else if (로그인결과 == true) {
					welcome = "관리자 로그인에 성공하였습니다.";
					mv.addObject("msg", welcome);
					mv.addObject("admin", user);
					mv.addObject("loginUser", user);
				}
			} catch (Exception e) {
			}
			
		} else {
			welcome = "관리자 로그인에 실패하였습니다.";
			mv.addObject("msg", welcome);
		}
		mv.setViewName("/member/로그인결과");
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
		if (result == -1) {
			mv.addObject("msg", "가입에 실패하였습니다.");
		} else if (result == 0) {
			mv.addObject("msg", "이미 존재하는 아이디입니다.");
		} else if (result > 0) {
			mv.addObject("msg", "가입되었습니다.");
		}
		return mv;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String 로그아웃하다() {
		return "member/로그아웃";
	}

	@GetMapping(value = "/modify")
	public String 정보수정창을띄우다() {
		return "member/회원정보수정";
	}

	@PostMapping(value = "/modify")
	public ModelAndView 회원정보수정을요청하다(HttpSession session, String newPassword) {
		ModelAndView mv = new ModelAndView();
		AuthUser user = (AuthUser) session.getAttribute("loginUser");
		Member m = ms.찾는다ById(user.getId());
		m.setPassword(newPassword);	
		int result = ms.비밀번호변경하다(m);
		if (result > 0) {
			mv.addObject("msg", "정보를 수정하였습니다.");
			user.setPassword(newPassword);
			session.setAttribute("loginUser", user);
			mv.setViewName("/member/회원정보수정결과");
		} else {
			mv.addObject("msg", "수정에 실패하였습니다.");
			mv.setViewName("/member/회원정보수정결과");
		}
		return mv;
	}
	
	@GetMapping(value = "/withdraw")
	public ModelAndView 회원탈퇴하다(String id) {
		ModelAndView mv = new ModelAndView();
		int result = ms.회원탈퇴하다(id);
		String msg;
		if(result > 0) {
			msg = id + "님의 탈퇴가 정상처리 되었습니다.";
			mv.addObject("msg", msg);
		} else {
			msg = "탈퇴에 실패하였습니다. 관리자에게 문의바랍니다.";
			mv.addObject("msg", msg);
		}
		mv.addObject("url", "/");
		mv.setViewName("redirect");
		return mv;
	}
}
