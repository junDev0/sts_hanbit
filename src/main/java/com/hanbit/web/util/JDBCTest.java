package com.hanbit.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @date     : 2016. 6. 30.
 * @author   : jun
 * @fileName : JDBCTest.java
 * @story    :
 */

public class JDBCTest {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from member_bean where id='hong'",result;
		
		List<String> list = new ArrayList<String>();
		try {
			//Class.forName(Constants.ORACLE_DRIVER); // 
			con = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result = rs.getString("id");
				list.add(result);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
	}
}
