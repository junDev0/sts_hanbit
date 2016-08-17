package com.hanbit.web.subject;

/**
 * @date     : 2016. 7. 26.
 * @author   : jun
 * @fileName : SubjectServiceImpl.java
 * @story    :
 */

public class SubjectServiceImpl implements SubjectService{
	SubjectDAO dao = SubjectDAO.getInstance();
	private static SubjectService instance = new SubjectServiceImpl();
	private SubjectServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static SubjectService getInstance() {
		return instance;
	}

	@Override
	public void insert(SubjectBean bean) {
		dao.insert(bean);
	}

}
