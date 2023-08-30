package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.DBTestDTO;

public class DBTestDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1231";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public DBTestDAO() {
		try {
			Class.forName(driver);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch(SQLException  e) {
			e.printStackTrace();
		}
	}

	public int insert(DBTestDTO dBTestDTO) {
		int su = 0;
		String sql = "insert into DBTEST values(?, ?, ?, sysdate)";
		getConnection(); // 오라클 접속
		
		// 쿼리문(insert문)을 자바에서 수행(처리)하기 위한 가이드
		try {
			pstmt = conn.prepareStatement(sql); // 생성
			
			// ? 에 데이터 대입
			pstmt.setString(1, dBTestDTO.getName());
			pstmt.setString(2, dBTestDTO.getAge());
			pstmt.setString(3, dBTestDTO.getHeight());
			
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

	public List<DBTestDTO> select() {
		List<DBTestDTO> list = new ArrayList<DBTestDTO>(); // 부모 = 자식 (다형성)
		String sql = "select * from dbtest";  // 날짜 - yyyy.mm.dd 변환

		getConnection(); // 접속
		
		try {
			pstmt = conn.prepareStatement(sql); // prepareStatement - sql문장을 전담으로 처리해주는 가이드
			rs = pstmt.executeQuery(); 			// 실행 - ResultSet 리턴  사이즈가 없기때문에 현재값이 없을때까지 계속 반복해야함
			
			while(rs.next()) {
				DBTestDTO dBTestDTO = new DBTestDTO();
				dBTestDTO.setName(rs.getString("name")); // name 컬럼에서 꺼내온 데이터를 DTO에 담기
				dBTestDTO.setAge(rs.getString("age"));
				dBTestDTO.setHeight(rs.getString("height"));
				dBTestDTO.setLogtime(rs.getString("logtime"));
				
				list.add(dBTestDTO);
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

//일반 클래스
//- Object 상속
//- 반드시 new 해야 한다.