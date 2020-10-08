package com.dohwaji.app.member.dao;

public class MemberBean {

	
	/**
	 * 		넘버
	 * 		아이디(pk)
	 * 		비번
	 * 		닉네임
	 * 		이메일
	 * 		이메일 해쉬 
	 * 		이메일 체크
	 * 		날짜
	 */
	
	private int user_num;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_email;
	private String user_email_hash;
	private String user_email_checked;
	private String user_date;
	
	
	public MemberBean() {;}


	public int getUser_num() {
		return user_num;
	}


	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_pw() {
		return user_pw;
	}


	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_date() {
		return user_date;
	}


	public String getUser_email_hash() {
		return user_email_hash;
	}

	public void setUser_email_hash(String user_email_hash) {
		this.user_email_hash = user_email_hash;
	}

	public String getUser_email_checked() {
		return user_email_checked;
	}


	public void setUser_email_checked(String user_email_checked) {
		this.user_email_checked = user_email_checked;
	}


	public void setUser_date(String user_date) {
		this.user_date = user_date;
	}
	
	
	

	
}
