package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class LoginOkService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		//세션
		String name = (String)session.getAttribute("memName");
		// String    <= 캐스팅 필요 =>        Object
		String id = (String)session.getAttribute("memId");
		String email1 = (String)session.getAttribute("memEmail");

		return null;
	}

}
