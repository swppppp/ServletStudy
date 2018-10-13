package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountServlet
 */
public class Quiz extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      // 요청인코딩 지정, 응답보낼 자료타입및 인코딩 지정
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html; charset=utf-8");
      // 응답보낼 스트림 가져옴
      PrintWriter out = response.getWriter();
      
      /////////////////쿠키에 필요 값 저장////////////////
      //쿠키에 저장할 사용자 아이디 비번 
      String userid = request.getParameter("userid");
      String userpw = request.getParameter("userpw");
      // 지금은 아이디만 필요함(db연동 및 아이디비번 비교과정 없음)
      // 쿠키에 아이디값 저장
      Cookie cookie = new Cookie("userid", userid);
      response.addCookie(cookie);
      
      out.print("<!DOCTYPE html>\r\n" + 
            "<html>\r\n" + 
            "<head>\r\n" + 
            "<meta charset=\"utf-8\">\r\n" +
            "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/basic.css\">\r\n" + 
            "</head>\r\n" + 
            "<body>\r\n" + 
            "\r\n" + 
            "<div class=\"header\">\r\n" + 
            "  <h1>My Website</h1>\r\n" + 
            "  <p>Resize the browser window to see the effect.</p>\r\n" + 
            "</div>\r\n" + 
            "\r\n" + 
            "<div class=\"topnav\">\r\n" + 
            "  <a href=\"#\">Link</a>\r\n" + 
            "  <a href=\"#\">Link</a>\r\n" + 
            "  <a href=\"#\">Link</a>\r\n" + 
            "  <a href=\"#\" style=\"float:right\">Link</a>\r\n" + 
            "</div>\r\n" + 
            "\r\n" + 
            "<div class=\"row\">\r\n" + 
            "  <div class=\"leftcolumn\">\r\n" + 
            "    <div class=\"card\">\r\n" + 
            "      <h2>TITLE HEADING</h2>\r\n" + 
            "      <h5>Title description, Dec 7, 2017</h5>\r\n" + 
            "      <div class=\"fakeimg\" style=\"height:200px;\">Image</div>\r\n" + 
            "      <p>Some text..</p>\r\n" + 
            "      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>\r\n" + 
            "    </div>\r\n" + 
            "    <div class=\"card\">\r\n" + 
            "      <h2>TITLE HEADING</h2>\r\n" + 
            "      <h5>Title description, Sep 2, 2017</h5>\r\n" + 
            "      <div class=\"fakeimg\" style=\"height:200px;\">Image</div>\r\n" + 
            "      <p>Some text..</p>\r\n" + 
            "      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>\r\n" + 
            "    </div>\r\n" + 
            "  </div>\r\n" + 
            "  \r\n" + 
            "  <div class=\"rightcolumn\">\r\n" + 
            "    <div class=\"card\">\r\n" + 
            "      <div>\r\n" + 
            "        <form action=\"index.html\">\r\n" + 
            "			<label>" + cookie.getValue() + "</label>\r\n" +
            "          <input type=\"submit\" value=\"Logout\">\r\n" + 
            "        </form>\r\n" + 
            "      </div>\r\n" + 
            "      \r\n" + 
            "    </div>\r\n" + 
            "    \r\n" + 
            "    <div class=\"card\">\r\n" + 
            "      <h3>Popular Post</h3>\r\n" + 
            "      <div class=\"fakeimg\"><p>Image</p></div>\r\n" + 
            "      <div class=\"fakeimg\"><p>Image</p></div>\r\n" + 
            "      <div class=\"fakeimg\"><p>Image</p></div>\r\n" + 
            "    </div>\r\n" + 
            "    <div class=\"card\">\r\n" + 
            "      <h3>Follow Me</h3>\r\n" + 
            "      <p>Some text..</p>\r\n" + 
            "    </div>\r\n" + 
            "  </div>\r\n" + 
            "</div>\r\n" + 
            "\r\n" + 
            "<div class=\"footer\">\r\n" + 
            "  <h2>Footer</h2>\r\n" + 
            "</div>\r\n" + 
            "\r\n" + 
            "<h1>응답페이지입니다.</h1>\r\n" +
            "</body>\r\n" + 
            "</html>\r\n" 
            );

//      Cookie[] cookies = request.getCookies();
//      if(cookies == null) {
//         
//      }
      
      
      
//      // 쿠키사용, 브라우저의 방문 수 출력
//      int count = 0;
//      
//      Cookie[] cookies = request.getCookies();
//      if(cookies != null) {
//         for (Cookie cookie : cookies) {
//            if(cookie.getName().equals(("count"))) {
//               count = Integer.parseInt(cookie.getValue());
//            }
//         }
//      }
//      count++;
//      
//      Cookie cookie = new Cookie("count", String.valueOf(count));
//      cookie.setMaxAge(60*60*24*30); //초단위..이건 한달/ 안쓰면 브라우저도는동안만
//      response.addCookie(cookie);
//      
//      //출력
//      response.setContentType("text/html; charset=utf-8");
//      PrintWriter out = response.getWriter();
//      
//      out.println("<h1>방문횟수: "+count+"</h1>");
      
   }

}