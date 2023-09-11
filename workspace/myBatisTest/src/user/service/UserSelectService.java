package user.service;

import java.util.List;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSelectService implements UserService {

	@Override
	public void execute() {
		System.out.println("select 메뉴입니다.");
		System.out.println();
		
		// DB
		UserDAO userDAO = new UserDAO();
		List<UserDTO> list = userDAO.getUserList();
		// 한 줄에 한 명의 회원분의 정보가 저장 -> 모든 행의 정보를 저장하려면 List에 담아야 한다.
		
		// 응답
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
		}//for
	}
}
