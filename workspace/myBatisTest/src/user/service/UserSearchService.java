package user.service;

import java.util.List;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {
	Scanner scan = new Scanner(System.in);
	
	@Override
	public void execute() {
		System.out.println();
		System.out.println("search 메뉴입니다.");
		System.out.println();
		
		int num;

		System.out.println();
		System.out.println("==============");
		System.out.println(" 1. 이름 검색");
		System.out.println(" 2. 아이디 검색");
		System.out.println(" 3. 나가기");
		System.out.println("==============\"");
		System.out.print(" 번호 : ");
		num = scan.nextInt();
		
		UserDAO userDAO = new UserDAO(); // 해당 유저가 진짜 있는지 확인

		
		if(num == 1) {
			// 데이터
			System.out.println();
			System.out.print("검색 할 이름 입력 : ");
			String name = scan.next();
			//String id = scan.next();
			
			List<UserDTO> list = userDAO.search(name, null);
			
			for(UserDTO userDTO : list) {
				System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
			}
			System.out.println();
			execute();
		} else if(num == 2) {
			// 데이터
			System.out.println();
			System.out.print("검색 할 아이디 입력 : ");
			String id = scan.next();
			
			List<UserDTO> list = userDAO.search(null, id);
			
			for(UserDTO userDTO : list) {
				System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
			}
			System.out.println();
			execute();
		} else if(num == 3) return;

	}
}

/*
※ 조건 : 
System.out.println();
		
*****************
   1. 이름 검색
   2. 아이디 검색
*****************
  번호 : 1
  
1번인 경우
검색 할 이름 입력 : 홍 (이름에서 홍이 들어간 레코드는 전부 가져온다)

홍길동	hong	111
진분홍	pink	111

2번인 경우
검색 할 아이디 입력 : n (아이디에서 n이 들어간 레코드는 전부 가져온다)

홍길동	hong	111
코난		conan	111

===> 함수는 search() 함수 1개만 작성 (<select id="search"></select>)


참고)
search1, seacrch2 이런식으로 하면 안 된다.
반드시 DB에서 처리하는 함수는 search 하나만 써야 함

xml에서 if문을 쓰던, 쓰지 않던 두 가지 방식이 있다.
*/