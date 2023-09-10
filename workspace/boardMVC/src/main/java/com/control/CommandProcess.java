package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
	
	public abstract String requestPro(HttpServletRequest request, HttpServletResponse response); // 추상메소드 (인터페이스는 abstract 생략가능)
	// 반드시 String타입으로 넘겨줘야 jsp파일로 포워딩이 가능하다.
}