/**
 * 
 */
package com.hanbit.web.bank;

import java.util.List;
import java.util.Map;

import com.hanbit.web.util.CommonService;

/**
 * @date     : 2016. 6. 20.
 * @author   : jun.dev
 * @fileName : AccountService.java
 * @story    : 
 */
public interface AccountService extends CommonService{
	//1.개설 2.입금 3.조회. 4.출금 5.통장내역 6.통장해지 0.종료
	
	//1.개설
	public String openAccount(AccountMemberBean bean);
	//2.입금
	public String deposit(AccountMemberBean bean);
	//3.출금
	public String withdraw(AccountMemberBean bean);
	//4.수정(사용자의 요청에 의해 비번만 수정가능) 계좌번호,비밀번호 받는 조건
	public String updateAccount(AccountMemberBean bean);
	//5.통장해지
	public String deleteAccount(AccountMemberBean bean);
	// 6.조회(전체 조회)
	public List<?> accountList();
	//7.개인계좌조회(계좌번호)
	public AccountMemberBean findByAcc(AccountMemberBean bean);
	//8.조회(이름)
	public List<AccountMemberBean> findByName(String name);
	//9.조회(전체통장수)
	public int count();
	public Map<?, ?> map();

}
