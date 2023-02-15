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
@WebServlet("/enroll")
public class EnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/enroll.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력한 name이 한글일 때 안 개지게 하기 위한
		request.setCharacterEncoding("UTF-8");
		//1. form으로부터 전달받은 데이터 읽어 변수에 담기
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		MemberVo vo=new MemberVo();
		vo.setId(id);
		vo.setPasswd(passwd);
		vo.setName(name);
		vo.setEmail(email);
		//System.out.println("Ctrl param: "+vo);
		//2. db 갔다 오기/ 위 데이터 가지고 dao로 가는  dto,vo 0  dao1 
		int result=new MemberService().enroll(vo);
		
		if(result<1) {
			System.out.println("회원가입 실패");
		}else {
			System.out.println("가입 성공");
			response.sendRedirect(request.getContextPath()+"/");
		}
		
	}
	
}
