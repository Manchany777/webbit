package user.main;

import java.util.Scanner;

import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSearchService;
import user.service.UserSelectService;
import user.service.UserService;
import user.service.UserUpdateService;

public class UserMain {
	Scanner scan = new Scanner(System.in);
	UserService userService = null;  // 각 클래스 호출시 부모 인터페이스를 참조하는 형태로 만듦
	
	public void menu() {
		int num;

		while(true) {
			System.out.println();
			System.out.println("************");
			System.out.println(" 1. 등록");
			System.out.println(" 2. 출력");
			System.out.println(" 3. 수정");
			System.out.println(" 4. 삭제");
			System.out.println(" 5. 검색");
			System.out.println(" 6. 끝");
			System.out.println("************");
			System.out.println(" 번호 : ");
			num = scan.nextInt();
			
			if(num == 1) insert();
			else if(num == 2) select();
			else if(num == 3) update();
			else if(num == 4) delete();
			else if(num == 5) search();
			else if(num == 6) break;
		}
	}
	
	public void insert() {
		userService = new UserInsertService();
		userService.execute();
	};
	public void select() {
		userService = new UserSelectService();
		userService.execute();
	};
	public void update() {
		userService = new UserUpdateService();
		userService.execute();
	};
	public void delete() {
		userService = new UserDeleteService();
		userService.execute();
	};
	public void search() {
		userService = new UserSearchService();
		userService.execute();
	};
	
	
	public static void main(String[] args) {
		UserMain usermain = new UserMain();
		usermain.menu();
		System.out.println("프로그램을 종료합니다.");
	}
}
