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
 * Servlet implementation class JoinController
 */
@WebServlet("/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("msg") instanceof String) {
			String msg = (String)request.getSession().getAttribute("msg");
			request.setAttribute("msg", msg);
			request.getSession().removeAttribute("msg");
		}
		
		MemberService service = new MemberService();
		String checkId =request.getParameter("member_Id");
		System.out.println(checkId);
		int check = service.idCheck(checkId);
		if(check == 0) {
			System.out.println("사용불가능");
			request.setAttribute("check", check);
		} else {
			System.out.println("사용가능");
			request.setAttribute("check", check);
		}
		
		
		
		String member_Id = request.getParameter("member_Id");
		String member_Pwd = request.getParameter("member_Pwd");
		String member_Name = request.getParameter("member_Name");
		String member_Tel = request.getParameter("member_Tel");
		String member_Email = request.getParameter("member_Email");
		int member_Type = Integer.parseInt(request.getParameter("member_Type"));
		String bs_Number = request.getParameter("bs_Number");
		String bs_Manager = request.getParameter("bs_Manager");
		
		
		if (member_Type == 0) {
			MemberDto vo = new MemberDto(member_Id, member_Pwd, member_Name, member_Tel, member_Email, member_Type);
			service.insert(vo);
		} else {
			MemberDto vo = new MemberDto(member_Id, member_Pwd, member_Name, member_Tel, member_Email, member_Type, bs_Number, bs_Manager);
			service.insert(vo);
		}
	}
}
