package com.hanbit.web.util;

import java.util.List;

import com.hanbit.web.bank.AccountMemberVO;
import com.hanbit.web.bank.AccountServiceImpl;
import com.hanbit.web.bank.AccountVO;
import com.hanbit.web.grade.GradeServiceImpl;
import com.hanbit.web.grade.GradeVO;
import com.hanbit.web.member.MemberServiceImpl;
import com.hanbit.web.member.MemberVO;

public class Test {
	public String test(){
		//MemberVO m = MemberServiceImpl.getInstance().findById("hong");
		//List<GradeVO> m = GradeServiceImpl.getInstance().list();
		AccountMemberVO k = new AccountMemberVO();
		k.setAccountNO(909709);
		AccountMemberVO m = AccountServiceImpl.getInstance().findByAcc(k);
		int count = AccountServiceImpl.getInstance().count();
		return String.valueOf(count);
	}
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.test());
	}
}
