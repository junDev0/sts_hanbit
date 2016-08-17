package com.hanbit.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.web.global.Constants;
import com.hanbit.web.global.DatabaseFactory;
import com.hanbit.web.global.Vendor;

/**
 * @date     : 2016. 7. 1.
 * @author   : jun
 * @fileName : MemberDAO.java
 * @story    :
 */

public class MemberDAO {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	//디자인패턴 - 싱글톤
	private static MemberDAO instance = new MemberDAO(); 

	public static MemberDAO getInstance() {
		return instance;
	}

	private MemberDAO() {
		con = DatabaseFactory.createDatebase(Vendor.ORACLE,Constants.USER_ID, Constants.USER_PW	).getConnection();

	}
/*	public int insert(MemberBean bean){
		System.out.println(bean.toString());
		String sql = "insert into member_bean "
				+ "values('"+bean.getId()+"','"+bean.getPw()+"','"+bean.getName()+"','"+bean.getRegDate()+"',"
						+ "'"+bean.getGender()+"',"+"'"+bean.getSsn()+"','"+bean.getAge()+"')";
		return this.exeUpdate(sql);
	}	*/

	public boolean insert(MemberBean bean){
		System.out.println(bean.toString());
		String sql = "insert into member_bean(id,pw,name,regDate,gender,ssn,age,email,phone,profile_img) values(?,?,?,?,?,?,?,?,?,?)";
		int count = 0;
		boolean result = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPw());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getRegDate());
			pstmt.setString(5, bean.getGender());
			pstmt.setString(6, bean.getSsn());
			pstmt.setInt(7, bean.getAge());
			pstmt.setString(8, bean.getEmail());
			pstmt.setString(9, bean.getPhone());
			pstmt.setString(10, "default.png");
			count = pstmt.executeUpdate();
			System.out.println(count);
		} catch (Exception e) {
		}
		if(count == 1){
			result = true;
		}
		System.out.println(result);
		return result;
	}
	public int infoUpdate(MemberBean bean){
		String sql = "update member_bean set pw = '"+bean.getPw()+"', email = '"+bean.getEmail()
					+ "' where id ='"+bean.getId()+"'";
		return this.exeUpdate(sql);
		
	}
	public int infoDelete(MemberBean bean){
		String sql = "delete from member_bean where id = '"+bean.getId()+"' and pw='"+bean.getPw()+"'";
		return this.exeUpdate(sql);
		
	}


	public int exeUpdate(String sql) {
		int updateResult = 0;
		try {
			stmt = con.createStatement();
			updateResult = stmt.executeUpdate(sql);
			System.out.println(updateResult);
		} catch (Exception e) {
		}
		return updateResult;
	}
	
	//list
	public List<MemberBean> list(){
		String sql = "select * from member_bean";
		List <MemberBean> list = new ArrayList<MemberBean>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				list.add(new MemberBean(rs.getString("name"), rs.getString("id"),
										rs.getString("pw"), rs.getString("ssn"), 
										rs.getString("regDate"),rs.getString("email"),
										rs.getString("profile_img"),rs.getString("phone")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	// findByPK
	public MemberBean findById(String id){
		String sql = "select * from member_bean where id ='"+id+"'";
		MemberBean bean = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				bean = new MemberBean(rs.getString("name"), rs.getString("id"), 
									  rs.getString("pw"), rs.getString("ssn"), 
									  rs.getString("regDate"),rs.getString("email"),
									  rs.getString("profile_img"),rs.getString("phone"));
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	public void addMajorAndSubjects(){
		String sql = "insert into grade()";
	}
	//findByNotPK
	public List<MemberBean> findByName(String name){
		String sql = "select * from member_bean where name ='"+name+"'";
		List <MemberBean> list = new ArrayList<MemberBean>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				list.add(new MemberBean(rs.getString("name"), rs.getString("id"),
										rs.getString("pw"), rs.getString("ssn"), 
										rs.getString("regDate"),rs.getString("email"),
										rs.getString("profile_img"),rs.getString("phone")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;	}
	//count
	public int count(){
		String sql = "select count(*) as count from member_bean";
		int count = 0;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
	        if(rs.next()) count = rs.getInt("count");
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public int genCount(String gender){
		String sql = "select count(*) as count from member_bean where gender = ?";
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gender);
			rs = pstmt.executeQuery();
	        if(rs.next()) count = rs.getInt("count");
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}	
	public boolean login(MemberBean param) {
		boolean loginOk= false;
		if(param.getId()!=null&& param.getPw()!=null&&this.existId(param.getId())==true){
			MemberBean member = this.findById(param.getId());
			if(member.getPw().equals(param.getPw())){
				loginOk = true;
			}	
		}
		
		return loginOk;
	}
	public boolean existId(String id){
		boolean existOK = false;
		int result=0;
		String sql = "select count(*) as count from member_bean where id = ?";
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					if(rs.next()){
						result = rs.getInt("count");
						System.out.println("ID 카운트 결과:"+result);
					}
				} catch (Exception e) {
				}
				if(result ==1){
					existOK = true;
				}
		return existOK;
	}
	
}
