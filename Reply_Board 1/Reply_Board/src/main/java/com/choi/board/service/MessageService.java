package com.choi.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choi.board.common.AuthUser;
import com.choi.board.common.Message;
import com.choi.board.dataservice.MessageDAO;

@Service
public class MessageService implements IMessageService {
	@Autowired
	MessageDAO dao;

	public int 메시지보내다(Message message) {
		return dao.메시지보내다(message);
	}

	public int 메시지를삭제하다(int no, String del) {
		return dao.메시지를삭제하다(no, del);
	}

	public Message 메시지를읽다(int message, AuthUser user) {
		return dao.메시지를읽다(message, user);
	}

	public List<Message> 수신함을열다(AuthUser user) {
		return dao.수신함을열다(user);
	}

	public List<Message> 발신함을열다(AuthUser user) {
		return dao.발신함을열다(user);
	}

}
