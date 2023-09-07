package com.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
			urlPatterns = {"*.do"},
			initParams = {
					@WebInitParam(name="propertyConfig", value="command.properties")
			}
		)
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> map = new HashMap<String, Object>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String propertyConfig = config.getInitParameter("propertyConfig");
		System.out.println("propertyConfig = " + propertyConfig);
		
		// 만약에 web.xml로 설정하면 아래의 3줄이 필요없다.-----------
		String realFolder = config.getServletContext().getRealPath("/WEB-INF");
		String realPath = realFolder + "/" + propertyConfig;
		System.out.println("realPath = " + realPath);
		//------------------------------------------------
		
		FileInputStream fin = null;
		Properties properties = new Properties();
		
		try {
			// 만약에 web.xml로 설정하면 fin = new FileInputStream(propertyConfig);
			fin = new FileInputStream(realPath);
	                  
	         properties.load(fin);
	         System.out.println("properties = "+properties);
	         
	      } catch (IOException e) {
	         e.printStackTrace();
	      }finally{
	         try {
	            fin.close();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	      }
	      System.out.println();
	      
	      Iterator it = properties.keySet().iterator();
	      while(it.hasNext()) {
	    	 
	         String key = (String)it.next();
	         System.out.println("key = "+key);
	         
	         String className = properties.getProperty(key);
	         System.out.println("className = "+className);
	         
	         try {
	            Class<?> classType = Class.forName(className);
	            Object ob = classType.newInstance();
	            
	            System.out.println("ob = "+ob);
	            
		        // key -> /member/writeForm.do
		        // value -> member.service.WriteFormService
	            //          클래스는 여러가지 클래스가 올 수 있으므로 그 부모격인 Object로 받는 것
	            map.put(key, ob);
	            
	         } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	         } catch (InstantiationException e) {
	            e.printStackTrace();
	         } catch (IllegalAccessException e) {
	            e.printStackTrace();
	         } catch (IllegalArgumentException e) {
	            e.printStackTrace();
	         } 
	         
	         System.out.println();
	      }//while
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터
		
		//DB
		
		// 한글처리 - post방식일때만 한글이 깨지므로 post방식에서만 처리하도록 설정 
		// (여기서의 getMethod는 함수가 아니라 jsp에서 form 태그의 method를 말한다 주의)
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}//if
		
		//요청이 들어왔을 때 => http://localhost:8080/memberMVC/member/writeForm.do
		String category = request.getServletPath(); // 프로젝트명 뒤에있는 찌꺼기들(/member/writeForm.do)
			// 뒷부분을 굳이 자르는 이유? properties의 key값과 비교하기 위해 
		System.out.println("category = "+category); // 결과가 /member/writeForm.do 나온다.
		
		CommandProcess com = (CommandProcess)map.get(category); //member.service.WriteFormService
		String view = null; 	// => key값 비교후 Map안에 들어있는 내용과 비교해서 똑같은 자바 파일을 얻어온다. 
		
		try {
			view = com.requestPro(request, response); // 리턴값 "/member/writeForm.jsp" 받아옴
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		//forward
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);//가져온 상대번지를 가지고
		dispatcher.forward(request, response);//포워드(제어권 넘기기) 시킴
	}
}