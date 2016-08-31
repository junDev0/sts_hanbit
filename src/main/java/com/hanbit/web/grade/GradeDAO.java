package com.hanbit.web.grade;

import java.util.List;

public interface GradeDAO {
	public int insert(GradeVO bean);
	public int update(GradeVO bean,String str);
	public int delete(GradeVO bean);
	public GradeVO updateInfo(GradeVO bean);
	
	public List<GradeVO> list();
	public List<GradeVO> findBySeq(String id);
	public List<GradeVO> findByHakjum(String hakjum);
	public List<GradeVO> findByMonth(String examDate);
	public int count(String examDate);
	
}
