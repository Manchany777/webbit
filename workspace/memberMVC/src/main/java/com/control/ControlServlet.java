package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터
		
		//DB
		
		// 한글처리 - post방식일때만 한글이 깨지므로 post방식에서만 처리하도록 설정 
		// (여기서의 getMethod는 함수가 아니라 jsp에서 form 태그의 method를 말한다 주의)
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}
	}
}
