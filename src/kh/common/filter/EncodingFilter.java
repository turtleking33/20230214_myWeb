package kh.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	//매핑되는 url에 설정 걸어주면 해당 url 가기전에 ex./login, /enroll로 바고 가지 않고 filter로 왔다가 가는
	//호출하지 않아도 거치고 갈 수 있게

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		chain.doFilter(request, response);//여러단계 필터가 있을 때, 클리이언트가 원했던 리쿼스, 어디로 가야하는지 리스펀스도 가지고 가야
		
		
	}
		
	
}
