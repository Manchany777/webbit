package com.dbtest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.DBTestDTO;
import com.dao.DBTestDAO;

/**
 * Servlet implementation class DBTestServlet
 */
@WebServlet("/DBTestServlet")
public class DBTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터
		String name = request.getParameter("name"); // age가지고 계산할 거 아니니까 그냥 다 String으로 받는다.
		String age = request.getParameter("age");
		String height = request.getParameter("height");
		
		DBTestDTO dBTestDTO = new DBTestDTO();
		dBTestDTO.setName(name);
		dBTestDTO.setAge(age);
		dBTestDTO.setHeight(height);  // DB컬럼 모두 한꺼번에 싣기 완료
		
		// DB
		DBTestDAO dBTestDao = new DBTestDAO();
		
		// 응답
		
	}
}
