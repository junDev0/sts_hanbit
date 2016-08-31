/**
 * 
 */
package com.hanbit.web.member;

import java.util.List;

import com.hanbit.web.subject.SubjectMemberVO;

/**
 * @date     : 2016. 6. 17.
 * @author   : jun.dev
 * @fileName : StudentService.java
 * @story    : 
 */
public interface MemberService {
	public String regist(MemberVO bean);
	public MemberVO findBy();
	public List<MemberVO> show();
	public String update(MemberVO bean); //pw만 수정가능
	public String delete(MemberVO bean);
	public int count();
	public MemberVO findById(String id);
	public List<MemberVO> findByName(String name);
	public int findByGen(String gender);
	public SubjectMemberVO login(MemberVO bean);
	public String logout();
}
