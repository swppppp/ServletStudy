package kr.or.kosta.servlet.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 박시원
 */
public interface UserDao {
	
	/** crud */
	public void create(User user) throws Exception;
	public User read(String id) throws Exception;
	public void update(User user) throws Exception;
	public void delete(String id) throws Exception;
	
	public List<User> listAll() throws Exception;
	/** 로그인 */
	public User certify(String id, String passwd) throws Exception;
	
	/** 사원정보에 포함된 컬럼데이터
	 * 사원번호, last_name, salary, dept_name, 도시명*/
	public List<Map<String, String>> employeeList() throws Exception;
	
}
