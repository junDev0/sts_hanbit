package com.hanbit.web.subject;

import org.springframework.stereotype.Service;

import com.hanbit.web.member.MemberDAOImpl;

/**
 * @date     : 2016. 7. 26.
 * @author   : jun
 * @fileName : SubjectServiceImpl.java
 * @story    :
 */
@Service
public class SubjectServiceImpl implements SubjectService{
	SubjectDAOImpl dao;
	private static SubjectService instance = new SubjectServiceImpl();
	public SubjectServiceImpl() {
		dao = SubjectDAOImpl.getInstance();
	}
	
	public static SubjectService getInstance() {
		if (instance == null){
			instance = new SubjectServiceImpl();
		}
		return instance;
	}

	@Override
	public void insert(SubjectVO bean) {
		dao.insert(bean);
	}

	@Override
	public SubjectVO findById(String id) {
		return dao.findById(id);
	}

}
