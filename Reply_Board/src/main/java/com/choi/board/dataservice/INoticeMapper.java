package com.choi.board.dataservice;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.choi.board.common.Board;
import com.choi.board.common.Notice;
import com.choi.board.common.NoticeReply;
import com.choi.board.common.Page;
import com.choi.board.common.Reply;

@Mapper
public interface INoticeMapper {

	@Select("SELECT COUNT(*) FROM notice")
	int 모든게시물의갯수를세다();

	@Select("SELECT * FROM notice ORDER BY no ASC LIMIT #{no},1")
	@Results(value = {
			@Result(property = "rownum", column = "rownum", one = @One(select = "com.choi.notice.dataservice.INoticeMapper.몇번째글인지출력한다")),
			@Result(property = "no", column = "no"), @Result(property = "title", column = "title"),
			@Result(property = "content", column = "content"), @Result(property = "writer", column = "writer"),
			@Result(property = "regDate", column = "regDate"), @Result(property = "hit", column = "hit"),
			@Result(property = "replyCnt", column = "replyCnt") })
	Notice n번째행을출력한다(@Param("no") int no);

	@Select("SELECT COUNT(*) FROM notice WHERE no <= (SELECT no FROM notice WHERE no = #{no}")
	int 몇번째글인지출력한다(int no);

	@Select("SELECT * FROM notice where no=#{no}")
	@Results(value = {
			@Result(property = "rownum", column = "rownum", one = @One(select = "com.choi.board.dataservice.INoticeMapper.몇번째글인지출력한다")),
			@Result(property = "no", column = "no"), @Result(property = "title", column = "title"),
			@Result(property = "content", column = "content"), @Result(property = "writer", column = "writer"),
			@Result(property = "regDate", column = "regDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "hit", column = "hit"), @Result(property = "replyCnt", column = "replyCnt") })
	Notice 찾는다By번호(int no);

	@Select("SELECT * FROM notice WHERE no > 0 ORDER BY no DESC LIMIT #{pageStart}, #{perPageNum}")
	@Results(value = {
			@Result(property = "rownum", column = "rownum", one = @One(select = "com.choi.board.dataservice.INoticeMapper.몇번째글인지출력한다")),
			@Result(property = "no", column = "no"), @Result(property = "title", column = "title"),
			@Result(property = "content", column = "content"), @Result(property = "writer", column = "writer"),
			@Result(property = "regDate", column = "regDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "hit", column = "hit"), @Result(property = "replyCnt", column = "replyCnt") })
	List<Notice> 게시판목록을가져오다(Page page);

	@Select("SELECT COUNT(*) FROM notice_reply WHERE board_no=#{no}")
	int 댓글수를세다(int no);

	@Select("SELECT * FROM notice_reply WHERE notice_no=#{no} ORDER BY reply_no ASC")
	@Results(value = { @Result(property = "notice_no", column = "notice_no"),
			@Result(property = "reply_no", column = "reply_no"), @Result(property = "writer", column = "writer"),
			@Result(property = "memo", column = "memo"),
			@Result(property = "regDate", column = "regDate", jdbcType = JdbcType.TIMESTAMP) })
	List<NoticeReply> 댓글목록을가져오다(int 게시글번호);

	@Insert("INSERT INTO notice (title, writer, content, regDate) VALUES (?,?,?,now())")
	int 새글을저장하다(Notice 새게시물);
	
	@Update("UPDATE notice SET title=#{title}, content=#{content}, regDate=now() where no=#{no}")
	int 게시글을수정하다(Notice board);
	
	@Delete("DELETE FROM notice WHERE no=#{no}")
	int 게시글을삭제하다(int no);
	
	@Insert("INSERT INTO notice_reply(board_no,reply_no, writer, memo,regdate) values (?,?,?,?,now())")
	int 댓글달다(NoticeReply reply);
	
	@Update("UPDATE notice SET hit=#{hit} WHERE no=#{no}")
	void 조회수를올리다(Notice 조회할게시물);
}
