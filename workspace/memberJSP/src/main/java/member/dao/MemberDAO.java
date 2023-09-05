package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.bean.MemberDTO;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private DataSource ds; // connection pool을 이용할 때 거치는 것
	
	public MemberDAO() {  //  connection pool 설정 후 DataSource가 설정되어있는 Context를 생성자로 호출해야 함
		// Context - 인터페이스라 new 할 수 없음
		try {
			Context context = new InitialContext();
			// Context는 Object, 자식은 DataSource타입, 즉 형변환 필요
			 ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle"); // 이제 모든 커넥션을 DataSource가 다 받아 넘김
			 								// 주의) Tomcat일 경우에만 "java:comp/env/" 이 접두사를 꼭 붙여야 함
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}
	
	// DB 접속 (getConnection도 Context 이후로 필요없으니 삭제) - 이제부터 모든 Connection은 Datasource로부터 얻어온다
	
	// 회원가입 - 아이디 중복체크
	public boolean isExistId(String id) {
		boolean exist = false;
		String sql = "select * from member where id=?"; 
		
		try {
			conn = ds.getConnection(); // DataSource로부터 Connection을 가져온다
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
		
		// 쿼리문(insert문)을 자바에서 수행(처리)하기 위한 가이드
		try {
			conn = ds.getConnection(); // 오라클 접속
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
	
	// 로그인 (email도 가져오기 위해 name대신 memberDTO 객체를 전부 가져오기)
	public MemberDTO login(String id, String pwd) {
		MemberDTO memberDTO = null; //memberDTO 초기화
		String sql = "select * from member where id=? and pwd=?"; 
		
		try {
			conn = ds.getConnection(); // 접속
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);  // 1 - ?(물음표 순서)
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery(); 	// 실행 - ResultSet 리턴  사이즈가 없기때문에 현재값이 없을때까지 계속 반복해야함
			
			if (rs.next()) {
				memberDTO = new MemberDTO(); // memberDTO 생성
				//name = rs.getString("name");
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setZipcode(rs.getString("zipcode"));
				memberDTO.setAddr1(rs.getString("addr1"));
				memberDTO.setAddr2(rs.getString("addr2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			memberDTO = null;
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}// finally-try-catch
		}
		return memberDTO;
	}
}
