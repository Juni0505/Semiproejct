package kh.semiproject.member.model.service;

import static kh.semiproject.common.JdbcTemplate.*;

import java.sql.Connection;

import kh.semiproject.member.model.Dto.MemberDto;
import kh.semiproject.member.model.dao.MemberDao;

public class MemberService {
	public MemberDao dao = new MemberDao();
	
	
	public String login(String member_Id) {
		String result = null;
		Connection conn = getConnection();
		result = dao.login(conn, member_Id);
		System.out.println(result);
		close(conn);
		return result;
	}
	public int idCheck(String member_Id) {
		int result = 0;
		boolean idcheck = true;
		Connection conn = getConnection();
		idcheck = dao.checkMemberId(conn, member_Id);
		if(idcheck == true) {
			result = 1;
			System.out.println("사용 가능한 아이디입니다.");
		}else {
			result = 0;
			System.out.println("중복 아이디 입니다.");
		}
		close(conn);
		return result;
		
	}
	
	public int insert(MemberDto dto) {
		int result = 0;
		Connection conn = getConnection();
		setAutoCommint(conn, false);
		if(dto.getMember_Type() == 0) {
			result = dao.MemberJoin(conn, dto);
		} else {
			result = dao.BsMemberJoin(conn, dto);
		}
		close(conn);
		return result;
	}
}
