package guestbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

/**
 * Servlet implementation class GuestbookWriteServlet
 */
@WebServlet("/GuestbookWriteServlet")
public class GuestbookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 데이터
		String name = request.getParameter("name"); 	// age가지고 계산할 거 아니니까 그냥 다 String으로 받는다.
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		GuestbookDTO guestbookDTO = new GuestbookDTO();
		guestbookDTO.setName(name);
		guestbookDTO.setEmail(email);
		guestbookDTO.setHomepage(homepage);
		guestbookDTO.setSubject(subject);
		guestbookDTO.setContent(content);  // DB컬럼 모두 한꺼번에 싣기 완료
		
		// DB
		GuestbookDAO guestbookDAO = new GuestbookDAO();
		int su = guestbookDAO.insert(guestbookDTO);
		
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		if(su == 1) {
			out.println("<h3>작성하신 글을 등록하였습니다.</h3>");
			out.println("<br/><br/>");
			out.println("5초후 목록 페이지로 자동으로 이동합니다....");
			out.println("<br/><br/>");
			out.println("<input type='button' value='글목록' onclick=location.href='/guestbookServlet/GuestbookListServlet'; />");
		} 
		
		out.println("</body>");
		out.println("</html>");
		//response.sendRedirect("GuestbookListServlet");
		response.addHeader("Refresh", "5;url=GuestbookListServlet");

	}
}
