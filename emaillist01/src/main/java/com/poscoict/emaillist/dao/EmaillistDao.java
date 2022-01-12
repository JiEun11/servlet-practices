package com.poscoict.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poscoict.emaillist.vo.EmaillistVo;

public class EmaillistDao {

	public List<EmaillistVo> findAll() {
		
		List<EmaillistVo> result = new ArrayList<EmaillistVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			// 1. JDBC driver loading
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connect to DB
			String url = "jdbc:mysql://localhost:3306/webdb?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "webdb";
			String passwd = "webdb";
			conn = DriverManager.getConnection(url, user, passwd);
			
			// 3. Prepare the SQL ( except ; when you copy your sql )
			String sql = "select no, first_name, last_name, email from emaillist order by no desc";
			pstmt = conn.prepareStatement(sql);
			
			// 4. Binding : it's for variable if we have
			
			// 5. Excute SQL
			rs = pstmt.executeQuery(); // it returns a result set. sql 이미 들어있으니까 넣으면 안 된다.
			
			while(rs.next()) {
				Long no = rs.getLong(1); // column no
				String firstName = rs.getString(2); // column first_name
				String lastName = rs.getString(3);  // column last_name
				String email = rs.getString(4);    // column email
				
				EmaillistVo vo = new EmaillistVo();
				vo.setNo(no);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setEmail(email);
				
				// vo 담은 거 담기 
				result.add(vo);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.print("Fail to driver loading : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			// 자원 정리
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return result;
	}

}
