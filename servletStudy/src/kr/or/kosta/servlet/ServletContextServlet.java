package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 최초 작성 서블릿
 * @author 박시원
 *HttpServlet은 추상메소드..
 */
public class ServletContextServlet extends HttpServlet /*implements Servlet*/ {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "서블릿간의 데이터 공유";
		
		ServletContext context = getServletContext();
		System.out.println(context.getServerInfo());
		System.out.println(context.getContextPath());

		System.out.println(getServletContext().getContextPath());
		
		context.setAttribute("shareValue", message); // 키와 밸류로 저장
//		response.sendRedirect("/hello.do");
		
		String location = context.getInitParameter("Location");
		System.out.println(location);
		
	}

}
