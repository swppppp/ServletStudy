package kr.or.kosta.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

public class jdbcUserDao implements UserDao {

	//use a 관계..!-->커넥션을 생성해주는 팩토리역할
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(User user) throws Exception {
		//create, sql에서 insert에 필요한 객체들 미리 선언
		//(결과 없으므로, connection, preparedStatement만 필요)
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO users \r\n" + 
					 "VALUES     (?, \r\n" + 
					 "            ?, \r\n" + 
					 "            ?, \r\n" + 
					 "            ?, \r\n" + 
					 "            SYSDATE)";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			
			//바인딩변수에 값을 할당
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPasswd());
			pstmt.setString(4, user.getEmail());
			//쿼리날려!!
			pstmt.executeUpdate(); 
		
			//열린거 닫아줘
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close(); //아파치에서 만든 dbcp사용하면 오버라이딩된 close사용 가능!
//				if(con != null) UserConnectionPool.getInstance().releaseConnection(con); //사용자정의 connectionPool 사용하고 반납할때 구현한 반납메소드 호출
			}catch (Exception e) {}
		}
	}

	@Override
	public User read(String id) throws Exception {
		//read, sql에서 select에 필요한 객체들 생성
		//반환할 user객체, connection객체, preparedStatement객체, ResultSet객체
		
		User user = null;	

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT id, \r\n" + 
				"       name, \r\n" + 
				"       passwd, \r\n" + 
				"       email, \r\n" + 
				"       TO_CHAR(regdate, 'yyyy-mm-dd') regdate \r\n" + 
				"FROM   users \r\n" + 
				"WHERE  id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			//sql에 바인딩변수 값 할당 후
			pstmt.setString(1, id);
			//쿼리실행해서 반환값 받기
			rs =pstmt.executeQuery();
			//반환값이 있으면 위에선언한 user객체에 값을 담아
			if(rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setEmail(rs.getString("email"));
				user.setRegdate(rs.getString("regdate"));
			}
			//열어준거 닫아주기
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch (Exception e) {}
		}
			return user;
		
	}

	@Override
	public void update(User user) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE users \r\n" + 
					 "SET    name = ?, \r\n" + 
					 "       passwd = ?, \r\n" + 
					 "       email = ?, \r\n" + 
					 "       regdate = TO_DATE(?, 'yyyy-mm-dd') \r\n" + 
					 "WHERE  id = ?";
		String id = user.getId();
		String name = user.getName();
		String passwd = user.getPasswd();
		String email = user.getEmail();
		String regdate = user.getRegdate();
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			
			//바인딩변수처리
			pstmt.setString(1, name);
			pstmt.setString(2, passwd);
			pstmt.setString(3, email);
			pstmt.setString(4, regdate);
			pstmt.setString(5, id);
			
			int resultCnt = pstmt.executeUpdate();
			if(resultCnt!=0)
				System.out.println(resultCnt+"행이 수정 되었습니다.");
			else System.out.println("id값을 확인해 주세요.");
			
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {}
		}
	}

	@Override
	public void delete(String id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM users \r\n" + 
					 "WHERE  id = ?";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			
			//바인딩변수 처리
			pstmt.setString(1, id);
			int resultCnt = pstmt.executeUpdate();
			if(resultCnt!=0)
				System.out.println(resultCnt+"행이 삭제 되었습니다.");
			else System.out.println("id값을 확인해 주세요.");
			
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {}
		}
				

	}

	@Override
	public List<User> listAll() throws Exception {
		List<User> list = null;
		User user = new User();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT id, \r\n" + 
					 "       name, \r\n" + 
					 "       passwd, \r\n" + 
					 "       email, \r\n" + 
					 "       TO_CHAR(regdate, 'yyyy\"년\"mm\"월\"dd\"일\"') regdate \r\n" + 
					 "FROM   users";
		
		try {
			list = new ArrayList<User>();
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setEmail(rs.getString("email"));
				user.setRegdate(rs.getString("regdate"));
				
				list.add(user);
			}
			
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch (Exception e) {}
		}
		
		return list;
	}

	@Override
	public User certify(String id, String passwd) throws Exception {
		// TODO Auto-generated method stub -->read랑똑같아
		return null;
	}

	@Override
	//사원, 부서, 지역테이블 조인해서 --->테이블 여러개 조인, 맵써서!
	public List<Map<String, String>> employeeList() throws Exception {
		List<Map<String, String>> list = null;
		//sql에 left outer join사용..
		//resultSetMetaData사용
		//동적으로 컬럼이름을 해쉬맵의 키값으로 지정해주기 위해
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT e.employee_id     eid, \r\n" + 
				"       e.last_name       ename, \r\n" + 
				"       e.salary          salary, \r\n" + 
				"       d.department_name dname, \r\n" + 
				"       l.city            city, \r\n" + 
				"       e2.last_name      mname \r\n" + 
				"FROM   employees e \r\n" + 
				"       left outer join departments d \r\n" + 
				"                    ON e.department_id = d.department_id \r\n" + 
				"       left outer join locations l \r\n" + 
				"                    ON d.location_id = l.location_id \r\n" + 
				"       left outer join employees e2 \r\n" + 
				"                    ON e.manager_id = e2.employee_id \r\n" + 
				"ORDER  BY eid";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Map<String, String>>();
			ResultSetMetaData rsm = rs.getMetaData();
			int colCnt = rsm.getColumnCount();
			while (rs.next()) {
				Map<String, String> row = new HashMap<String, String>();
				for(int i=0; i<colCnt; i++) {
					String colName = rsm.getColumnLabel(i+1);
					String colValue = rs.getString(i+1);
					row.put(colName, colValue);
				}
				list.add(row);
			}
			
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {}
		}
		
		return list;
	}

	
	
}
