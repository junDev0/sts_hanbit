package com.hanbit.web.grade;

import java.util.List;

import javax.swing.JOptionPane;

public class GradeServiceImpl implements GradeService {
	
	GradeBean bean;
	GradeDAO dao = GradeDAO.getInstance();
	private static GradeServiceImpl instance= new GradeServiceImpl(); 
	
	public static GradeServiceImpl getInstance() {
		return instance;
	}

	private GradeServiceImpl() {
	}
	
	@Override
	public int insert(GradeBean bean) {
		bean.setGrade(gradeRank(bean));
		return 	dao.insert(bean);
	}
		
		// 학점 구하기
		public String gradeRank(GradeBean bean) {
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
	public int update(GradeBean bean,String subjectName) {
		GradeBean bean2 = new GradeBean();
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
	public int delete(GradeBean bean) {
		System.out.println(bean.getSeq());
		return dao.delete(bean);
	}

	@Override
	public List<GradeBean> list() {
		return dao.list();
	}

	@Override
	public List<GradeBean> findByHakjum(String hakjum) {
		
		return dao.findByHakjum(hakjum);
	}

	@Override
	public List<GradeBean> finBySeq(String id) {
		return dao.findBySeq(id);
	}

	@Override
	public int count(String examDate) {
		return dao.count(examDate);
	}

	@Override
	public List<GradeBean> findByMonth(String examDate) {
		// TODO Auto-generated method stub
		return dao.findByMonth(examDate);
	}
	
	






}
