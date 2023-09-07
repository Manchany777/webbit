package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		String id = request.getParameter("id");

		// DB
		MemberDAO memberDAO = new MemberDAO();
		boolean exist =  memberDAO.isExistId(id); // isExistId - 메소드 이름

		// 응답
		response.setContentType("text/html;charset=UTF-8");

		if(exist) {
			return "/member/checkIdFail.jsp";
		} else {
			return "/member/checkIdOk.jsp";
		}
	}
}
