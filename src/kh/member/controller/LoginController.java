package kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.MemberService;
import kh.member.model.vo.MemberVo;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login post");
		// 1. jsp에서 들고 온 데이터를
		MemberVo vo=new MemberVo();
		vo.setId(request.getParameter("id"));
		vo.setPasswd(request.getParameter("passwd"));
//		String id=request.getParameter("id");
//		String passwd=request.getParameter("passwd");
		
		//2. db로 전송
		MemberVo result=new MemberService().login(vo);
		if(result!=null) {
			System.out.println("로그인 성공");
			request.getSession().setAttribute("lgnss", result);
			
		}else{
			System.out.println("로그인 실패");
		}
		response.sendRedirect(request.getContextPath()+"/");// 홈 화면으로 이동
		
		//3.페이지 이동 및 데이터전달
		//response.sendRedirect(request.getContextPath()+"url");
		//request.getRequestDispatcher("~.jsp").forward(request, response);
		//request.setAttribute("name", "값");
		//out.println(값); out.flush out.close-- 페이지 이동없이 데이터만 전달
		response.sendRedirect(request.getContextPath()+"/"); // homecontroller로가는
		
	}
}

