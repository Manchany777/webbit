package com.calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
//@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 데이터 받기
		int xvalue = Integer.parseInt(request.getParameter("x"));
		int yvalue = Integer.parseInt(request.getParameter("y"));
		double nanugi = (double) xvalue / yvalue;
		String nanugiResult = String.format("%.3f", nanugi);
		
		// 응답
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out = response.getWriter(); // 생성 - new 안써도 response객체의 getWriter()메소드에 의해 생성이 됨
		out.println("<html>");
		out.println("<body>");
		out.println(xvalue + " + " + yvalue + " = " + (xvalue + yvalue) + "<br/><br/>");
		out.println(xvalue + " - " + yvalue + " = " + (xvalue - yvalue) + "<br/><br/>");
		out.println(xvalue + " * " + yvalue + " = " + (xvalue * yvalue) + "<br/><br/>");
		out.println(xvalue + " / " + yvalue + " = " + (nanugiResult) + "<br/><br/>");
		out.println("<br/>");
		out.println("<input type='button' value='뒤로가기' onclick='history.go(-1);' />");
		out.println("</body>");
		out.println("</html>");
	}

}
