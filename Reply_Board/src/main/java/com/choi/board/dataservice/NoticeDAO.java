package com.choi.board.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.choi.board.common.Board;
import com.choi.board.common.Notice;
import com.choi.board.common.NoticeReply;
import com.choi.board.common.Page;
import com.choi.board.common.Reply;
import com.choi.board.util.JdbcUtil;

@Repository
public class NoticeDAO {
	private Connection conn;

	public NoticeDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://3.37.252.132:3306/miniproject?useUnicode=true&" + "characterEncoding=utf8&&ServerTimeZone=UTC&autoReconnect=true",
					"miniproject", "1234");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("Connection을 연결할 수 없습니다.");
		}
	}
	
	public int 모든게시물의갯수를세다() {
		String sql = "Select count(*) from notice";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Notice> 게시판목록을가져오다(Page page) {
		String sql = "SELECT * FROM notice " + "WHERE no > 0 ORDER BY no DESC " + "LIMIT ?, ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Notice> 목록 = new ArrayList<Notice>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page.getPageStart());
			pstmt.setInt(2, page.getPerPageNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Notice 글 = new Notice();
				글.setNo(rs.getInt("no"));
				글.setRownum(몇번째글인지출력한다(글.getNo()));
				글.setTitle(rs.getString("title"));
				글.setWriter(rs.getString("writer"));
				글.setContent(rs.getString("content"));
				Date date = rs.getTimestamp("regDate");
				글.setRegDate(date);
				글.setHit(rs.getInt("hit"));
				글.setReplyCnt(댓글수를세다(글.getNo()));
				목록.add(글);
			}
			if (목록.size() > 0) {
				return 목록;
			} else {
				throw new SQLException();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + ": 목록을 가져오는데에 실패하였습니다.");
		}
		return null;
	}

	public int 새글을저장하다(Notice 새게시물) {
		String sql = "insert into notice (title, content) values(?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, 새게시물.getTitle());
			pstmt.setString(2, 새게시물.getContent());
			;
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " 저장 실패");
		}
		return 0;
	}
	
	public Notice 찾는다By번호(int 번호) {
		Notice 찾는게시물 = null;
		PreparedStatement 명령자 = null;
		ResultSet 게시물표 = null;
		String sql = "select * from notice where no = ?";
		try {
			명령자 = conn.prepareStatement(sql);
			명령자.setInt(1, 번호);
			게시물표 = 명령자.executeQuery();
			if (게시물표.next()) {
				찾는게시물 = new Notice();
				찾는게시물.setNo(번호);
				찾는게시물.setRownum(몇번째글인지출력한다(번호));
				찾는게시물.setTitle(게시물표.getString("title"));
				찾는게시물.setContent(게시물표.getString("content"));
				찾는게시물.setWriter(게시물표.getString("writer"));
				Date date = 게시물표.getTimestamp("regDate");
				찾는게시물.setRegDate(date);
				찾는게시물.setHit(게시물표.getInt("hit"));
				찾는게시물.setReplyCnt(댓글수를세다(번호));
			}
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(게시물표);
			JdbcUtil.close(명령자);
		}
		return 찾는게시물;
	}

	public int 게시글을수정하다(Notice notice) {
		String sql = "update notice set title=?, content=?, regDate=now() where no=?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContent());
			pstmt.setInt(3, notice.getNo());
			result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
		return result;
	}

	public int 게시글을삭제하다(int no) {
		String sql = "delete from notice where no=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
		return 0;
	}

	public int 댓글수를세다(int 글번호) {
		String sql = "Select count(*) from notice_reply where notice_no=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 글번호);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt(1);
				return cnt;
			}
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return cnt;
	}

	public int 댓글달다(NoticeReply noticeRe) {
		String sql = "Insert into notice_reply(notice_no,reply_no, writer, memo,regdate) values (?,?,?,?,now())";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeRe.getNotice_no());
			pstmt.setInt(2, 댓글수를세다(noticeRe.getNotice_no())+1);
			pstmt.setString(3, noticeRe.getWriter());
			pstmt.setString(4, noticeRe.getMemo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "댓글 작성 실패");
		} finally {
			JdbcUtil.close(pstmt);
		}
		return 0;
	}

	public void 조회수를올리다(Notice 조회할게시물) {
		String sql = "update notice set hit=? where no=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 조회할게시물.getHit() + 1);
			pstmt.setInt(2, 조회할게시물.getNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public List<NoticeReply> 댓글목록을가져오다(int 게시글번호) {
		String sql = "select * from notice_reply where notice_no=? order by reply_no asc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<NoticeReply> 댓글목록 = new ArrayList<NoticeReply>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 게시글번호);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeReply noticeReply = new NoticeReply();
				noticeReply.setNotice_no(rs.getInt("notice_no"));
				noticeReply.setReply_no(rs.getInt("reply_no"));
				noticeReply.setWriter(rs.getString("writer"));
				noticeReply.setMemo(rs.getString("memo"));
				Date date = rs.getTimestamp("regdate");
				noticeReply.setRegDate(date);
				댓글목록.add(noticeReply);
			}
		} catch (SQLException e) {
			System.out.println(e.getStackTrace() + "댓글 조회 실패");
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return 댓글목록;
	}
	public int 몇번째글인지출력한다(int 게시물번호) {
		String sql = "SELECT COUNT(*) FROM notice WHERE no <= (SELECT no FROM notice WHERE no = ?)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 게시물번호);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return 0;
	}

	public Notice n번째행을출력한다(int no) {
		String sql = "SELECT * FROM notice ORDER BY no asc LIMIT ?,1";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Notice board = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no-1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new Notice();
				board.setNo(rs.getInt("no"));
				board.setRownum(no);
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				Date date = rs.getTimestamp("regDate");
				board.setRegDate(date);
				board.setHit(rs.getInt("hit"));
				board.setReplyCnt(댓글수를세다(board.getNo()));
				return board;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return board;
	}

	public int 댓글을삭제하다(int no, int replyNo) {
		String sql = "delete from notice_reply where notice_no=? and reply_no=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, replyNo);
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
		return 0;
	}
}
