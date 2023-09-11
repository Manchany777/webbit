package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {
	Scanner scan = new Scanner(System.in);
	
	@Override
	public void execute() {
		System.out.println("delete 메뉴입니다.");
		System.out.println();
		
		// 데이터 (아이디 조회)
		System.out.print("삭제할 아이디 입력 : ");
		String id = scan.next();
		
		// DB
		UserDAO userDAO = new UserDAO(); // 해당 유저가 진짜 있는지 확인
		UserDTO userDTO = userDAO.getUser(id);
		
		// 응답
		if(userDTO == null) {
			System.out.println("아이디가 존재하지 않습니다.");
			System.out.println();
			return; // 메소드 타입이 void이기 때문에 return;을 쓰면 그대로 빠져나가게 만듦
		} else {			
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
			
			// 데이터 (수정) - id는 PK값이므로 절대 수정 불가
			System.out.println();
			System.out.print("정말 데이터를 삭제하시겠습니까? yes or no : ");
			String confirm = scan.next();
			
			if (confirm.equals("no")) System.out.println("삭제 취소");
			else {
				
				// DB
				userDAO.delete(id); // DTO 다 들고 갈 필요없이 id 하나만 가져가도 된다. (delete문의 조건절에 필요한 건 id 하나뿐이니까)
				
				// 응답
				System.out.println("데이터를 삭제하였습니다.");
			} // confirm if
		}// else

	}
}
/*
※ 조건 : 
삭제할 아이디 입력 : angel
아이디가 존재하지 않습니다.

삭제할 아이디 입력 : hong
데이터를 삭제하였습니다
*/