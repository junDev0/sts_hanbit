package com.hanbit.web.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hanbit.web.global.Constants;
import com.hanbit.web.global.DatabaseFactory;
import com.hanbit.web.global.Vendor;

/**
 * @date     : 2016. 7. 26.
 * @author   : jun
 * @fileName : SubjectDAO.java
 * @story    :
 */

public class SubjectDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static SubjectDAO instance = new SubjectDAO(); 
	private SubjectDAO() {
		con = DatabaseFactory.createDatebase(Vendor.ORACLE, Constants.USER_ID, Constants.USER_PW).getConnection();
	}
	public static SubjectDAO getInstance() {
		return instance;
	}
	
	
	public void insert(SubjectBean sub){
		String sql = "insert into subject(subj_seq,id,major,subjects)"
				+ "values(subj_seq.nextval,?,?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sub.getId());
			pstmt.setString(2, sub.getMajor());
			pstmt.setString(3, sub.getSubjects());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(result == 1){
			System.out.println("과목 추가 성공");
		}else{
			System.out.println("과목 추가 실패");
		}
	}
	
	public SubjectBean findById(String id){
		SubjectBean bean = null;
		String sql = "select * from subject where id =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			bean = new SubjectBean();
			if(rs.next()){
				bean.setId(rs.getString("id"));
				bean.setMajor(rs.getString("major"));
				bean.setSubjects(rs.getString("subjects"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(bean.toString());
		return bean;
	}
}
