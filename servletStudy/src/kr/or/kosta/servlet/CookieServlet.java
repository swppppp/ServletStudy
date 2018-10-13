package kr.or.kosta.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id = "bangry";
		String id = "방그리";
		id = URLEncoder.encode(id, "utf-8");
		Cookie cookie = new Cookie("loginId", id);
		cookie.setMaxAge(60*60*24*30); //초단위..이건 한달/ 안쓰면 브라우저도는동안만
//		cookie.setDomain("http://naver.com");
//		cookie.setPath("/"); //어플리케이션위치..
//		response.setHeader("Set-Cookie", "................");
		response.addCookie(cookie);
		
		response.sendRedirect("hello2.do");
		
		
	}

}
