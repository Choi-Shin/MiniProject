package com.choi.board.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.choi.board.common.Member;
import com.choi.board.util.JdbcUtil;

@Repository
public class MemberDAO {
	private Connection conn;

	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db1?useUnicode=true&" + "characterEncoding=utf8&&ServerTimeZone=UTC",
					"root", "1234");
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
				회원.setEmail(rs.getString("email"));
				Date date = rs.getTimestamp("regdate");
				회원.setRegDate(date);
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
		String sql = "insert into member(id, name, password, email) values(?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getEmail());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
		return -1;
	}

	public int 회원정보수정하다(Member member) {
		String sql = "update member set password=?, email=? where id=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
		return 0;
	}
}
