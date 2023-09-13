package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardUpdateService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		// 데이터
        int seq = Integer.parseInt(request.getParameter("seq"));
        int pg = Integer.parseInt(request.getParameter("pg"));
        System.out.println(seq);
        System.out.println(pg);
        
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		// 세션에 담기 (내장객체를 가지고 있는 JSP와 다르게 세션을 따로 불러들여야 한다.)
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");

		// 세션에 담은 데이터를 한 번에 실어가기 위해
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
		map.put("id", id);  // 오른쪽에 있는 id값을 왼쪽의 "id"란 이름으로 부여한다.
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);
		
		//DB객체 생성
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.boardModify(map);  // DB에 Map들고 insert(저장)
		
		//응답
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
				
		return "/board/boardUpdate.jsp";
	}

}
