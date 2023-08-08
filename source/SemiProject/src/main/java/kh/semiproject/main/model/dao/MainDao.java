package kh.semiproject.main.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.semiproject.common.JdbcTemplate.*;
import kh.semiproject.main.model.vo.MainVo;

public class MainDao {
	
	public List<MainVo> makerList(Connection conn) {
		System.out.println("Maker List");
		List<MainVo> result = new ArrayList<MainVo>();
		String query = "SELECT BSHOP_NAME, LAT, LNG FROM board ";
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next() == true) {
				MainVo vo = new MainVo(rs.getString("BSHOP_NAME"), 
						rs.getDouble("LAT"), rs.getDouble("LNG"));
				result.add(vo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	
	
}
