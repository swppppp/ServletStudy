package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 최초 작성 서블릿
 * @author 박시원
 *HttpServlet은 추상메소드..
 */
public class HttpServletRequestServlet extends HttpServlet /*implements Servlet*/ {
	// thread의 runnable과 같이...servlet interface구현
	// 콜백메소드
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); //프린트writer 만들어져있음
		
		String clientIp = request.getRemoteAddr();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String protocol = request.getProtocol();
		String query = request.getQueryString();
		String param = request.getParameter("name");
		String applicationName = request.getContextPath(); // 웹앱이름
		String servletName = request.getServletPath(); //서블릿이름
		
		Enumeration<String> headerNames = request.getHeaderNames();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style='font-size:20pt'>");
		out.println("<ul>");
		out.println("<li>"+clientIp+"</li>");
		out.println("<li>"+method+"</li>");
		out.println("<li>"+uri+"</li>");
		out.println("<li>"+protocol+"</li>");
		
		//헤더이름
		while (headerNames.hasMoreElements()) {
			 String name =  headerNames.nextElement();
			 String value = request.getHeader(name);
			 out.println("<li>"+ name + ":"+ value + "</li>");
		}
		out.println("<li>쿼리스트링: "+query+"</li>");
		out.println("<li>파라미터값: "+param+"</li>");
		out.println("<li>"+applicationName+"</li>");
		out.println("<li>"+servletName+"</li>");


		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

}
