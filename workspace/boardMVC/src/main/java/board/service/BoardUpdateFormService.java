package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardUpdateFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//DB객체 생성
		BoardDAO boardDAO = new BoardDAO();
		BoardDTO boardDTO = boardDAO.boardDetail(seq);
		
		// 페이징 처리 
		BoardPaging boardPaging = new BoardPaging(); // 하나씩 꺼내오기
		boardPaging.setCurrentPage(pg);

		// 세션에 담기 (내장객체를 가지고 있는 JSP와 다르게 세션을 따로 불러들여야 한다.)
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);

		// 세션에 담은 데이터를 한 번에 실어가기 위해
		request.setAttribute("boardDTO", boardDTO);
		request.setAttribute("pg", pg); // 목록 눌렀을 때 제자리고 가게하기 위해
		request.setAttribute("seq", seq);
		
		return "/board/boardUpdateForm.jsp";
	}

}
