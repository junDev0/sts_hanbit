package com.hanbit.web.bank;

import java.util.List;
import java.util.Map;

public interface AccountDAO {
	public int openAccount(AccountMemberVO bean);
	public AccountMemberVO cheekAccount(AccountMemberVO bean);
	public int deposit(AccountMemberVO bean);
	public int withdraw(AccountMemberVO bean);
	public AccountMemberVO findByAcc(AccountMemberVO bean);
	public int updateAccount(AccountMemberVO bean);
	public int deleteAccount(AccountMemberVO bean);
	public List<?> totalAccount();
	public List<AccountMemberVO> findByName(String name);
	public int count();
	public Map<?, ?> selectMap();
	
	
}
