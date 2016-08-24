package com.hanbit.web.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;


/**
 * @date     : 2016. 7. 6.
 * @author   : jun
 * @fileName : AccountDAO.java
 * @story    :
 */

public class AccountDAO {
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private static AccountDAO instance = new AccountDAO();
	
	public static AccountDAO getInstance() {
		return instance;
	}

	private AccountDAO() {
		con = DatabaseFactory.createDatebase(Vendor.ORACLE,Constants.USER_ID, Constants.USER_PW	).getConnection();
	}
	// insert 통장개설
	public int openAccount(AccountMemberBean bean){
		int accountCount = 0,memberCount=0;
		AccountMemberBean chBean = cheekAccount(bean);
		
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
		return accountCount==1 && memberCount ==1 ?1:0;
	}	
	// 중복체크
	public AccountMemberBean cheekAccount(AccountMemberBean bean){
		String sql = "select * from member_bean where id = ?";
		AccountMemberBean checkBean = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			rs = pstmt.executeQuery();
			if(rs.next()==true){
				checkBean = new AccountMemberBean();
				checkBean.setId(rs.getString("id"));
				checkBean.setPw(rs.getString("pw"));
				checkBean.setName(rs.getString("name"));
				checkBean.setRegDate(rs.getString("regDate"));
				checkBean.setGender(rs.getString("gender"));
				checkBean.setSsn(rs.getString("ssn"));
				checkBean.setAge(rs.getInt("age"));
			}
		} catch (Exception e) {
			
		}
		
		return checkBean;
	}
	
	//입금
	public int deposit(AccountMemberBean bean){
		int count = 0;
		AccountMemberBean acBean = this.basicAccount(bean);
		if(acBean != null){
		int money = acBean.getMoney();
		int input = bean.getMoney();
		money += input;
		bean.setMoney(money);
		String sql = "update account set money=? where account_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getMoney());
			pstmt.setInt(2, bean.getAccountNO());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
		}
		}
		return count;
	}
	
	//출금
		public String withdraw(AccountMemberBean bean){
			String result = "잘못된 정보입니다.";
			int count = 0;
			AccountMemberBean acBean = this.basicAccount(bean);
			if(acBean != null){
			int money = acBean.getMoney();
			int input = bean.getMoney();
			if(money<input){
				result = "출금액이 잔금보다 많습니다.";
			}
			money -= input;
			bean.setMoney(money);
			String sql = "update account set money=? where account_no = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bean.getMoney());
				pstmt.setInt(2, bean.getAccountNO());
				count = pstmt.executeUpdate();
				if(count ==1){
					result = "출금완료";
				}
			} catch (Exception e) {
			}
			}
			return result;
		}
	
	// 현재 계좌(계좌로 조회)
	public AccountMemberBean basicAccount(AccountMemberBean bean){
		String sql = "select * from account_member where account_no = ?";
		AccountMemberBean acBean = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getAccountNO());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				acBean = new AccountMemberBean(rs.getInt("account_no"), 
											   rs.getInt("money"), 
											   rs.getString("id"), 
											   rs.getString("pw"), 
											   rs.getString("name"), 
											   rs.getString("regDate"), 
											   rs.getString("ssn"));
			}
			
		} catch (Exception e) {
		}
		
		return acBean;
	}
	
	public String updateAccount(AccountMemberBean bean){
		String result = "잘못된 정보 입니다.";
		String sql = "update member_bean set pw = ? where id = ? and pw = ?";
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getModifyPw());
			pstmt.setString(2, bean.getId());
			pstmt.setString(3, bean.getPw());
			count = pstmt.executeUpdate();
			if(count == 1){
				result = "비밀번호가 수정되었습니다.";
			}
		} catch (Exception e) {
		}
		return result;
	}

	
	public String deleteAccount(AccountMemberBean bean){
		int count = 0;
		String result = "잘못된 정보 입니다.";
		String sql = "delete from account where account_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getAccountNO());
			count = pstmt.executeUpdate();
			if(count == 1){
				result = "계좌해제완료.";
			}
		} catch (Exception e) {
	}
		return result;
	}
	
	// 전체 계좌
		public List<?> totalAccount(){
			String sql = "select * from account_member";
			List<AccountMemberBean> list = new ArrayList<AccountMemberBean>();
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					list.add(new AccountMemberBean(rs.getInt("account_no"), 
												   rs.getInt("money"), 
												   rs.getString("id"), 
												   rs.getString("pw"), 
												   rs.getString("name"), 
												   rs.getString("regDate"), 
												   rs.getString("ssn")));
				}
				
			} catch (Exception e) {
			}
			
			return list;
		}
		
		// 조회(이름)
		public List<AccountMemberBean> findByName(String name){
			String sql = "select * from account_member where name = ?";
			List<AccountMemberBean> list = new ArrayList<AccountMemberBean>();
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					list.add(new AccountMemberBean(rs.getInt("account_no"), 
												   rs.getInt("money"), 
												   rs.getString("id"), 
												   rs.getString("pw"), 
												   rs.getString("name"), 
												   rs.getString("regDate"), 
												   rs.getString("ssn")));
				}
				
			} catch (Exception e) {
			}
			
			return list;
		}
		// 전체 계좌
		public int count(){
			String sql = "select count(*) as count from account_member";
			List<AccountMemberBean> list = new ArrayList<AccountMemberBean>();
			int count = 0;
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) count = rs.getInt("count");				
			} catch (Exception e) {
			}
			
			return count;
		}
		
		public Map<?, ?> selectMap() {
			Map<String,AccountMemberBean> map = new HashMap<String,AccountMemberBean>();
			String sql = "select * from account_member";
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					AccountMemberBean am = new AccountMemberBean();
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
			}
			return map;
		}
}
