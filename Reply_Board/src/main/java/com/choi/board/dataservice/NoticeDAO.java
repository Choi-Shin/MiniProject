package com.choi.board.dataservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choi.board.common.Notice;
import com.choi.board.common.NoticeReply;
import com.choi.board.common.Page;

@Repository
public class NoticeDAO implements INoticeDAO {
	@Autowired INoticeMapper noticeDAO;
	
	public int 모든게시물의갯수를세다() {
		return noticeDAO.모든게시물의갯수를세다();
	}

	public List<Notice> 게시판목록을가져오다(Page page) {
		return noticeDAO.게시판목록을가져오다(page);
	}

	public int 새글을저장하다(Notice 새게시물) {
		return noticeDAO.새글을저장하다(새게시물);
	}
	
	public Notice 찾는다By번호(int 번호) {
		return noticeDAO.찾는다By번호(번호);
	}

	public int 게시글을수정하다(Notice notice) {
		return noticeDAO.게시글을수정하다(notice);
	}

	public int 게시글을삭제하다(int no) {
		return noticeDAO.게시글을삭제하다(no);
	}

	public int 댓글수를세다(int 글번호) {
		return noticeDAO.댓글수를세다(글번호);
	}

	public int 댓글달다(NoticeReply noticeRe) {
		return noticeDAO.댓글달다(noticeRe);
	}

	public void 조회수를올리다(Notice 조회할게시물) {
		noticeDAO.조회수를올리다(조회할게시물);
	}
	
	public List<NoticeReply> 댓글목록을가져오다(int 게시글번호) {
		return noticeDAO.댓글목록을가져오다(게시글번호);
	}
	public int 몇번째글인지출력한다(int 게시물번호) {
		return noticeDAO.몇번째글인지출력한다(게시물번호);
	}

	public Notice n번째행을출력한다(int no) {
		return noticeDAO.n번째행을출력한다(no);
	}
}
