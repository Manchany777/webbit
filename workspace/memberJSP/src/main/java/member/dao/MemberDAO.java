package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.bean.MemberDTO;

public class MemberDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1231";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAO() {
		try {
			Class.forName(driver);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// DB 접속
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch(SQLException  e) {
			e.printStackTrace();
		}
	}
	
	// 회원가입 - 아이디 중복체크
	public boolean isExistId(String id) {
		boolean exist = false;
		String sql = "select * from member where id=?"; 
		getConnection(); // 접속
		
		
		try {
			pstmt = conn.prepareStatement(sql); // prepareStatement - sql문장을 전담으로 처리해주는 가이드
			pstmt.setString(1, id);  // 1 - ?(물음표 순서)
			rs = pstmt.executeQuery(); 			// 실행 - ResultSet 리턴  사이즈가 없기때문에 현재값이 없을때까지 계속 반복해야함
			
			if (rs.next()) {
				exist =  true; 
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// finally-try-catch
		}
		return exist;
	}
	
	// 회원가입 - submit
	public int regist(MemberDTO memberDTO) {
		int su = 0;
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		getConnection(); // 오라클 접속
		
		// 쿼리문(insert문)을 자바에서 수행(처리)하기 위한 가이드
		try {
			pstmt = conn.prepareStatement(sql); // 생성
			
			// ? 에 데이터 대입
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getZipcode());
			pstmt.setString(11, memberDTO.getAddr1());
			pstmt.setString(12, memberDTO.getAddr2());
			
			// 오라클 문장을 실행
			su = pstmt.executeUpdate(); // 실행 - 개수 리턴
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
		
		return su;
	}
	
	// 로그인
	public String login(String id, String pwd) {
		String name = null;
		String sql = "select * from member where id=? and pwd=?"; 
		getConnection(); // 접속
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);  // 1 - ?(물음표 순서)
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery(); 	// 실행 - ResultSet 리턴  사이즈가 없기때문에 현재값이 없을때까지 계속 반복해야함
			
			if (rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			name = null;
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// finally-try-catch
		}
		return name;
	}
}
