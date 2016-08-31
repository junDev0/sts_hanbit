package com.hanbit.web.bank;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hanbit.web.member.MemberDAOImpl;
import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;


/**
 * @date     : 2016. 7. 6.
 * @author   : jun
 * @fileName : AccountDAO.java
 * @story    :
 */

public class AccountDAOImpl extends SqlSessionDaoSupport implements AccountDAO {
	private static final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);
	private static AccountDAOImpl instance;
	private static final String NAMESPACE = "mapper.account.";
	private SqlSessionFactory sqlSessionFactory;	
	
	public static AccountDAOImpl getInstance() {
		if (instance == null){
			logger.info("MemberDAOImpl instance is created !!");
			instance = new AccountDAOImpl();
		}
		return instance;
	}

	private AccountDAOImpl() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			logger.info("session build fail");
		}
	}
	// insert 통장개설
	public int openAccount(AccountMemberVO bean){
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("",bean);
/*		int accountCount = 0,memberCount=0;
		AccountMemberVO chBean = cheekAccount(bean);
		
		String accountSql = "insert into account values(?,?,?)";
		try {
			pstmt = con.prepareStatement(accountSql); 
			pstmt.setInt(1, bean.getAccountNO());
			pstmt.setInt(2, bean.getMoney());
			pstmt.setString(3, bean.getId());
			accountCount = pstmt.executeUpdate();
		} catch (Exception e) {
		}
		if(chBean==null){ //신규개설
		String memberSql = "insert into member_bean values(?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(memberSql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPw());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getRegDate());
			pstmt.setString(5, bean.getGender());
			pstmt.setString(6, bean.getSsn());
			pstmt.setInt(7, bean.getAge());
			memberCount = pstmt.executeUpdate();
		} catch (Exception e) {
		}
		}else{
			memberCount = 1;
		}
		System.out.println("accountCount : "+accountCount + "memberCount : "+memberCount);
		return accountCount==1 && memberCount ==1 ?1:0;*/
	}	
	// 중복체크
	public AccountMemberVO cheekAccount(AccountMemberVO bean){
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("",bean);
	}
	
	//입금
	public int deposit(AccountMemberVO bean){
		SqlSession session = sqlSessionFactory.openSession();
		return session.update("",bean);
	}
	
	//출금
		public int withdraw(AccountMemberVO bean){
			SqlSession session = sqlSessionFactory.openSession();
			return session.update("",bean);
		}
	
	// 현재 계좌(계좌로 조회)
	public AccountMemberVO findByAcc(AccountMemberVO bean){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne(NAMESPACE + "findByAcc", bean);
		} finally {
			session.close();
		}
	}
	
	public int updateAccount(AccountMemberVO bean){
		SqlSession session = sqlSessionFactory.openSession();
		return session.update("",bean);
	}

	
	public int deleteAccount(AccountMemberVO bean){
		SqlSession session = sqlSessionFactory.openSession();
		return session.delete("",bean);
	}
	
	// 전체 계좌
		public List<?> totalAccount(){
			SqlSession session = sqlSessionFactory.openSession();
			return session.selectList("");
		}
		
		// 조회(이름)
		public List<AccountMemberVO> findByName(String name){
			SqlSession session = sqlSessionFactory.openSession();
			return session.selectList("",name);
		}
		// 전체 계좌
		public int count(){
			SqlSession session = sqlSessionFactory.openSession();
			try {
				return session.selectOne(NAMESPACE + "count");
			} finally {
				session.close();
			}		}
		
		public Map<?, ?> selectMap() {
			Map<String,AccountMemberVO> map = new HashMap<String,AccountMemberVO>();
/*			String sql = "select * from account_member";
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					AccountMemberVO am = new AccountMemberVO();
					am.setAccountNO(rs.getInt("ACCOUNT_NO"));
					am.setId(rs.getString("ID"));
					am.setMoney(rs.getInt("MONEY"));
					am.setName(rs.getString("NAME"));
					am.setPw(rs.getString("PW"));
					am.setRegDate(rs.getString("regDate"));
					am.setSsn(rs.getString("SSN"));
					map.put(String.valueOf(am.getAccountNO()), am);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			return map;
		}


}
