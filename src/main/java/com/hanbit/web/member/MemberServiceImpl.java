/**
 * 
 */
package com.hanbit.web.member;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hanbit.web.subject.SubjectVO;
import com.hanbit.web.subject.SubjectDAOImpl;
import com.hanbit.web.subject.SubjectMemberVO;
import com.hanbit.web.subject.SubjectService;
import com.hanbit.web.subject.SubjectServiceImpl;
import com.hanbit.web.bank.AccountService;
import com.hanbit.web.bank.AccountServiceImpl;

/**
 * @date     : 2016. 6. 17.
 * @author   : jun.dev
 * @fileName : StudentImplement.java
 * @story    : 
 */
@Service
public class MemberServiceImpl implements MemberService{
	private MemberVO st = new MemberVO();
	private SubjectService subjImpl = SubjectServiceImpl.getInstance();
	private MemberVO member;
	private AccountService accService = AccountServiceImpl.getInstance();
	private static MemberServiceImpl instance = new MemberServiceImpl();
	private MemberDAOImpl dao;
	
	public static MemberServiceImpl getInstance() {
		return instance;
	}

	
	private MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
	}

	@Override
	public String regist(MemberVO bean) {
		String msg = "fail";
/*		MemberVO temp = this.findById(bean.getId());
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
*/		return msg;
	}

	@Override
	public List<MemberVO> show() {
		
		//return dao.list();
		return null;
	}

	@Override
	public String update(MemberVO bean) {
		String result = "";
/*		if(dao.infoUpdate(bean) == 1){
		member = this.findById(bean.getId());
		result = "내정보 수정이 완료되었습니다.";
		}
		System.out.println(result);
*/		return result;
	}

	@Override
	public String delete(MemberVO bean) {
		String result = "";
/*		if(dao.infoDelete(bean) == 1){
		result = "계정 삭제가 완료되었습니다.";
		}
*/		return result;
	}


	@Override
	public int count() {
		// TODO Auto-generated method stub
/*		return dao.count();
*/		return 0;
	}

	@Override
	public MemberVO findById(String findID) {
		return dao.findById(findID);
	}

	@Override
	public List<MemberVO> findByName(String name) {
		//return dao.findByName(name);
		return null;
	}

	@Override
	public SubjectMemberVO login(MemberVO bean) {
		SubjectMemberVO sm = new SubjectMemberVO();
		SubjectVO sb = new SubjectVO();
		String result = "";
		System.out.println("login:"+dao.login(bean));
		if (dao.login(bean)) {
			member = dao.findById(bean.getId());
			//accService.map();
			sb = subjImpl.findById(bean.getId());
			if(sb!=null){
			sm.setSubjects(sb.getSubjects());
			}
			sm.setEmail(member.getEmail());
			sm.setId(member.getId());
			sm.setPw(member.getPw());
			sm.setGender(member.getGender());
			sm.setImg(member.getProfileImg());
			sm.setMajor(sb.getMajor());
			sm.setName(member.getName());
			sm.setPhone(member.getPhone());
			sm.setReg(member.getRegDate());
			sm.setSsn(member.getSsn());
		}else{
			sm.setId("fail");
		}
		
		return sm;
	
	}
	@Override
	public MemberVO findBy() {
		if(member != null){
			System.out.println(this.findById(member.getId()).toString());
			return this.findById(member.getId());
		}
		return null;
	}

	@Override
	public int findByGen(String gender) {
		
		//return dao.genCount(gender);
		return 0;
	}

	@Override
	public String logout() {
		String result = "";
		if(member!=null){
			member = null;
			result = "로그아웃 완료";
		}
		return result;
	}		



}
