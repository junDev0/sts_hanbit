package com.hanbit.web.subject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hanbit.web.member.MemberDAOImpl;
import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;

/**
 * @date     : 2016. 7. 26.
 * @author   : jun
 * @fileName : SubjectDAO.java
 * @story    :
 */

public class SubjectDAOImpl implements SubjectDAO {
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	private static final String NAMESPACE = "mapper.subject.";
	private SqlSessionFactory sqlSessionFactory;	
	private static SubjectDAOImpl instance; 

	private SubjectDAOImpl() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			logger.info("session build fail");
		}	}
	public static SubjectDAOImpl getInstance() {
		if (instance == null){
			logger.info("MemberDAOImpl instance is created !!");
			instance = new SubjectDAOImpl();
		}
		return instance;
	}
	
	
	public int insert(SubjectVO sub){
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("",sub);
	}
	
	public SubjectVO findById(String id){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne(NAMESPACE + "findById", id);
		} finally {
			session.close();
		}
	}
}
