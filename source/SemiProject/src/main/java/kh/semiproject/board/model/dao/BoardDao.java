package kh.semiproject.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.semiproject.board.model.vo.BoardDto;
import static kh.semiproject.common.JdbcTemplate.*;

public class BoardDao {
	public int storeInsert(Connection conn, BoardDto dto) {
		int result = 0;
		String query = "insert into board(BNO, BS_NUMBER, BTITLE, BCONTENT, BWRITE_DATE, BWRITER, BADDRESS, BTEL, BSHOP_NAME, LAT, LNG)"
				+ " values (default,?,?,?,default,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getBsNumber());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBwriter());
			pstmt.setString(5, dto.getBaddress());
			pstmt.setString(6, dto.getBtel());
			pstmt.setString(7, dto.getBshopName());
			pstmt.setDouble(8, dto.getLat());
			pstmt.setDouble(9, dto.getLng());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public List<BoardDto> selectList(Connection conn) {
		List<BoardDto> result = new ArrayList<BoardDto>();
		String query = "select BNO, BTITLE, BWRITER, to_char(BWRITE_DATE,'yyyy-mm-dd') BWRITE_DATE from board";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next() == true) {
				BoardDto dto = new BoardDto(rs.getInt("BNO"),
					rs.getString("BTITLE"), 
					rs.getString("BWRITE_DATE"),
					rs.getString("BWRITER")
					);
				result.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public BoardDto selectOne(Connection conn, String btitle) {
		BoardDto result = null;
		String query = "select BNO, BTITLE, BCONTENT, to_char(BWRITE_DATE, 'yyyy-mm-dd hh24:mi:ss') BWRITE_DATE, BWRITER, BADDRESS, BTEL, BSHOP_NAME from board where btitle = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, btitle);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			result = new BoardDto(rs.getInt("BNO"),
					rs.getString("BTITLE"),
					rs.getString("BCONTENT"),
					rs.getString("BWRITE_DATE"),
					rs.getString("BWRITER"),
					rs.getString("BADDRESS"),
					rs.getString("BTEL"),
					rs.getString("BSHOP_NAME"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
}
