package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountServlet
 */
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿠키사용, 브라우저의 방문 수 출력
		int count = 0;
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(("count"))) {
					count = Integer.parseInt(cookie.getValue());
				}
			}
		}
		count++;
		
		Cookie cookie = new Cookie("count", String.valueOf(count));
		cookie.setMaxAge(60*60*24*30); //초단위..이건 한달/ 안쓰면 브라우저도는동안만
		response.addCookie(cookie);
		
		//출력
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>방문횟수: "+count+"</h1>");
		
	}

}
