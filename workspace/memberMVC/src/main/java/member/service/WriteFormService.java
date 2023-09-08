package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class WriteFormService implements CommandProcess{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		return "/member/writeForm.jsp";  // 상대번지만 가능 why? 서블릿에서 그걸 원하기 때문에
		 								 // "/memberMVC/member/writeForm.jsp" (x) -> 이것도 절대번지
	}
}
