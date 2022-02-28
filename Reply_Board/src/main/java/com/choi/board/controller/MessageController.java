package com.choi.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.choi.board.common.AuthUser;
import com.choi.board.common.Message;
import com.choi.board.common.MessageDuo;
import com.choi.board.common.Page;
import com.choi.board.common.PageNavigator;
import com.choi.board.service.IMessageService;

@Controller
@RequestMapping("/message/*")
public class MessageController {
	
	@Autowired
	IMessageService mgs;
	
	@GetMapping(value = "/receiveBox")
	public ModelAndView 수신함띄우다(HttpSession session,@RequestParam(required=false) Page page) {
		ModelAndView mv = new ModelAndView();
		AuthUser user = (AuthUser)session.getAttribute("loginUser");
		List<Message> list = mgs.수신함을열다(user);
		PageNavigator 페이지탐색기 = new PageNavigator();
		if (page == null) {
			page = new Page();			
		}
		페이지탐색기.setPage(page);
		페이지탐색기.setTotalCount(list.size());
		mv.addObject("list", list);
		mv.addObject("pageNavigator", 페이지탐색기);
		mv.setViewName("/message/쪽지함팝업");
		return mv;
	}
	
	@GetMapping(value = "/sendBox")
	public ModelAndView 발신함띄우다(HttpSession session,@RequestParam(required=false) Page page) {
		ModelAndView mv = new ModelAndView();
		AuthUser user = (AuthUser)session.getAttribute("loginUser");
		List<Message> list = mgs.발신함을열다(user);
		PageNavigator 페이지탐색기 = new PageNavigator();
		if (page == null) {
			page = new Page();			
		}
		페이지탐색기.setPage(page);
		페이지탐색기.setTotalCount(list.size());
		mv.addObject("list", list);
		mv.addObject("pageNavigator", 페이지탐색기);
		mv.setViewName("/message/쪽지함팝업");
		return mv;
	}
	
	@GetMapping(value ="/read")
	public ModelAndView 메시지상세출력하다(HttpSession session, int no) {
		ModelAndView mv = new ModelAndView();
		AuthUser user = (AuthUser)session.getAttribute("loginUser");
		Message m = mgs.메시지를읽다(no, user);
		mv.addObject("message", m);
		List<Message> 메시지 = user.getUnreadMsg();
		메시지.remove(m);
		user.setUnreadMsg(메시지);
		session.setAttribute("loginUser", user);
		mv.setViewName("/message/메시지상세보기");
		return mv;
	}
	
	@GetMapping(value ="/send")
	public ModelAndView 메시지보내다(HttpSession session, String id) {
		ModelAndView mv = new ModelAndView();
		AuthUser user = (AuthUser)session.getAttribute("loginUser");
		MessageDuo md = new MessageDuo();
		md.setRecv_id(id);
		md.setSend_id(user.getId());
		mv.addObject("MessageDuo", md);
		mv.setViewName("/message/메시지전송팝업");
		return mv;
	}
	@PostMapping(value ="/send")
	public ModelAndView 메시지보내다(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String msg;
		String recv_id = (String)req.getParameter("recv_id");
		String send_id = (String)req.getParameter("send_id");
		Message m = new Message();
		m.setRecv_id(recv_id);
		m.setSend_id(send_id);
		m.setTitle((String)req.getParameter("title"));
		m.setNote((String)req.getParameter("note"));
		int result = mgs.메시지보내다(m);
		if(result > 0) {
			msg = "메시지를 전송했습니다.";
		} else {
			msg = "메시지 전송에 실패했습니다. 관리자에게 문의하세요.";
		}
		mv.addObject("msg", msg);
		mv.setViewName("/member/팝업종료");
		return mv;
	}
	
	@GetMapping(value="/delete")
	public ModelAndView 메시지삭제하다(int no, String id) {
		ModelAndView mv = new ModelAndView();
		String msg;
		int result = mgs.메시지를삭제하다(no, id);
		if(result > 0) {
			msg = "메시지가 삭제되었습니다.";
			mv.addObject("msg", msg);
		} else {
			msg = "메시지 삭제에 실패하였습니다.";
			mv.addObject("msg", msg);
		}
		mv.setViewName("/member/팝업종료");
		return mv;
	}
}
