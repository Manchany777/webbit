package board.dao;

import java.io.IOException;
import java.io.Reader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;


public class BoardDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	public BoardDAO() {
		String resource = "mybatis-config.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource); 
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 게시판 등록 (return값 없음)
	public void boardWrite(Map<String, String> map) {
		// default 걸려있는 6개는 빼고 들어감	
		SqlSession sqlSession = sqlSessionFactory.openSession(); // 생성 (SqlSession는 인터페이스이므로 직접 new가 불가능)
		sqlSession.insert("boardSQL.boardWrite", map); // (namespace.mapperId, 자료형)
		sqlSession.commit(); // Lock - commit 필요
		sqlSession.close();
	}
	
	public List<BoardDTO> getBoardList(int startNum, int endNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<BoardDTO> list = sqlSession.selectList("boardSQL.getBoardList", map);
		//List<BoardDTO> list = new ArrayList<BoardDTO>();
		//BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoardList", list);
		//list.add(boardDTO);

		sqlSession.close();
		return list;
	}
	
	// 게시글 조회
	public BoardDTO boardDetail(int seq) {
		//BoardDTO boardDTO = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.boardDetail", seq); 
		sqlSession.close();
		return boardDTO;
	}
	
	
	// 페이징 처리
	public int getTotalA() {
		int totalA = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		totalA = sqlSession.selectOne("boardSQL.getTotalA");
		// totalA = sqlSession.selectOne("boardSQL.getTotalA", 1); (x) -> 매개변수가 없으니까 인자값을 주면 안 된다.
		sqlSession.close();
		
		return totalA;
	}
	
	// 게시글 수정
	/*
	 * public BoardDTO boardModify(int seq) { SqlSession sqlSession =
	 * sqlSessionFactory.openSession(); BoardDTO boardDTO =
	 * sqlSession.selectOne("boardSQL.getBoard", seq);
	 * sqlSession.update("boardSQL.boardUpdate", boardDTO); sqlSession.commit();
	 * sqlSession.close(); return boardDTO; }
	 */
	
	public void boardModify(Map<String, Object> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("boardSQL.boardModify", map);
		sqlSession.commit(); // Lock - commit 필요
		sqlSession.close();
	}
	
	// 게시글 삭제
	public void boardDelete(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); // 생성
		sqlSession.delete("boardSQL.boardDelete", seq); 
		sqlSession.commit(); // Lock - commit 필요
		sqlSession.close();
	}
	
}
