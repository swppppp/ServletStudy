package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 최초 작성 서블릿
 * @author 박시원
 *HttpServlet은 추상메소드..
 */
public class DispatchServlet extends HttpServlet /*implements Servlet*/ {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 디스패치기술
		//리다이렉트
//		response.sendRedirect(location);
		//포워드-->url안바뀜
		RequestDispatcher rd = request.getRequestDispatcher("hello.do");
//		rd.forward(request, response);
		
		rd.include(request, response); //가져온 서블릿을 내꺼에 포함
		
	}

}
