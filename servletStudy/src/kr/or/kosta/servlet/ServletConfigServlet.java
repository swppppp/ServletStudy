package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

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
public class ServletConfigServlet extends HttpServlet /*implements Servlet*/ {
	
	String driver;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//설정파일 지정을 위해 ServletConfig를 매개변수로하는 init메소드 사용
		driver = config.getInitParameter("driver");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("컨피그 driver이름: "+driver);
		
	}

}
