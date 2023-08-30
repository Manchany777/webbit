package com.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
//@WebServlet("/param")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 데이터 받기
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		// 응답
		response.setContentType("text/html;charset=UTF-8"); // 이제부터 쓰는 모든 response를 html태그로 인식해주세요 라는 명령어
															// charset=UTF=8 은 한글인식을 위해 쓰는 명령어 (이 선언을 먼저하고 IO 생성해야 한글이 안깨짐)
		PrintWriter out = response.getWriter(); // 생성 - new 안써도 response객체의 getWriter()메소드에 의해 생성이 됨
		out.println("<html>");
		out.println("<body>");
		out.println("나의 이름은 " + name + " 이고, 내 나이는 " + age + "살 이므로 ");
		if(age>19) out.println("<span style='color: blue; font-weight: bold; font-size: 20;'>성인</span> 입니다" + "<br/>");
		else out.println("<span style='color: red; font-weight: bold; font-size: 20;'>청소년</span> 입니다" + "<br/>");
		out.println("<br/>");
		//out.println("<input type='button' value='뒤로가기' onclick='javascript:history.back();' />"); 
													  // onclick='history.back();  => javascript 삭제해도 무방
		out.println("<input type='button' value='뒤로가기' onclick=location.href='/testServlet/param/param.html'; />"); 
		out.println("</body>");						  // history대신 location 객체를 써도 된다.
		out.println("</html>");						  // history.back() - 데이터 값 유지, location.href= - 새로고침 효과
	}

}
