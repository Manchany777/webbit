package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;

public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	public MemberDAO() {  
		String resource = "mybatis-config.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource); 
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 회원가입 - 아이디 중복체크
	public boolean isExistId(String id) {
		boolean exist = false;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.isExistId", id);
		
		if(memberDTO != null) exist = true;
		
		sqlSession.close();

		return exist;
	}
	
	// 회원가입 - submit
	public int regist(MemberDTO memberDTO) {
		int su = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		su = sqlSession.insert("memberSQL.regist", memberDTO);
		// insert 메소드의 실행 결과를 su 변수에 설정하는 부분 추가
		sqlSession.commit();
		sqlSession.close();
		
		return su;
	}
	
	// 로그인 (email도 가져오기 위해 name대신 memberDTO 객체를 전부 가져오기)
	public MemberDTO login(String id, String pwd) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.login", map);
		sqlSession.close();
		return memberDTO;
	}
}
