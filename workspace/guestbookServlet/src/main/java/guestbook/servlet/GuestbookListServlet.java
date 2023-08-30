package guestbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

/**
 * Servlet implementation class GuestbookListServlet
 */
@WebServlet("/GuestbookListServlet")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터(x)
		
		// DB
		GuestbookDAO guestbookDAO = new GuestbookDAO();
		List<GuestbookDTO> list = guestbookDAO.select();  // ArrayList로 직접 클래스로 받아도 되고, 그 부모인 List로 받아도 된다. 여기선 후자로 선택
		
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		if(list != null) {
			
			//for(int i=0; i<list.size(); i++) {
			for(GuestbookDTO guestbookDTO : list) {
				out.println("<table border='1' cellpadding='5' cellspacing='0'>");
				out.println("<tr>");
				out.println("<th width='100' align='center'>" + "작성자" + "</td>");
				out.println("<td width='100' align='center'>" + guestbookDTO.getName() + "</td>");
				out.println("<th width='100' align='center'>" + "작성일" + "</td>");
				out.println("<td width='100' align='center'>" + guestbookDTO.getLogtime() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th width='100' align='center'>" + "이메일" + "</td>");
				out.println("<td colspan='3'>" + guestbookDTO.getEmail() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th width='100' align='center'>" + "홈페이지" + "</td>");
				out.println("<td colspan='3'>" + guestbookDTO.getHomepage() + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th width='100' align='center'>" + "제목" + "</td>");
				out.println("<td colspan='3'>" + guestbookDTO.getSubject() + "</td>");
				out.println("</tr>");
				out.println("<td colspan='4'>"); 
				out.println("<div style='width: 500px; height: 200px; overflow: auto;'>"); 
				out.println(guestbookDTO.getContent());
				out.println("</div>");
				out.println("</td>");
				out.println("</table>");
				out.println("<br><hr/><br>");
			} // for
			
			out.println("<img src='/guestbookServlet/image/apeach.png' alt='어피치' witdh='50' height='50' " +  // 여긴 자바파일쪽으로 상대번지가 불가능
						"onclick=location.href='/guestbookServlet/guestbook/guestbookWriteForm.html' style='cursor: pointer;'> "); 
		}// if
		
		out.println("</body>");
		out.println("</html>");	
	}
}
