package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardDTO;
import member.bean.MemberDTO;


public class BoardDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; // select문
	private DataSource ds;
	
	public BoardDAO() {
		try {
			Context context = new InitialContext();
			 ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle"); 
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 게시판 등록 (return값 없음)
	public void boardWrite(Map<String, String> map) {
		// default 걸려있는 6개는 빼고 들어감
		String sql = "insert into board(seq, id, name, email, subject, content, ref) "
				+ " values(seq_board.nextval, ?, ?, ?, ?, ?, seq_board.currval)";
		// ref에 seq_board.nextval해도 어차피 쿼리문은 동시에 올라가니 상관 없음. but, 안정빵으로 쓰려몀ㄴ 
		
		// 쿼리문(insert문)을 자바에서 수행(처리)하기 위한 가이드
		try {
			conn = ds.getConnection(); // 오라클 접속
			pstmt = conn.prepareStatement(sql); // 생성
			
			// ? 에 데이터 대입
			pstmt.setString(1, map.get("id"));
			pstmt.setString(2, map.get("name"));
			pstmt.setString(3, map.get("email"));
			pstmt.setString(4, map.get("subject"));
			pstmt.setString(5, map.get("content"));
			
			pstmt.executeUpdate(); // 오라클 문장을 실행
			// su는 수행한 쿼리문의 개수 ((name, age, height 3개의 컬럼을 insert하는)1개의 쿼리문이 수행되었습니다 할 때의 숫자)
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// finally-try-catch
		}
	}
	
	public List<BoardDTO> getBoardList(int startNum, int endNum) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		//String sql = "select * from board order by seq desc"; // 페이징 처리 하기 전 코드
		String sql = "select * from "
					+ "    (select rownum rn, tt.* from (select * from board order by seq desc) tt order by seq desc) "
					+ "where rn >=? and rn <=?";
		
		try {
			conn = ds.getConnection(); // 오라클 접속
			pstmt = conn.prepareStatement(sql); // 생성
			
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setEmail(rs.getString("email"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				
				boardDTO.setRef(rs.getInt("ref"));
				boardDTO.setStep(rs.getInt("step"));
				boardDTO.setPseq(rs.getInt("pseq"));
				boardDTO.setReply(rs.getInt("reply"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getDate("logtime"));
				
				list.add(boardDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// finally-try-catch
		}
		return list;
	}
	
	public BoardDTO boardDetail(int seq) {
		BoardDTO boardDTO = null;
		String sql = "select * from board where seq = ?";
		
		try {
			conn = ds.getConnection(); // 오라클 접속
			pstmt = conn.prepareStatement(sql); // 생성
			pstmt.setInt(1, seq);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setEmail(rs.getString("email"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				
				boardDTO.setRef(rs.getInt("ref"));
				boardDTO.setStep(rs.getInt("step"));
				boardDTO.setPseq(rs.getInt("pseq"));
				boardDTO.setReply(rs.getInt("reply"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getDate("logtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			boardDTO = null;
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// finally-try-catch
		}
		return boardDTO;
	}
}
