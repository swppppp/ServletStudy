package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet2
 */
public class HelloServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 웹클라이언트로 동적 출력하고자 하는 데이터 생성
				Calendar now = Calendar.getInstance();// 싱글패턴->팩토리메소드 패턴
				String nowString = String.format("%1$tF %1$tT", now);
				
				// 응답메세지의 헤더에 컨텐츠유형 설정
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter(); //프린트writer 만들어져있음
				
				
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Servlet Programming</title>");
				out.println("<meta charset=\"utf-8\">");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>오늘은 "+nowString+"입니다.</h2>");
				out.println("<h2>세션정보: "+request.getSession().getAttribute("username")+"입니다.</h2>");
				
				// 쿠키에서날로온값
				String cookieValue = null;
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						String cookieName = cookie.getName();
						cookieValue = cookie.getValue();
						if(cookie.equals("loginId")) {
							cookieValue = cookie.getValue();
						}
					}
				}
				cookieValue = URLDecoder.decode(cookieValue, "utf-8");
				out.println("<h2>쿠키값: "+cookieValue+"</h2>");
				
				
				out.println("</body>");
				out.println("</html>");
				
	
	}

}
