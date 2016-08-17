package com.hanbit.web.grade;

import java.util.List;

public interface GradeService {
	//총 7개의 기본 패턴이 존재
	//exeUpdate
	public int insert(GradeBean bean);
	public int update(GradeBean bean,String subjectName);
	public int delete(GradeBean bean);
	//exeQ
	public List<GradeBean> list();
	public List<GradeBean> findByHakjum(String hakjum);
	public List<GradeBean> findByMonth(String examDate);
	public List<GradeBean> finBySeq(String id);
	public int count(String examDate);

}
