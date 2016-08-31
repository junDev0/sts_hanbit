package com.hanbit.web.grade;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hanbit.web.member.MemberDAOImpl;
import com.hanbit.web.member.MemberVO;
import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;

/**
 * @date     : 2016. 7. 4.
 * @author   : jun
 * @fileName : GradeDAO.java
 * @story    :
 */

public class GradeDAOImpl implements GradeDAO{
	private static final Logger logger = LoggerFactory.getLogger(GradeDAOImpl.class);
	private static final String NAMESPACE = "mapper.grade.";
	private SqlSessionFactory sqlSessionFactory;
	private static GradeDAOImpl instance = new GradeDAOImpl();
	
	public static GradeDAOImpl getInstance() {
		return instance;
	}

	private GradeDAOImpl() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			logger.info("grade session build fail");
		}	}

	public int insert(GradeVO bean){
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("",bean);
	}

	public int update(GradeVO bean,String str){
		String sql = "";
		switch (str) {
		case "자바": sql = "update grade set grade='"+bean.getGrade()+"',java="+bean.getJava()+" where seq ="+bean.getSeq();break;
		case "SQL": sql = "update grade set grade='"+bean.getGrade()+"',sql="+bean.getSql()+" where seq ="+bean.getSeq();break;
		case "HTML5": sql = "update grade set grade='"+bean.getGrade()+"',html="+bean.getHtml()+" where seq ="+bean.getSeq();break;
		case "자바스크립트": sql = "update grade set grade='"+bean.getGrade()+"',javascript="+bean.getJavascript()+" where seq ="+bean.getSeq();break;
		default: return 0;
		}
		SqlSession session = sqlSessionFactory.openSession();
		return session.update("",bean);
	}
	
	public int delete(GradeVO bean){
		SqlSession session = sqlSessionFactory.openSession();
		return session.delete("",bean);
	}
	public GradeVO updateInfo(GradeVO bean){
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("", bean);
	}

	public List<GradeVO> list(){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectList(NAMESPACE + "list");
		} finally {
			session.close();
		}
	}
	// 시퀀스 찾기
	public List<GradeVO> findBySeq(String id){
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("", id);
	}

	// 시퀀스 찾기
	public List<GradeVO> findByHakjum(String hakjum){
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("", hakjum);
	}
	// 고사 찾기
		public List<GradeVO> findByMonth(String examDate){
			SqlSession session = sqlSessionFactory.openSession();
			return session.selectList("", examDate);
		}
	public int count(String examDate){
/*		String sql = "select count(*) as count from grade"
				+ "where exam_date = ?";*/
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("");
	}


}
