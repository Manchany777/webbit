package user.main;

import java.util.Scanner;

public class UserMain {
	Scanner scan = new Scanner(System.in);

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
			
			if(num == 1) {
				insert();
			} else if(num == 2) {
				select();
			} else if(num == 3) {
				update();
			} else if(num == 4) {
				delete();
			} else if(num == 5) {
				search();
			} else if(num == 6)
				break; // while을 벗어나라	
		}
	}
	
	public void insert() {};
	public void select() {};
	public void update() {};
	public void delete() {};
	public void search() {};
	
	
	public static void main(String[] args) {
		UserMain main = new UserMain();
		main.menu();
		System.out.println("프로그램을 종료합니다.");
	}
}
