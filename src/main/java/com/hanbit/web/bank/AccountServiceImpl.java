/**
 * 
 */
package com.hanbit.web.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hanbit.web.member.MemberDAOImpl;

/**
 * @date     : 2016. 6. 20.
 * @author   : jun.dev
 * @fileName : AccountServiceImpl.java
 * @story    : 계좌 인터페이스
 */
@Service
public class AccountServiceImpl implements AccountService {

	AccountDAOImpl dao;
	private static AccountService instance = new AccountServiceImpl();
	private Map map;
	
	public static AccountService getInstance() {
		
		return instance;
	}

	private AccountServiceImpl() {
		dao = AccountDAOImpl.getInstance();
	}
	
	@Override
	public String openAccount(AccountMemberVO bean) {
		int succ = dao.openAccount(bean);
		String result = "계좌개설을 실패하였습니다.";
		if(succ == 1){
			result = "계좌개설 성공";
		}
		return result;
	}

	@Override
	public String deposit(AccountMemberVO bean) {
		int succ = dao.deposit(bean);
		String result = "입금 실패";
		if(succ == 1){
			result = "입금이 완료되었습니다.";
		}
		return result;
	}
	@Override
	public AccountMemberVO findByAcc(AccountMemberVO bean) {
		return dao.findByAcc(bean);
	}
	@Override
	public String withdraw(AccountMemberVO bean) {
		//return 	dao.withdraw(bean);
		return "";
	}
	@Override
	public String deleteAccount(AccountMemberVO bean) {
		//return dao.deleteAccount(bean);
		return "";
	}

	@Override
	public String updateAccount(AccountMemberVO bean) {
		//return dao.updateAccount(bean);
		return "";
	}


	@Override
	public List<?> accountList() {
		return dao.totalAccount();
	}


	@Override
	public List<AccountMemberVO> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public int count() {
		return dao.count();
	}


	@Override
	public Map<?,?> map() {
		map = new HashMap<String,AccountMemberVO>();
		map = dao.selectMap();
		return map;
	}

	@Override
	public List<?> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findBy() {
		// TODO Auto-generated method stub
		return null;
	}





}
