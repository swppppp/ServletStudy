package kr.or.kosta.servlet;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ppt문서 서비스->다운로드
 */
public class MIMEFileDownPractice extends HttpServlet {
	private static final long serialVersionUID = 1L; //나중에 메모리에 저장할때 버전

	
	private static final String path = "C:\\kosta187\\workspace\\servletStudy\\WebContent\\assets\\";
	
//	private String file = "music.mp3"; //서비스할 음악파일명
	private String file = "ams_박시원.jar"; //서비스할 jar 파일명
	File downfile = new File(path+file);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 응답메세지의 헤더에 컨텐츠유형 설정
		response.setContentType("application/jar");  // 바이너리이니까 byte스트림으로
		
		// 바이트입력스트림 생성
	    InputStream in = new FileInputStream(path + file);
	    
	    // response가 제공하는 바이트입력스트림 취득
	    OutputStream out = response.getOutputStream();
	    byte[] buffer = new byte[1024];
	    int count = 0;
	    try{
	    	//Setting Resqponse Header

//	        response.setContentType("application/octet-stream");

	        response.setHeader("Content-Disposition",                     

	                           "attachment;filename=\""+downfile.getName()+"\"");



	         while( (count = in.read(buffer)) != -1){
	              out.write(buffer, 0, count);
	         }

	    }finally{
	         if(out != null) out.close();
	         if(in != null) in.close();
	    }

		
	}

}
