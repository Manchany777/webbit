package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardViewService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
	
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
				
		//DB객체 생성
		BoardDAO boardDAO = new BoardDAO();
		BoardDTO boardDTO = boardDAO.boardDetail(seq); // 글 내용은 한사람 거니까 BoardDTO 담아오면 된다.

		/*
		// 페이징 처리 
		BoardPaging boardPaging = new BoardPaging(); // 하나씩 꺼내오기
		boardPaging.setCurrentPage(pg);
		// boardView 페이지에서는 BoardPaging의 currentPage변수에만 값을 담아오는 것이기때문에 makePagingHTML(); 메소드는 쓰이지 않는다.
		// makePagingHTML();메소드는 페이징처리를 위해 구현한 메소드이기때문에 페이지값만 담아올 때에는 쓸 이유가 없는 것이다. 따라서
		// boardPaging.makePagingHTML(); 메소드는 여기서 실행시키면 안 된다. (에러뜸)
		
		//세션에 담기
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		*/
		
		// 응답
		request.setAttribute("boardDTO", boardDTO);  // => 이거 가져오니까 된다??
		request.setAttribute("pg", pg); // 목록 눌렀을 때 제자리고 가게하기 위해
		//request.setAttribute("boardPaging", boardPaging);
		
		return "/board/boardView.jsp";
	}

}
