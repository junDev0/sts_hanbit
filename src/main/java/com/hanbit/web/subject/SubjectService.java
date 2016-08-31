package com.hanbit.web.subject;

/**
 * @date     : 2016. 7. 26.
 * @author   : jun
 * @fileName : SubjectService.java
 * @story    :
 */

public interface SubjectService {
	public void insert(SubjectVO bean);
	public SubjectVO findById(String id);
}
