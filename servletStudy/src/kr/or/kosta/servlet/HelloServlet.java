package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

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
public class HelloServlet extends HttpServlet /*implements Servlet*/ {
	// thread의 runnable과 같이...servlet interface구현
	// 콜백메소드
	@Override
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
		// servletContext 가져오기
		out.println("<h2>공유데이터 "+getServletContext().getAttribute("shareValue")+"입니다.</h2>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}
