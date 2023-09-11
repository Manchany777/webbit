package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private SqlSessionFactory sqlSessionFactory; // mybatis-config.xml 연결을 위한 SqlSession 설정
	
	public UserDAO() { // SqlSession 연결은 한 번만 수립하면 족하므로 기본 생성자로 수행
		String resource = "mybatis-config.xml";
		try {
			// 1.byte단위로 읽어오기
			//InputStream inputStream = Resources.getResourceAsStream(resource);
			// 2. 문자 단위로 읽어오기
			Reader reader = Resources.getResourceAsReader(resource); 
			// Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
							// String resource = "mybatis-config.xml";과 합쳐서 이렇게 한 줄로 해도 된다.
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); // 생성 (SqlSession는 인터페이스이므로 직접 new가 불가능)
		sqlSession.insert("userSQL.write", userDTO); // (namespace.mapperId, 자료형)
		sqlSession.commit(); // Lock - commit 필요
		sqlSession.close();
	}


	public List<UserDTO> getUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		// List안에 담았으니까 selectList 사용
		// List로 넘어온 값을 List로 담는 것
		// selectList는 Object타입이므로 UserDTO로 담아서 넘기겠다는 형고정이 필요
		sqlSession.close();
		
		return list; // list에 담아온 값을 리턴함
	}


	public UserDTO getUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUser", id); 
		// selectOne은 Object. but, 우리에게 필요한건 한 사람 분의 데이터이므로 userDTO로 알아서 캐스팅(형변환) 해서 넘겨주게 설정
		sqlSession.close();
		
		return userDTO;
	}


	public void update(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); // 생성
		sqlSession.update("userSQL.update", userDTO); 
		sqlSession.commit(); // Lock - commit 필요
		sqlSession.close();
	}


	public void delete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); // 생성
		sqlSession.delete("userSQL.delete", id); 
		sqlSession.commit(); // Lock - commit 필요
		sqlSession.close();
	}


	public List<UserDTO> search(String name, String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); // 생성
		List<UserDTO> list = null;
		if (id == null ) {
			list = sqlSession.selectList("userSQL.search", name);
		} else if (name == null) {
			list = sqlSession.selectList("userSQL.search", id);
		}
		
		sqlSession.close();
		
		return list;
	}
}
