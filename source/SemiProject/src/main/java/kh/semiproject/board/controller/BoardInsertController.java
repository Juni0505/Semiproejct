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
 * Servlet implementation class BoardInsertController
 */
@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/board/insert.jsp").forward(req, res);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (req.getSession().getAttribute("msg") instanceof String) {
			String msg = (String)req.getSession().getAttribute("msg");
			req.getSession().removeAttribute("msg");
			req.setAttribute("msg", msg);
		}
		
		String bsNumber = req.getParameter("bsNumber");
		String btitle = req.getParameter("btitle");
		String bcontent = req.getParameter("bcontent");
		String bwriter = req.getParameter("bwriter");
		String baddress = req.getParameter("baddress");
		String btel = req.getParameter("btel");
		String bshopName = req.getParameter("bshopName");
		double lat = Double.parseDouble(req.getParameter("lat"));
		double lng = Double.parseDouble(req.getParameter("lng"));

		BoardService service = new BoardService();
		
		int result = service.storeInsert(new BoardDto(bsNumber, btitle, bcontent,bwriter, baddress, btel, bshopName, lat, lng));
		if(result == 1) {
			System.out.println("가게등록 성공");
			req.getSession().setAttribute("msg", "가게가 성공적으로 등록 되었습니다.");
			req.setAttribute("dto", result);
			res.sendRedirect(req.getContextPath()+"/board");
		}else {
			System.out.println("가게등록 실패");
			req.getSession().setAttribute("msg", "등록을 실패했습니다. 다시 입력해주세요.");
			res.sendRedirect(req.getContextPath()+"/board/insert");
		}
	}

}
