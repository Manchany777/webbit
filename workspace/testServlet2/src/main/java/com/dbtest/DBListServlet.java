package com.dbtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DBTestDAO;
import com.bean.DBTestDTO;

/**
 * Servlet implementation class DBListServlet
 */
@WebServlet("/DBListServlet")
public class DBListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터(x)
		
		// DB
		DBTestDAO dBTestDAO = new DBTestDAO();
		List<DBTestDTO> list = dBTestDAO.select();  // ArrayList로 직접 클래스로 받아도 되고, 그 부모인 List로 받아도 된다. 여기선 후자로 선택
		
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		if(list != null) {
			
			out.println("<table border='1'>");
			
			//for(int i=0; i<list.size(); i++) {
			for(DBTestDTO dBTestDTO : list) {
				out.println("<tr>");
				out.println("<td width='100' align='center'>" + dBTestDTO.getName() + "</td>");
				out.println("<td width='50' align='center'>" + dBTestDTO.getAge() + "</td>");
				out.println("<td width='100' align='center'>" + dBTestDTO.getHeight() + "</td>");
				out.println("<td width='200' align='center'>" + dBTestDTO.getLogtime() + "</td>");
				out.println("</tr>");
			} // for
			
			out.println("</table>");
			out.println("<img src='/testServlet2/image/apeach.png' alt='어피치' witdh='50' height='50' " +  // 여긴 자바파일쪽으로 상대번지가 불가능
						"onclick=location.href='/testServlet2/exam/input.html' style='cursor: pointer;'> "); 
		}// if
		
		out.println("</body>");
		out.println("</html>");
	}

}
