/**
 * 
 */
package com.hanbit.web.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date     : 2016. 6. 20.
 * @author   : jun.dev
 * @fileName : AccountServiceImpl.java
 * @story    : 계좌 인터페이스
 */
public class AccountServiceImpl implements AccountService {

	AccountDAO dao = AccountDAO.getInstance();
	private static AccountService instance = new AccountServiceImpl();
	private Map map;
	
	public static AccountService getInstance() {
		return instance;
	}

	private AccountServiceImpl() {
	}
	
	@Override
	public String openAccount(AccountMemberBean bean) {
		int succ = dao.openAccount(bean);
		String result = "계좌개설을 실패하였습니다.";
		if(succ == 1){
			result = "계좌개설 성공";
		}
		return result;
	}

	@Override
	public String deposit(AccountMemberBean bean) {
		int succ = dao.deposit(bean);
		String result = "입금 실패";
		if(succ == 1){
			result = "입금이 완료되었습니다.";
		}
		return result;
	}
	@Override
	public AccountMemberBean findByAcc(AccountMemberBean bean) {
		return dao.basicAccount(bean);
	}
	@Override
	public String withdraw(AccountMemberBean bean) {
		return 	dao.withdraw(bean);
	}
	@Override
	public String deleteAccount(AccountMemberBean bean) {
		return dao.deleteAccount(bean);
	}

	@Override
	public String updateAccount(AccountMemberBean bean) {
		return dao.updateAccount(bean);
	}


	@Override
	public List<?> accountList() {
		return dao.totalAccount();
	}


	@Override
	public List<AccountMemberBean> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public int count() {
		return dao.count();
	}


	@Override
	public Map<?,?> map() {
		map = new HashMap<String,AccountMemberBean>();
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
