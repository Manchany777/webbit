package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

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
		sqlSession.commit();
		sqlSession.close();
	}
}
