package com.hanbit.web.grade;

import java.io.Serializable;

/**
 * @date     : 2016. 6. 21.
 * @author   : jun.dev
 * @fileName : GradeBean.java
 * @story    : 
 */
public class GradeVO implements Serializable { 
	private static final long serialVersionUID = 1L;
	private String seq,id,grade,examDate;
	private int java,sql,html,javascript;


	public GradeVO(String id,int java, int sql, int html, int javascript, String examDate) {
		this.id = id;
		this.java = java;
		this.sql = sql;
		this.html = html;
		this.javascript = javascript;
		this.examDate = examDate;
	}
	public GradeVO(String seq,String grade,String id,int java, int sql, int html, int javascript, String examDate) {
		this.seq = seq;
		this.grade = grade;
		this.id = id;
		this.java = java;
		this.sql = sql;
		this.html = html;
		this.javascript = javascript;
		this.examDate = examDate;
	}
	public GradeVO() {
		// TODO Auto-generated constructor stub
	}
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getSql() {
		return sql;
	}

	public void setSql(int sql) {
		this.sql = sql;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}

	public int getJavascript() {
		return javascript;
	}

	public void setJavascript(int javascript) {
		this.javascript = javascript;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	

	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	@Override
	public String toString() {
		return "GradeBean [No."+seq+" ,아이디=" + id + ", 학점=" + grade + "\n 자바=" + java + ", SQL=" + sql + ", HTML5=" + html
				+ ", 자바스크립트=" + javascript + "]";
	}


	
	
	
	
}
