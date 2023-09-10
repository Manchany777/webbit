package board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		// 데이터 (for 페이징) - 파라미터를 통해서(=목록에서) 접근해야 하기때문에 이 파일을 바로 실행하면 에러 발생
		int pg = Integer.parseInt(request.getParameter("pg"));

		// 1페이지당 5개씩 글이 오도록 처리 (for 페이징 처리)
		int endNum = pg*5;
		int startNum = endNum-4;

				
		//DB객체 생성
		BoardDAO boardDAO = new BoardDAO();
		List<BoardDTO> list = boardDAO.getBoardList(startNum, endNum);

		// 페이징 처리
		int totalA = boardDAO.getTotalA(); // 총 글수

		BoardPaging boardPaging = new BoardPaging(); // 하나씩 꺼내오기
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);

		boardPaging.makePagingHTML(); // 메소드 호출
		
		// 세션(에 담기)
		HttpSession session = request.getSession(); // 세션생성
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		// 응답
		request.setAttribute("pg", pg);
		request.setAttribute("list", list);
		request.setAttribute("boardPaging", boardPaging);
		
		return "/board/BoardList.jsp";
	}

}
