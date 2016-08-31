package com.hanbit.web.bank;

import java.text.SimpleDateFormat;

/**
 * @date     : 2016. 7. 6.
 * @author   : jun
 * @fileName : BigBean.java
 * @story    :
 */

public class AccountMemberVO {	
	private int accountNO,money,age;
	private String name,bankName,id,pw,regDate,gender,ssn,modifyPw;
	
	public AccountMemberVO(String name,String id, String pw,String ssn) {
		int max= 999999,min=100000;
		this.accountNO = (int)(Math.random()*max)+min;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.ssn = ssn;
		genderResult(ssn);

	}

	public AccountMemberVO(int accountNo,int money,String id,String pw,String name,String regDate,String ssn) {
		this.accountNO = accountNo;
		this.money = money;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.regDate = regDate;
		this.ssn = ssn;
		genderResult(ssn);

	}	
	public AccountMemberVO() {
		// TODO Auto-generated constructor stub
	}
	public int getAccountNO() {
		return accountNO;
	}
	public void setAccountNO(int accountNO) {
		this.accountNO = accountNO;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getModifyPw() {
		return modifyPw;
	}
	public void setModifyPw(String modifyPw) {
		this.modifyPw = modifyPw;
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
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String deposit(int input){
		return String.valueOf(this.money += input);
	}
	public String withdraw(int output){
		return output > this.money ? "잔액이 부족합니다":"출금후 잔액 "+String.valueOf(this.money-=output)+"원입니다.";
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
		
	}

	@Override
	public String toString() {
		return "계좌번호:" + accountNO + ", 잔액:" + money + "원, 이름:" + name + ", ID:" + id
				+ ", 나이:" + age + "]";
	}
}
