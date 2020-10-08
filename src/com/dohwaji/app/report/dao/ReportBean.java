package com.dohwaji.app.report.dao;

public class ReportBean {

	private int report_num;
	private String report_type;		// 게시글 , 댓글
	private int pk_num;				// pk 번호
	private String report_div;		// 홍보글, 19 음란물, 기타
	private String user_id;			// 신고당한자
	private String report_id;		// 신고자
	private String report_contents;	// 내용
	private String report_result;	// 통과, 실패   Hold   &  pass  & delete 
	private String report_date;		// 날짜
	private int report_cnt;			// 신고 중복 접수 갯수
	
	
	
	public ReportBean() {
		// TODO Auto-generated constructor stub
	}
	
	

	public int getReport_cnt() {
		return report_cnt;
	}



	public void setReport_cnt(int report_cnt) {
		this.report_cnt = report_cnt;
	}



	public String getReport_id() {
		return report_id;
	}



	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}



	public int getReport_num() {
		return report_num;
	}

	public void setReport_num(int report_num) {
		this.report_num = report_num;
	}

	
	public String getReport_type() {
		return report_type;
	}



	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}



	public int getPk_num() {
		return pk_num;
	}



	public void setPk_num(int pk_num) {
		this.pk_num = pk_num;
	}



	public String getReport_div() {
		return report_div;
	}

	public void setReport_div(String report_div) {
		this.report_div = report_div;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getReport_contents() {
		return report_contents;
	}

	public void setReport_contents(String report_contents) {
		this.report_contents = report_contents;
	}

	public String getReport_result() {
		return report_result;
	}

	public void setReport_result(String report_result) {
		this.report_result = report_result;
	}

	public String getReport_date() {
		return report_date;
	}

	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}

}
