package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardDeleteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		System.out.println(seq);
		System.out.println(pg);
		
		//DB객체 생성
		BoardDAO boardDAO = new BoardDAO();
		BoardDTO boardDTO = boardDAO.boardDetail(seq); // 글 내용은 한사람 거니까 BoardDTO 담아오면 된다.

		
		// 페이징 처리 
		BoardPaging boardPaging = new BoardPaging(); // 하나씩 꺼내오기
		boardPaging.setCurrentPage(pg);
		
		//세션에 담기
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		
		// DB
		boardDAO.boardDelete(seq);
		
		
		// 응답
		request.setAttribute("boardDTO", boardDTO);
		request.setAttribute("pg", pg); // 목록 눌렀을 때 제자리로 가게하기 위해
		//request.setAttribute("seq", seq);
		
		return "/board/boardDelete.jsp";
	}

}
