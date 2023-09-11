package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {
	Scanner scan = new Scanner(System.in);
	
	@Override
	public void execute() {
		System.out.println("update 메뉴입니다.");
		System.out.println();
		
		// 데이터 (아이디 조회)
		System.out.print("수정할 아이디 입력 : ");
		String id = scan.next();
		
		// DB
		UserDAO userDAO = new UserDAO(); // 해당 유저가 진짜 있는지 확인
		UserDTO userDTO = userDAO.getUser(id);
		
		// 응답
		if(userDTO == null) {
			System.out.println("아이디가 존재하지 않습니다.");
			System.out.println();
			execute();
		} else {			
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
			
			// 데이터 (수정) - id는 PK값이므로 절대 수정 불가
			System.out.println();
			System.out.print("수정할 이름 입력 : ");
			String name = scan.next();
			System.out.print("수정할 비밀번호 입력 : ");
			String pwd = scan.next();
			
			userDTO.setName(name);
			userDTO.setPwd(pwd);
			
			// DB
			userDAO.update(userDTO);
			
			// 응답
			System.out.println("데이터를 수정하였습니다.");
		}// else
	}
}

/*
※ 조건 : 
수정할 아이디 입력 : angel ==> select * from usertable where id='angel' (getUser())
아이디가 존재하지 않습니다.

수정할 아이디 입력 : hong
홍길동    hong    111

수정할 이름 입력 : 
수정할 비밀번호 입력 : 
	
데이터를 수정하였습니다. ==> update (update());
*/