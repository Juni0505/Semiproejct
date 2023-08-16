package kh.semiproject.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semiproject.board.model.vo.BoardDto;
import kh.semiproject.board.service.BoardService;

/**
 * Servlet implementation class BoardViewDetailServlet
 */
@WebServlet("/board/view")
public class BoardViewDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String btitle = req.getParameter("btitle");
		BoardService service = new BoardService();
		BoardDto dto = service.selectOne(btitle);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/WEB-INF/view/board/viewdetail.jsp").forward(req, res);

	}


}
