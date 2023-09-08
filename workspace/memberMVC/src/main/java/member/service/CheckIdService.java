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
		response.setContentType("text/html;charset=UTF-8"); // 한글 처리
		// request.setAttribute("id", id);
		
		if(exist) {	// exist가 true이면 이미 id가 있다는 것
			return "/member/checkIdFail.jsp?id="+id;  // 사용 불가능
		} else {
			return "/member/checkIdOk.jsp";    // 사용 가능
		}
	}
}
