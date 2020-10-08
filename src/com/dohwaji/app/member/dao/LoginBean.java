package com.dohwaji.app.member.dao;

public class LoginBean {
	
//	login_num NUMBER(10) PRIMARY KEY,
//	user_id VARCHAR2(100),
//	login_check CHAR(1) CONSTRAINT booleantest_login_check CHECK (login_check = '0' OR login_check = '1'),
//	login_ip VARCHAR2(100),
//	login_date DATE
	
	
	
	private int login_num;
	private String user_id;
	private String login_check;
	private String login_ip;
	private String login_date;
	
	
	
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}
	
	public int getLogin_num() {
		return login_num;
	}
	public void setLogin_num(int login_num) {
		this.login_num = login_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getLogin_check() {
		return login_check;
	}
	public void setLogin_check(String login_check) {
		this.login_check = login_check;
	}
	public String getLogin_ip() {
		return login_ip;
	}
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	public String getLogin_date() {
		return login_date;
	}
	public void setLogin_date(String login_date) {
		this.login_date = login_date;
	}
	
	
	

}
