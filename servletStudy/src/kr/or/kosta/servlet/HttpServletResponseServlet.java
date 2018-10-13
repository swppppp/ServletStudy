package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpResponseServlet
 */
public class HttpServletResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html; charset=utf-8");
		
//		response.setStatus(400);
//		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		
		
//		request.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter(); //프린트writer 만들어져있음
//		
//		String name = request.getParameter("name");
//		if(name != null && name.length() != 0) {
//			if(name.equals("bangry")) {
//				response.sendError(HttpServletResponse.SC_FORBIDDEN);
//				return;
//			}
//		}
//		
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Servlet Programming</title>");
//		out.println("<meta charset=\"utf-8\">");
//		out.println("</head>");
//		out.println("<body style='font-size:20pt'>");
//	    out.println("</body>");
//		out.println("</html>");
		
		// dispatch...(redirect부터...forward는 좀 있다..)
		// low하게 일일이 코드보내서 응답결과만들어주는거
//		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY); //code: 301
//		response.setHeader("location", "/servlet/hello.do");
		// redirect메소드 사용 
		response.sendRedirect("/servlet/hello.do");

	}


}
