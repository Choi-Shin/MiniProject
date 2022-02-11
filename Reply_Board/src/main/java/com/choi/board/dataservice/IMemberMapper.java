package com.choi.board.dataservice;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.choi.board.common.Member;

@Mapper
public interface IMemberMapper {
	
	@Select("SELECT * FROM member WHERE id=#{id}")
	@Results(value = {
			@Result(property = "id",column = "id"),
			@Result(property = "name",column = "name"),
			@Result(property = "password",column = "password"),
			@Result(property = "email",column = "email"),
			@Result(property = "regDate",column = "regDate",jdbcType = JdbcType.TIMESTAMP)
	})
	Member 찾는다ById(String id);
	
	@Insert("INSERT INTO member(id, name, password, email) VALUES(?,?,?,?)")
	int 회원가입하다(Member member);
	
	@Update("UPDATE member SET password=#{password} where id=#{id}")
	int 비밀번호변경하다(Member member);
	
	@Update("update member set status=3 where id=#{id}")
	int 회원탈퇴하다(String id);
}
