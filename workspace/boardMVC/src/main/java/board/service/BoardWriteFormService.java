package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardWriteFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		String id = request.getParameter("id");

		// DB
		BoardDAO boardDAO = new BoardDAO();

		// 응답
		response.setContentType("text/html;charset=UTF-8");
		return "/board/boardWriteForm.jsp";
	}

}
