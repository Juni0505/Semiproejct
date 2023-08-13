package kh.semiproject.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semiproject.member.model.Dto.MemberDto;
import kh.semiproject.member.model.service.MemberService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setAttribute("msg", request.getSession().getAttribute("msg"));
//		request.getSession().removeAttribute("msg");
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("msg") instanceof String) {
			String msg = (String)request.getSession().getAttribute("msg");
			request.getSession().removeAttribute("msg");
			request.setAttribute("msg", msg);
		}
		MemberService service = new MemberService();
		String member_Id = request.getParameter("member_Id");
		String member_Pwd = request.getParameter("member_Pwd");
		String result = service.login(member_Id);
		System.out.println(result);
		if (result == null) {
			System.out.println("로그인 실패");
			request.getSession().setAttribute("msg", "정보를 다시 확인하고 입력해주세요");
			response.sendRedirect(request.getContextPath() + "/login");
		} else if (member_Pwd.equals(result)) {
			System.out.println("로그인 성공");
			request.getSession().setAttribute("msg", member_Id + "님 환영합니다");
			request.getSession().setAttribute("mid", member_Id);
			response.sendRedirect(request.getContextPath() + "/main");
		} else if (!(member_Pwd.equals(result))) {
			System.out.println("비밀번호 오류");
			request.getSession().setAttribute("msg", "비밀번호 오류입니다. 다시 확인해주세요");
			response.sendRedirect(request.getContextPath() + "/login");

		}
	}
}
