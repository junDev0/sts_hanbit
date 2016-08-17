package com.hanbit.web.member;

/**
 * @date     : 2016. 6. 30.
 * @author   : jun
 * @fileName : MemberMain.java
 * @story    :
 */

public class MemberMain {
	public static void main(String[] args) {
		MemberBean m = new MemberBean();
		MemberBean m2 = new MemberBean();
		try {
		MemberBean	m4 =(MemberBean) Class.forName("member.MemberBean").newInstance();
		m4.setId("hong");
		m4.setName("홍길동");
		m4.setPw("1");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		m2.setId(m.getId());
		System.out.println(m.toString());
		
		
	}
}
