package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guestbook.bean.GuestbookDTO;

public class GuestbookDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1231";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public GuestbookDAO() {
		try {
			Class.forName(driver); // (데이터베이스 연결을 위한)드라이버 클래스 로드 
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password); // 데이터베이스에 연결
		} catch(SQLException  e) {
			e.printStackTrace();
		}
	}
	
	///////////////////////////////////////////////////////////////////////

	public void insert(GuestbookDTO guestbookDTO) {
		//int su = 0;
		//String sql = "insert into guestbook values(seq_guestbook.nextval, ?, ?, ?, ?, ?, sysdate)";
		String sql = "insert into guestbook(seq, name, email, homepage, subject, content) values(seq_guestbook.nextval, ?, ?, ?, ?, ?)";
				// sql문에서 sysdate를 default로 넣으면 여기서는 컬럼명을 다 적어야 에러가 안생긴다.
		getConnection(); // 오라클 접속
		
		// 쿼리문(insert문)을 자바에서 수행(처리)하기 위한 가이드
		try {
			pstmt = conn.prepareStatement(sql); // 생성
			
			// ? 에 데이터 대입
			pstmt.setString(1, guestbookDTO.getName());
			pstmt.setString(2, guestbookDTO.getEmail());
			pstmt.setString(3, guestbookDTO.getHomepage());
			pstmt.setString(4, guestbookDTO.getSubject());
			pstmt.setString(5, guestbookDTO.getContent());
			
			// 오라클 문장을 실행
			//su = pstmt.executeUpdate(); // 실행 - 개수 리턴
			pstmt.executeUpdate();
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
		
		//return su;
	}

	public List<GuestbookDTO> select() {
		List<GuestbookDTO> list = new ArrayList<GuestbookDTO>(); // 부모 = 자식 (다형성)
		String sql = "select seq, name, email, homepage, subject, content, "
				+ " to_char(logtime, 'YYYY-MM-DD') as logtime from (select * from guestbook order by logtime desc) tt";  // 날짜 - yyyy.mm.dd 변환
		// 주의 : 반드시 컬럼명을 logtime으로 바꿔놔야한다. 아래에서 rs.getString("logtime")으로 logtime 컬럼에서 꺼내올 것이라고 선언했기때문에
		// select name, age, height, to_char(logtime, 'YYYY-MM-DD') as logtime from dbtest order by logtime
		
		getConnection(); // 접속
		
		try {
			pstmt = conn.prepareStatement(sql); // prepareStatement - sql문장을 전담으로 처리해주는 가이드
			rs = pstmt.executeQuery(); 			// 실행 - ResultSet 리턴  사이즈가 없기때문에 현재값이 없을때까지 계속 반복해야함
			
			while(rs.next()) {
				GuestbookDTO guestbookDTO = new GuestbookDTO();
				guestbookDTO.setSeq(rs.getInt("seq"));
				guestbookDTO.setName(rs.getString("name")); // name 컬럼에서 꺼내온 데이터를 DTO에 담기
				guestbookDTO.setEmail(rs.getString("email"));
				guestbookDTO.setHomepage(rs.getString("homepage"));
				guestbookDTO.setSubject(rs.getString("subject"));
				guestbookDTO.setContent(rs.getString("content"));
				guestbookDTO.setLogtime(rs.getDate("logtime"));
				
				list.add(guestbookDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null; // 에러 발생시 list가 넘어가지 못하도록 NullPointException이 떨어지도록 설정
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// finally-try-catch
		}
		
		return list;
	}
}
