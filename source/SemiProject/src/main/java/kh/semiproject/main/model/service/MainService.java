package kh.semiproject.main.model.service;

import java.sql.Connection;
import java.util.List;

import static kh.semiproject.common.JdbcTemplate.*;
import kh.semiproject.main.model.dao.MainDao;
import kh.semiproject.main.model.vo.MainVo;

public class MainService {
	private MainDao dao = new MainDao();
	
	public List<MainVo> selectList(){
		List<MainVo> result = null;
		Connection conn = getConnection();
		result = dao.makerList(conn);
		close(conn);
		return result;
	}
}
