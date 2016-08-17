/**
 * 
 */
package com.hanbit.web.member;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * @date     : 2016. 6. 16.
 * @author   : jun.dev
 * @fileName : student.java
 * @story    : 
 */
public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id,pw,name,regDate,gender,ssn,profileImg,email,phone,subject,major;  //+폰번호
	private int age,java,sql,html,javascript,score;

	public MemberBean(String name,String id, String pw,  String ssn,String regDate,String email,String profileImg,String phone) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.ssn = ssn;
		this.regDate =regDate;
		this.email = email;
		this.profileImg = profileImg;
		this.phone = phone;
		genderResult(ssn); //성별, 나이 계산
	}
	public void JspBean(String name,String id, String pw,  String ssn,String email) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.ssn = ssn;
		this.email = email;
		this.regDate =new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
		genderResult(ssn); //성별, 나이 계산
	}
	
	public MemberBean() {
		// TODO Auto-generated constructor stub
	}
	public String getPw() {
		return pw;
	}
	public String getId(){
		return id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getName(){
		return name;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) { //gender 와 age 는 통합형
		this.gender = gender;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
		if(ssn != null || ssn.isEmpty()|| ssn.equals("")){
		genderResult(ssn);
		}
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void genderResult(String ssn){ //주민번호를 파라미터로 받아 나이 및 성별을 구하는 메소드
		
		/*
		ssn = ssn.substring(7);
		this.gender = "남자";
		if(Integer.parseInt(ssn)%2==0){
			this.gender = "여자";
		}
		*/
		// 주민번호 ex)881010-1 을 split으로 "-"를 기준 나누어서 
		//Num[0] = "881010" Num[1]="1" 나눈다.   
		String [] Num= new String [2];
		Num = ssn.split("-");
		
		//성별구분 
		switch (Integer.parseInt(Num[1])%2) {
		case 0:	this.gender = "여자";
			break;

		default:this.gender = "남자";
			break;
		}
		
		//나이구분 substring은 문자열 변수로 사용가능 charAt과 유사한 기능을함
		//ex) apple 를 substring을 사용할경우
		//substring(3) 숫자를 하나 넣었을 경우 해당 자릿수의 문자를 가져옴 결과)l
		//substring(0,2) 숫자를 두개 넣었을 경우 앞자리는 시작범위, 뒷자리는 마지막범위 결과)app 
		Num[0] = Num[0].substring(0, 2);
		int userYear = 1900+Integer.parseInt(Num[0]);
		if(Num[1].equals("3")||Num[1].equals("4")){
			userYear = 2000+Integer.parseInt(Num[0]);
		}
		

		String currentYear = new SimpleDateFormat("yyyy").format(System.currentTimeMillis()); 
		this.age =Integer.parseInt(currentYear)-userYear;
		
		this.regDate =new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());

		}
	

	@Override
	public String toString() {
		return "학생 [아이디=" + id + ", 비번= ****, 이름=" + name + ", 등록일=" + regDate + ", 성별=" + gender
				+ ", 주민번호=" + ssn + ", 나이=" + age + "]";
	}
	
}
