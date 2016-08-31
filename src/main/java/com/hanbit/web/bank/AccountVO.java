/**
 * 
 */
package com.hanbit.web.bank;

import java.io.Serializable;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.hanbit.web.util.Constants;

/**
 * @date     : 2016. 6. 16.
 * @author   : jun.dev
 * @fileName : Account.java
 * @story    : 
 */
@Component
public class AccountVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int accountNO;
	private String name;
	private int money;
	private String bankName;
	private String pw;
	private String id;
	
	public AccountVO(String name,String id, String pw) {
		int max= 999999,min=100000;
		this.accountNO = (int)(Math.random()*max)+min;
		this.name = name;
		this.id = id;
		this.pw = pw;
	}
	/**
	 * 
	 * 
	 * 
	 */
	public AccountVO() {
		//default constructor 기본 생성자
		//생성자 오버로딩 
		
	}
	public void setAccountNO() {
		int max= 999999,min=100000;
		this.accountNO = (int)(Math.random()*max)+min;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMoney(int money) {
		this.money += money;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public void setId(String id){
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getAccountNO() {
		return accountNO;
	}
	public String getName() {
		return name;
	}
	public int getMoney() {
		return money;
	}
	public String getBankName() {
		return bankName;
	}
	public String getPw() {
		return pw;
	}
	public String getId() {
		return id;
	}
	public String deposit(int input){
		return String.valueOf(this.money += input);
	}
	
	public String withdraw(int output){
		return output > this.money ? "잔액이 부족합니다":"출금후 잔액 "+String.valueOf(this.money-=output)+"원입니다.";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	return Constants.BANK_NAME
			+"\n계좌정보 [계좌번호 = "+accountNO
			+ ", 이름 = " + name
			+ ", 잔액 = " + money
			+ ", 비번 = " + pw
			+ ", 아이디 = " + id+"]";
	}
	
}
