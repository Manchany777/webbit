package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class LogoutService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		// 쿠키 삭제 (특정 쿠키만 못지우기때문에 모든 쿠키를 다 잡아와야함)
		/*
		Cookie[] ar = request.getCookies();
		if(ar != null) {
			for(int i=0; i < ar.length; i++) {
				if(ar[i].getName().equals("memName")) {
					ar[i].setMaxAge(0); // 쿠키 삭제 (시간 0초로)
					response.addCookie(ar[i]); // 클라이언트에 저장(보내기)
				}
				if(ar[i].getValue().equals("memId")) {
					ar[i].setMaxAge(0); // 쿠키 삭제 (시간 0초로)
					response.addCookie(ar[i]); // 클라이언트에 저장(보내기)
				}
				
			}//for
		}//if
		*/

		// 세션
		HttpSession session = request.getSession();
		session.removeAttribute("memName"); // 특정 세션만 제거
		session.removeAttribute("memId");
		session.removeAttribute("memEmail");
		
		session.invalidate(); // 모든 세션 한 번에 무효화 (remove와 invalidate 둘 중에 하나만 쓰면 된다.)
		
		return "/member/logout.jsp";
	}
}
