package kh.semiproject.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semiproject.board.model.vo.BoardDto;
import kh.semiproject.board.service.BoardService;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/board")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BoardService service = new BoardService();
		List<BoardDto> dto = service.selectList();
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/WEB-INF/view/board/list.jsp").forward(req, res);

	}
}
