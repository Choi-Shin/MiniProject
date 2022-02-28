package com.choi.board.dataservice;

import java.util.List;

import com.choi.board.common.AuthUser;
import com.choi.board.common.Message;

public interface IMessageDAO {
	
	int 메시지보내다(Message message);
	int 메시지를삭제하다(int no, String del);
	Message 메시지를읽다(int no, AuthUser user);
	List<Message> 수신함을열다(AuthUser user);
	List<Message> 발신함을열다(AuthUser user);
	
}
