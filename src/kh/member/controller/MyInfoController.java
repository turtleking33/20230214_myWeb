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
 * Servlet implementation class MyInfoController
 */
@WebServlet("/myinfo")
public class MyInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 쿼리스트링으로 가지고오는게 없으니 안 해도 됨
		String id=null;
		if(request.getSession().getAttribute("lgnss")!=null) {
			
			id=((MemberVo)(request.getSession().getAttribute("lgnss"))).getId();
			
		}
		//2. db에 갔다오는데 id정보 가져와야/id에 해당한느 정보 db에서 읽어와야
		if(id!=null) {
			//3.페이지 이동 및 데이터전달
			//response.sendRedirect(request.getContextPath()+"url");
			//request.getRequestDispatcher("~.jsp").forward(request, response);
			//request.setAttribute("name", "값");
			//out.println(값); out.flush out.close-- 페이지 이동없이 데이터만 전달
			
			request.getRequestDispatcher("/WEB-INF/view/member/myinfo.jsp").forward(request, response);
			request.setAttribute("myinfo", new MemberService().myInfo(id));
		}else {
			
			//방법 1: 로그인 정보가 없을 때(로그인되지 않은), 많은 jsp 페이지에서 같은 코드 작성해야하는 불편
			
			//방법2: 로그인 정보가 없을 떄, 하나의 error page를 만들어 줌
			request.setAttribute("errorMsg", "로그인 되지 내정보 확인 할 수 없다");
			request.getRequestDispatcher("/WEB-INF/view/error/errorLogin.jsp").forward(request, response);
		}
		
		
		
	}


}
