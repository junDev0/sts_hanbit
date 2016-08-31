package com.hanbit.web.grade;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Service;
@Service
public class GradeServiceImpl implements GradeService {
	
	GradeVO bean;
	private GradeDAOImpl dao;
	private static GradeServiceImpl instance= new GradeServiceImpl(); 
	
	public static GradeServiceImpl getInstance() {
		return instance;
	}

	private GradeServiceImpl() {
		dao = GradeDAOImpl.getInstance();
	}
	
	@Override
	public int insert(GradeVO bean) {
		bean.setGrade(gradeRank(bean));
		return 	dao.insert(bean);
	}
		
		// 학점 구하기
		public String gradeRank(GradeVO bean) {
			int gradeTotal = bean.getJava() + bean.getHtml() + bean.getSql() + bean.getJavascript();
			int gradeAvg = gradeTotal/4;
			String result = "";
			if (gradeAvg >= 90) {
				result = "A";
			} else if (gradeAvg >= 80) {
				result = "B";
			} else if (gradeAvg >= 70) {
				result = "C";
			} else if (gradeAvg >= 60) {
				result = "D";
			} else if (gradeAvg >= 50) {
				result = "E";
			} else if (gradeAvg >= 49) {
				result = "F";
			} else {
			}
			
			return result;
		}

	
	
	@Override
	public int update(GradeVO bean,String subjectName) {
		GradeVO bean2 = new GradeVO();
		bean2 = dao.updateInfo(bean);
		switch (subjectName) {
		case "자바":bean2.setJava(bean.getJava());break;
		case "SQL":bean2.setSql(bean.getSql());break;
		case "HTML5":bean2.setHtml(bean.getHtml());break;
		case "자바스크립트":bean2.setJavascript(bean.getJavascript());break;
		}
		bean2.setGrade(gradeRank(bean2));
		return dao.update(bean2, subjectName);
	}

	@Override
	public int delete(GradeVO bean) {
		System.out.println(bean.getSeq());
		return dao.delete(bean);
	}

	@Override
	public List<GradeVO> list() {
		return dao.list();
	}

	@Override
	public List<GradeVO> findByHakjum(String hakjum) {
		
		return dao.findByHakjum(hakjum);
	}

	@Override
	public List<GradeVO> findBySeq(String id) {
		return dao.findBySeq(id);
	}

	@Override
	public int count(String examDate) {
		return dao.count(examDate);
	}

	@Override
	public List<GradeVO> findByMonth(String examDate) {
		// TODO Auto-generated method stub
		return dao.findByMonth(examDate);
	}
	
	






}
