/**
 * 
 */
package com.hanbit.web.member;

import java.text.SimpleDateFormat;
import java.util.List;

import com.hanbit.web.subject.SubjectBean;
import com.hanbit.web.subject.SubjectDAO;
import com.hanbit.web.subject.SubjectMember;

import com.hanbit.web.bank.AccountService;
import com.hanbit.web.bank.AccountServiceImpl;

/**
 * @date     : 2016. 6. 17.
 * @author   : jun.dev
 * @fileName : StudentImplement.java
 * @story    : 
 */
public class MemberServiceImpl implements MemberService{
	private MemberBean st = new MemberBean();
	private MemberDAO dao = MemberDAO.getInstance(); //싱글톤 패턴
	private SubjectDAO subjDao = SubjectDAO.getInstance();
	private MemberBean session;
	private AccountService accService = AccountServiceImpl.getInstance();
	private static MemberServiceImpl instance = new MemberServiceImpl();
	
	public static MemberServiceImpl getInstance() {
		return instance;
	}

	private MemberServiceImpl() {
		session = new MemberBean();
	}

	@Override
	public String regist(MemberBean bean) {
		String msg = "fail";
		MemberBean temp = this.findById(bean.getId());
		if(temp.getAge() == 0){
		boolean result = dao.insert(bean);
		if(result == true){
			msg = "succ";
		}else{
			msg = "fail";
		}
		}else{
			msg = "fail";
		}
		return msg;
	}

	@Override
	public List<MemberBean> show() {
		
		return dao.list();
	}

	@Override
	public String update(MemberBean bean) {
		String result = "";
		if(dao.infoUpdate(bean) == 1){
		session = this.findById(bean.getId());
		result = "내정보 수정이 완료되었습니다.";
		}
		System.out.println(result);
		return result;
	}

	@Override
	public String delete(MemberBean bean) {
		String result = "";
		if(dao.infoDelete(bean) == 1){
		result = "계정 삭제가 완료되었습니다.";
		}
		return result;
	}
	/*		String sql = "create table member_bean("
	+ "id varchar(20),"
	+ "pw varchar(20),"
	+ "name varchar(20),"
	+ "regDate varchar(20),"
	+ "gender varchar(20),"
	+ "ssn varchar(20),"
	+ "age int"
	+ ")";
	String dropSql = "drop table member_bean";
	String sqlSelect = "select * from member_bean";
	 */

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean result = new MemberBean();
		if(dao.findById(id)!=null){
			result = dao.findById(id);
			accService.map();
		}
		return result;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public SubjectMember login(MemberBean bean) {
		SubjectMember sm = new SubjectMember();
		SubjectBean sb = new SubjectBean();
		String result = "";
		if (dao.login(bean)) {
			session = dao.findById(bean.getId());
			result = bean.getName();
			accService.map();
			sb = subjDao.findById(bean.getId());
			sm.setEmail(session.getEmail());
			sm.setId(session.getId());
			sm.setPw(session.getPw());
			sm.setGender(session.getGender());
			sm.setImg(session.getProfileImg());
			sm.setMajor(sb.getMajor());
			sm.setName(session.getName());
			sm.setPhone(session.getPhone());
			sm.setReg(session.getRegDate());
			sm.setSsn(session.getSsn());
			sm.setSubjects(sb.getSubjects());
		}else{
			sm.setId("fail");
		}
		return sm;
	
	}
	@Override
	public MemberBean findBy() {
		if(session != null){
			System.out.println(this.findById(session.getId()).toString());
			return this.findById(session.getId());
		}
		return null;
	}

	@Override
	public int findByGen(String gender) {
		return dao.genCount(gender);
	}

	@Override
	public String logout() {
		String result = "";
		if(session!=null){
			session = null;
			result = "로그아웃 완료";
		}
		return result;
	}		



}
