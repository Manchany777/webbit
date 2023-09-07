package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class LogoutService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("memName"); // 특정 세션만 제거
		session.removeAttribute("memId");
		session.removeAttribute("memEmail");
		
		session.invalidate(); // 모든 세션 무효화
		
		return "/member/logout.jsp";
	}
}
