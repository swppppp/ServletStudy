package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MIMEServlet
 */
public class MIMEServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L; //나중에 메모리에 저장할때 버전

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 응답메세지의 헤더에 컨텐츠유형 설정
		response.setContentType("text/plain; charset=utf-8"); //동적데이터를 만드니까 타입을 알려줘야해. 근데 걍 메시지만 보낼거야 plain text를 브라우저로 보낼거야 (MIME타입/확장자)
		// 응답메세지 헤더에 들어가는 내용: Content-type:text/plain; charset=utf-8
		PrintWriter out = response.getWriter(); //프린트writer 만들어져있음
		out.println("일반 텍스트입니다:)");
		
	}

}
