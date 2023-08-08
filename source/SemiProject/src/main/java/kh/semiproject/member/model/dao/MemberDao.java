package kh.semiproject.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static kh.semiproject.common.JdbcTemplate.*;
import kh.semiproject.member.model.Dto.MemberDto;

public class MemberDao {
//	private String member_Id;
//	private String member_Pwd;
//	private String member_Name;
//	private String member_Tel;
//	private String member_Email;
//	private String member_Type;
//	private String bs_Number;
//	private String bs_Manager;
	
	
	
	// 일반멤버 회원가입
	public int MemberJoin(Connection conn, MemberDto dto) {

		
		int result = 0;
		String query = "insert into member(MEMBER_ID, MEMBER_PWD, MEMBER_NAME, MEMBER_TEL, MEMBER_EMAIL, MEMBER_TYPE)"
				+ " values(?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, dto.getMember_Id());
			pstmt.setString(2, dto.getMember_Pwd());
			pstmt.setString(3, dto.getMember_Name());
			pstmt.setString(4, dto.getMember_Tel());
			pstmt.setString(5, dto.getMember_Email());
			pstmt.setInt(6, dto.getMember_Type());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	// 비지니스 멤버 회원가입
	public int BsMemberJoin(Connection conn, MemberDto dto) {
		int result = 0;
		String query = "INSERT ALL"
				+ " INTO MEMBER (MEMBER_ID, MEMBER_PWD, MEMBER_NAME, MEMBER_TEL, MEMBER_EMAIL, MEMBER_TYPE)"
				+ " VALUES (?,?,?,?,?,?)"
				+ " INTO BS_MEMBER (BS_NUMBER, BS_MANAGER, MEMBER_ID)"
				+ " VALUES (?,?,?)"
				+ " SELECT * FROM dual";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getMember_Id());
			pstmt.setString(2, dto.getMember_Pwd());
			pstmt.setString(3, dto.getMember_Name());
			pstmt.setString(4, dto.getMember_Tel());
			pstmt.setString(5, dto.getMember_Email());
			pstmt.setInt(6, dto.getMember_Type());
			pstmt.setString(7, dto.getBs_Number());
			pstmt.setString(8, dto.getBs_Manager());
			pstmt.setString(9, dto.getMember_Id());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 중복 아이디 체크 기능
	public boolean checkMemberId(Connection conn, String Member_Id) {
		boolean flag = true;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select member_Id from member where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, Member_Id);
			rs = pstmt.executeQuery();
			if(rs.next() == true) {
				flag = false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return flag;
	}
	// 로그인 기능
	public String login(Connection conn, String member_Id) {
		System.out.println("dao : "+member_Id);
		String result = null;
		String query = "select member_Pwd from member where member_Id = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member_Id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("member_Pwd");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	
	
}
