package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;

import com.sun.org.apache.xml.internal.security.Init;
import com.sun.prism.Texture.Usage;

import kr.or.kosta.servlet.dao.User;
import kr.or.kosta.servlet.dao.jdbcUserDao;

/**
 * Servlet implementation class HttpResponseServlet
 */
public class DatabaseServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	jdbcUserDao dao;
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "hr";
	private static final String password = "hr";
	
	@Override
	public void init() throws ServletException {
		dao = new jdbcUserDao();
		BasicDataSource dataSource = new BasicDataSource();  
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(5);
		dataSource.setMaxIdle(7); //최대치까지 올라갔다가 7로떨어짐
		dataSource.setMaxTotal(10); //최대만들어지는갯수
		
		dao.setDataSource(dataSource);
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		List<User> list=null;
		try {
			list = dao.listAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); //프린트writer 만들어져있음
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style='font-size:20pt'>");
		
		out.println("<table border='1' width='50%'>");

		for (User user : list) {
			System.out.println(user);
		}
		
		out.println("</table>");
	    out.println("</body>");
		out.println("</html>");
		
	}


}
