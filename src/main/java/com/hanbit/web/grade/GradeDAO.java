package com.hanbit.web.grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.web.member.MemberBean;
import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;

/**
 * @date     : 2016. 7. 4.
 * @author   : jun
 * @fileName : GradeDAO.java
 * @story    :
 */

public class GradeDAO {
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private static GradeDAO instance = new GradeDAO();
	
	public static GradeDAO getInstance() {
		return instance;
	}

	private GradeDAO() {
		con = DatabaseFactory.createDatebase(Vendor.ORACLE,Constants.USER_ID, Constants.USER_PW	).getConnection();
	}

	public int insert(GradeBean bean){
		String sql = "insert into grade("
				+ "seq,grade,java,sql,html,javascript,id,exam_date"
				+ ")values("
				+ "seq.nextval,'"+bean.getGrade()+"',"+bean.getJava()+","+bean.getSql()+","+bean.getHtml()+","+bean.getJavascript()+","
				+ "'"+bean.getId()+"','"+bean.getExamDate()+"'"
				+ ")";
		return this.exeUpdate(sql);
	}
/*	public int insert1(GradeBean bean){
		String sql = "insert into grade("
				+ "seq,grade,java,sql,html,javascript,id,exam_date"
				+ ")values("
				+ "seq.nextval,?,?,?,?,?,?,?"
				+ ")";
		return this.exeUpdate(sql);
	}*/
	public int update(GradeBean bean,String str){
		String sql = "";
		switch (str) {
		case "자바": sql = "update grade set grade='"+bean.getGrade()+"',java="+bean.getJava()+" where seq ="+bean.getSeq();break;
		case "SQL": sql = "update grade set grade='"+bean.getGrade()+"',sql="+bean.getSql()+" where seq ="+bean.getSeq();break;
		case "HTML5": sql = "update grade set grade='"+bean.getGrade()+"',html="+bean.getHtml()+" where seq ="+bean.getSeq();break;
		case "자바스크립트": sql = "update grade set grade='"+bean.getGrade()+"',javascript="+bean.getJavascript()+" where seq ="+bean.getSeq();break;
		default: return 0;
		}

		return this.exeUpdate(sql);
	}
	
	public int delete(GradeBean bean){
		String sql = "delete from grade where seq = "+Integer.parseInt(bean.getSeq());
		return this.exeUpdate(sql);
	}
	public GradeBean updateInfo(GradeBean bean){
		String sql = "select * from grade where seq ="+Integer.parseInt(bean.getSeq());
		GradeBean list = new GradeBean();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				list = new GradeBean(String.valueOf(rs.getInt("seq")),rs.getString("grade"),rs.getString("id"), rs.getInt("java"), rs.getInt("sql"), 
						rs.getInt("html"), rs.getInt("javascript"), rs.getString("exam_date"));
			}
			System.out.println("11:"+ list.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public int exeUpdate(String sql) {
		int updateResult = 0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			stmt = con.createStatement();
			updateResult = stmt.executeUpdate(sql);
			System.out.println(updateResult);
		} catch (Exception e) {
		}
		return updateResult;
	}

	//list
	/*public List<GradeBean> list(){
		System.out.println("11");
		String sql = "select * from grade";
		List <GradeBean> list = new ArrayList<GradeBean>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				list.add(new GradeBean(String.valueOf(rs.getInt("seq")),rs.getString("grade"),rs.getString("id"), rs.getInt("java"), rs.getInt("sql"), 
						rs.getInt("html"), rs.getInt("javascript"), rs.getString("exam_date")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}*/
	public List<GradeBean> list(){
		List<GradeBean> list = new ArrayList<GradeBean>();
		String sql = "select * from grade";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new GradeBean(String.valueOf(rs.getInt("seq")),rs.getString("grade"),rs.getString("id"), rs.getInt("java"), rs.getInt("sql"), 
						rs.getInt("html"), rs.getInt("javascript"), rs.getString("exam_date")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	// 시퀀스 찾기
	public List<GradeBean> findBySeq(String id){
		String sql = "select * from grade where id ='"+id+"'";
		List<GradeBean> list = new ArrayList<GradeBean>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while(rs.next()){
				list.add(new GradeBean(String.valueOf(rs.getInt("seq")),rs.getString("grade"),rs.getString("id"), rs.getInt("java"), rs.getInt("sql"), 
						rs.getInt("html"), rs.getInt("javascript"), rs.getString("exam_date")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 시퀀스 찾기
	public List<GradeBean> findByHakjum(String hakjum){
		String sql = "select * from grade where grade ='"+hakjum+"'";
		List<GradeBean> list = new ArrayList<GradeBean>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while(rs.next()){
				list.add(new GradeBean(String.valueOf(rs.getInt("seq")),rs.getString("grade"),rs.getString("id"), rs.getInt("java"), rs.getInt("sql"), 
						rs.getInt("html"), rs.getInt("javascript"), rs.getString("exam_date")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	// 고사 찾기
		public List<GradeBean> findByMonth(String examDate){
			String sql = "select * from grade where exam_date ='"+examDate+"'";
			List<GradeBean> list = new ArrayList<GradeBean>();
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery(sql);
				while(rs.next()){
					list.add(new GradeBean(String.valueOf(rs.getInt("seq")),rs.getString("grade"),rs.getString("id"), rs.getInt("java"), rs.getInt("sql"), 
							rs.getInt("html"), rs.getInt("javascript"), rs.getString("exam_date")));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	public int count(String examDate){
		String sql = "select count(*) as count from grade"
				+ "where exam_date = ?";
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, examDate);
			rs = pstmt.executeQuery(sql);
			if(rs.next()) count = rs.getInt("count");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
