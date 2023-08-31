package guestbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
		// 데이터(x) -> 페이징 처리하면서 새로 추가
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		int endNum = pg*3;
		int startNum = endNum-2;
		
		// DB
		GuestbookDAO guestbookDAO = new GuestbookDAO();
		List<GuestbookDTO> list = guestbookDAO.getAllList(startNum, endNum);
		//List<GuestbookDTO> list = guestbookDAO.select();  // ArrayList로 직접 클래스로 받아도 되고, 그 부모인 List로 받아도 된다. 여기선 후자로 선택
		
		// 페이징 처리
		int totalA = guestbookDAO.getTotalA(); // 총게시글수
		int totalP = (totalA-1)/3+1;  // 총페이지수, (총글수-1)/3+1  또는  (총글수+2)/3
		
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		
		out.println("<head>");
		out.println("<style>");
		out.println("#currentPaging { color: 'red'; text-decoration: underline;}");
		out.println("#paging { color: 'black' text-decoration: none; }");
		out.println("</style>");
		out.println("</head>");
		
		out.println("<body>");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		if(list != null) {
			
			//for(int i=0; i<list.size(); i++) {
			for(GuestbookDTO guestbookDTO : list) {
				out.println("<table border='1' cellpadding='5' cellspacing='0' align='center'>");
				out.println("<tr>");
				out.println("<th width='100' align='center'>" + "작성자" + "</td>");
				out.println("<td width='100' align='center'>" + guestbookDTO.getName() + "</td>");
				out.println("<th width='100' align='center'>" + "작성일" + "</td>");
				out.println("<td width='100' align='center'>" + sdf.format(guestbookDTO.getLogtime()) + "</td>");
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
				out.println("<pre>" + guestbookDTO.getContent() + "</pre>");
				out.println("</div>");
				out.println("</td>");
				out.println("</table>");
				out.println("<br><hr witdh='500' color='red' /><br>");
			} // for
			
			// 페이징 처리
			//out.println("<div style='border: 1px blue solid;'>");
			out.println("<div style='border: 1px red solid; width : 500px; align: center; margin:auto;' >");
			for(int i=1; i<=totalP; i++) {
				if(i == pg) // 현재 페이지라면   				 // 현재 페이지임을 스타일로 표시하고 누를시 해당 페이지로 이동하도록 링크처리
					out.println("<a href='/guestbookServlet/GuestbookListServlet?pg=" + i + "' id='currentPaging'>" + i + "</a>"); 
				else
					out.println("<a href='/guestbookServlet/GuestbookListServlet?pg=" + i + "' id='paging'>" + i + "</a>");
			}
			
			out.println("<img src='/guestbookServlet/image/apeach.png' alt='어피치' witdh='50' height='50' " +  // 여긴 자바파일쪽으로 상대번지가 불가능
						"onclick=location.href='/guestbookServlet/guestbook/guestbookWriteForm.html' style='cursor: pointer;'> "); 
		}// if
		
		out.println("</body>");
		out.println("</html>");	
	}
}
