package kh.home.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.board.model.service.BoardService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({"/", "/main", "/index", "/home"}) // 여기서 / 없으면 오류뜸
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aaa = request.getParameter("aaa");
		
		//2.db 갔다와서 게시판 데이터 뿌리기
		// dto, dao, service, view, controller
			
		//1. paging처리를 위해 글의 총갯수 확인해야--db에서 알아오기
		int cnt = 0;  // 글의 총갯수
		cnt = service.getCountBoard();
		//2. 한 페이지에 나타낼 글 수 정해야
		int pageSize = 2;  // 보통 10개
		//3. 아래 페이지 수 -- 이전 << 1 2 >> 이후
		int pageBlock = 3; // 보통 5개
		//4. 현재페이지
		int currentPage = 1; // default 1, 페이지 클릭시 값 변경
		try {
			currentPage = Integer.parseInt(aaa);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		
		// 5- row num 범위정하기
		int startRnum = 0;
		int endRnum = 0;
		startRnum = ((currentPage-1) * pageSize)+1;  // 1-1, 2-4
		endRnum = (startRnum+pageSize-1 > cnt) ?  cnt : startRnum+pageSize-1 ;
		System.out.println(startRnum);
		System.out.println(endRnum);
		request.setAttribute("boardlist", service.getBoardList(startRnum,endRnum));
		
		// 6-페이지 범위정하기
		int startPageNum = 0;
		int endPageNum = 0;
		startPageNum = (currentPage % pageBlock == 0) 
				? (( currentPage/pageBlock - 1) * pageBlock + 1) 
				: (( currentPage/pageBlock ) * pageBlock + 1);
		int pageCnt = (cnt/pageSize) + (cnt % pageSize == 0 ? 0 : 1);
//		if(cnt % pageSize != 0 ) {
//			pageCnt++;
//		}
		endPageNum = (startPageNum + pageBlock - 1 > pageCnt) ? pageCnt : startPageNum + pageBlock - 1;
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCnt", pageCnt);
		
		
//		request.setAttribute("boardlist", service.getBoardList());
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}