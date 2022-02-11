package com.choi.board.dataservice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.choi.board.common.Board;
import com.choi.board.common.Page;
import com.choi.board.common.Reply;

public interface IBoardDAO {
	int 모든게시물의갯수를세다();
	Board n번째행을출력한다(int no);
	int 몇번째글인지출력한다(int 게시물번호);
	List<Board> 게시판목록을가져오다(Page page);
	Board 찾는다By번호(int 번호);
	int 댓글수를세다(int 글번호);
	List<Reply> 댓글목록을가져오다(int 게시글번호);
	int 새글을저장하다(Board 새게시물);
	int 게시글을수정하다(Board board);
	int 게시글을삭제하다(int no);
	int 댓글달다(Reply reply);
	void 조회수를올리다(Board 조회할게시물);
}
