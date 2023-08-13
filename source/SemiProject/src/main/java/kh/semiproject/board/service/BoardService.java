package kh.semiproject.board.service;

import static kh.semiproject.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import kh.semiproject.board.model.dao.BoardDao;
import kh.semiproject.board.model.vo.BoardDto;

public class BoardService {
	BoardDao dao = new BoardDao();
	
	public int storeInsert(BoardDto dto) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.storeInsert(conn, dto);
		commit(conn);
		close(conn);
		return result;
	}
	public List<BoardDto> selectList(){
		List<BoardDto> result = null;
		Connection conn = getConnection();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
	public BoardDto selectOne(String btitle) {
		BoardDto result = null;
		Connection conn = getConnection();
		result = dao.selectOne(conn, btitle);
		close(conn);
		return result; 
	}
}
