package kr.or.kosta.servlet.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;

public class UserDaoTest {

	//jdbc연동에 필요한 값들 상수처리(private로 노출 안되게)
		private static final String driver = "oracle.jdbc.OracleDriver";
		private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		private static final String username = "hr";
		private static final String password = "hr";
	
	public static void main(String[] args) {
		
		jdbcUserDao dao = new jdbcUserDao();
		
		BasicDataSource dataSource = new BasicDataSource();  
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(5);
		dataSource.setMaxIdle(7); //최대치까지 올라갔다가 7로떨어짐
		dataSource.setMaxTotal(10); //최대만들어지는갯수
		
		dao.setDataSource(dataSource);
		

		try {
			System.out.println("전체목록 출력");
			List<User> list = dao.listAll();
			for (User user : list) {
				System.out.println(user);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			SQLException sqlEx = (SQLException)e;
			System.out.println(sqlEx.getErrorCode());
		}
		
		
		
	}

}
