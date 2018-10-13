package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿 생명주기 테스트
 */
public class LifecyleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int count;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifecyleServlet() {
    	System.out.println("LifecyleServlet() called!!!");
    	// 생성자 최초 1회 생성... singleton Pattern
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// 서블릿 초기화작업, 최초1회 실행
		System.out.println("init(config) called!!!!");
		super.init(config);
		// 리소스 초기화...
		count = 0;
	}
	
	@Override
	public void init() throws ServletException {
		// 매개변수 없는 init함수
		System.out.println("init함수 호출(config)없어");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy() called");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		count ++;
		System.out.println("service() called");
		super.service(request, response);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet called");
		// 응답메세지의 헤더에 컨텐츠유형 설정
		System.out.println(request);
		System.out.println(response);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); //프린트writer 만들어져있음
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>오늘은 "+count+"입니다.</h2>");
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost called"); //얜 호출 안될둣
	}

}
