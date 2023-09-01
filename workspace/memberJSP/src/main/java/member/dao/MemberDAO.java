package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch(SQLException  e) {
			e.printStackTrace();
		}
	}
	
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
}
