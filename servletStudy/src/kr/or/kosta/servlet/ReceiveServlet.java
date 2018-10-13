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
public class ReceiveServlet extends HttpServlet /*implements Servlet*/ {
	// thread의 runnable과 같이...servlet interface구현
	// 콜백메소드
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);

	}
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); //프린트writer 만들어져있음
		
		// 요청 파라미터 수신
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("userpw");
		String team = request.getParameter("teams");
		String ta = request.getParameter("text");
		String[] hobbys = request.getParameterValues("hobby");
		Enumeration<String> params = request.getParameterNames();
				
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style='font-size:20pt'>");
		out.println("<h3>아이디: "+userid+"</h3>");
		out.println("<h3>비밀번호: "+passwd+"</h3>");
		out.println("<h3>선택한 팀: "+team+"</h3>");
		out.println("<h3>텍스트에어리아: "+ta+"</h3>");
		
		if(hobbys != null) {
			for (String hobby : hobbys) {
				out.println("<h3>취미들: "+hobby+"</h3>");

			}
		}
		out.println("<h3>-----------------------------------------<h3><br>");
		while (params.hasMoreElements()) {
			String name = params.nextElement();
			String value = request.getParameter(name);
			System.out.println(name+"= "+value);
		}
		
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
