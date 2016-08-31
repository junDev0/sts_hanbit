package com.hanbit.web.grade;

import java.util.List;

public interface GradeService {
	//총 7개의 기본 패턴이 존재
	//exeUpdate
	public int insert(GradeVO bean);
	public int update(GradeVO bean,String subjectName);
	public int delete(GradeVO bean);
	//exeQ
	public List<GradeVO> list();
	public List<GradeVO> findByHakjum(String hakjum);
	public List<GradeVO> findByMonth(String examDate);
	public List<GradeVO> findBySeq(String id);
	public int count(String examDate);

}
