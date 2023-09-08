package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;


public class LoginService implements CommandProcess {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// DB
		MemberDAO memberDAO = new MemberDAO();
		//String name = memberDAO.login(id, pwd); // 아래도 name대신 전부 memberDTO로 수정
		MemberDTO memberDTO = memberDAO.login(id, pwd);
		
		// 응답
		if(memberDTO == null) {   // login.jsp의 <% if(memberDTO == null) { response.sendRedirect("loginFail.jsp"); ~~에 해당
			return "/member/loginFail.jsp";
		} else {
			// 세션(jsp와는 달리 자바니까 세션이 필요)
			HttpSession session = request.getSession();
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", id);	
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
			
			return "/member/loginOk.jsp";
		}
	}
}
