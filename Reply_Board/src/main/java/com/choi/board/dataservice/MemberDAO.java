package com.choi.board.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.choi.board.common.AuthUser;
import com.choi.board.common.Member;
import com.choi.board.common.Message;
import com.choi.board.util.JdbcUtil;

@Repository
public class MemberDAO {
	private Connection conn;

	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://3.37.252.132/miniproject?useUnicode=true&"
					+ "characterEncoding=utf8&&ServerTimeZone=UTC&autoReconnect=true", "miniproject", "1234");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("Connection을 연결할 수 없습니다.");
		}
	}

	public Member 찾는다ById(String id) {
		String sql = "Select * from member where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member 회원 = new Member();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				회원.setId(id);
				회원.setName(rs.getString("name"));
				회원.setPassword(rs.getString("password"));
				회원.setProfile(rs.getBytes("profile"));
				회원.setEmail(rs.getString("email"));
				Date date = rs.getTimestamp("regdate");
				회원.setRegDate(date);
				회원.setState(rs.getInt("state"));
			}
			return 회원;
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return null;
	}

	public int 회원가입하다(Member member) {
		String sql = "insert into member(id, name, profile, password, email, auth_key) values(?,?,?,md5(?),?, ?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setBytes(3, member.getProfile());
			pstmt.setString(4, member.getPassword());
			pstmt.setString(5, member.getEmail());
			pstmt.setInt(6, member.getAuth_key());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
		return -1;
	}

	public int 비밀번호변경하다(Member member) {
		String sql = "update member set password=md5(?) where id=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
		return 0;
	}

	public int 프로필사진변경하다(Member member) {
		String sql = "update member set profile=? where id=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setBytes(1, member.getProfile());
			pstmt.setString(2, member.getId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
		return 0;
	}

	public int 회원탈퇴하다(String id) {
		PreparedStatement pstmt = null;
		String 게시판상태변경 = "update board set state=3 where writer=?";
		try {
			pstmt = conn.prepareStatement(게시판상태변경);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e1) {
		}
		pstmt = null;
		String sql = "update member set state=3 where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
		return 0;
	}

	public Member 로그인하다(AuthUser 로그인회원) {
		String sql = "Select * from member where id=? and password=md5(?) and auth_status=1";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member 회원 = new Member();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, 로그인회원.getId());
			pstmt.setString(2, 로그인회원.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				회원.setId(rs.getString("id"));
				회원.setName(rs.getString("name"));
				회원.setPassword(rs.getString("password"));
				회원.setProfile(rs.getBytes("profile"));
				회원.setEmail(rs.getString("email"));
				Date date = rs.getTimestamp("regdate");
				회원.setRegDate(date);
				회원.setState(rs.getInt("state"));
				회원.setUnreadMsg(읽지않은메시지를세다(로그인회원.getId()));
				return 회원;
			}
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return null;
	}

	public int 이메일주소변경하다(Member m) {
		String sql = "update member set email = ? where id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
		return 0;
	}

	public List<Message> 읽지않은메시지를세다(String id) {
		String sql = "select * from message where recv_id = ? and recv_read = 'N' and recv_del ='N'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			List<Message> list = new ArrayList<Message>();
			while (rs.next()) {
				Message msg = new Message();
				msg.setNo(rs.getInt("no"));
				msg.setRecv_id(rs.getString("recv_id"));
				msg.setSend_id(rs.getString("send_id"));
				msg.setTitle(rs.getString("title"));
				msg.setNote(rs.getString("note"));
				Date d = rs.getTimestamp("date_sent");
				msg.setDate_sent(d);
				if (rs.getTimestamp("date_read") != null) {
					d = rs.getTimestamp("date_read");
					msg.setDate_read(d);
				}
				msg.setRecv_read(rs.getString("recv_read").charAt(0));
				msg.setRecv_del(rs.getString("recv_del").charAt(0));
				msg.setSent_del(rs.getString("sent_del").charAt(0));
				list.add(msg);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String 중복아이디를확인하다(String id) {
		String sql = "select count(*) from member where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1);
				if(result > 0) {
					return "1";
				}
				else {
					return "0";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "-1";
	}

	public boolean 가입인증하다(String email, int authKey) {
		String sql = "update member set auth_status=1 where email = ? and auth_key = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, authKey);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
