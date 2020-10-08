package com.dohwaji.app.bbs.dao;

public class BbsBean {
	
	
	
	/*
	 * 넘버
	 * 유저 아이디
	 * 분류1
	 * 분류2
	 * 제목
	 * 내용
	 * 추천
	 * 추천체크
	 * 조회수
	 * 날짜
	 * 
	 * 
	 */
	

	private int bbs_num;
	private String user_id;
	private String bbs_maindiv;
	private String bbs_smalldiv;
	private String bbs_title;
	private String bbs_explanation;
	private int bbs_likeCount;
	private String bbs_likeCheck;
	private int bbs_readcount;
	private String bbs_date;
	
	private String avgPoint;
	private int commentCount = 0;
	private int avgValue     = 0;
	
	private int pointCount0  = 0;
	private int pointCount1  = 0;
	private int pointCount2  = 0;
	private int pointCount3  = 0;	
	private int pointCount4  = 0;
	private int pointCount5  = 0; 
	
	
	
	
	
	
	public int getPointCount0() {
		return pointCount0;
	}


	public void setPointCount0(int pointCount0) {
		this.pointCount0 = pointCount0;
	}
	
	public BbsBean() {;}
	
	
	public String getAvgPoint() {
		return avgPoint;
	}


	public void setAvgPoint(String avgPoint) {
		this.avgPoint = avgPoint;
	}


	public int getCommentCount() {
		return commentCount;
	}


	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}


	public int getAvgValue() {
		return avgValue;
	}


	public void setAvgValue(int avgValue) {
		this.avgValue = avgValue;
	}


	public int getPointCount1() {
		return pointCount1;
	}


	public void setPointCount1(int pointCount1) {
		this.pointCount1 = pointCount1;
	}


	public int getPointCount2() {
		return pointCount2;
	}


	public void setPointCount2(int pointCount2) {
		this.pointCount2 = pointCount2;
	}


	public int getPointCount3() {
		return pointCount3;
	}


	public void setPointCount3(int pointCount3) {
		this.pointCount3 = pointCount3;
	}


	public int getPointCount4() {
		return pointCount4;
	}


	public void setPointCount4(int pointCount4) {
		this.pointCount4 = pointCount4;
	}


	public int getPointCount5() {
		return pointCount5;
	}


	public void setPointCount5(int pointCount5) {
		this.pointCount5 = pointCount5;
	}





	public int getBbs_num() {
		return bbs_num;
	}


	public void setBbs_num(int bbs_num) {
		this.bbs_num = bbs_num;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getBbs_maindiv() {
		return bbs_maindiv;
	}


	public void setBbs_maindiv(String bbs_maindiv) {
		this.bbs_maindiv = bbs_maindiv;
	}


	public String getBbs_smalldiv() {
		return bbs_smalldiv;
	}


	public void setBbs_smalldiv(String bbs_smalldiv) {
		this.bbs_smalldiv = bbs_smalldiv;
	}


	public String getBbs_title() {
		return bbs_title;
	}


	public void setBbs_title(String bbs_title) {
		this.bbs_title = bbs_title;
	}


	public String getBbs_explanation() {
		return bbs_explanation;
	}


	public void setBbs_explanation(String bbs_explanation) {
		this.bbs_explanation = bbs_explanation;
	}


	public int getBbs_likeCount() {
		return bbs_likeCount;
	}


	public void setBbs_likeCount(int bbs_likeCount) {
		this.bbs_likeCount = bbs_likeCount;
	}


	public String getBbs_likeCheck() {
		return bbs_likeCheck;
	}


	public void setBbs_likeCheck(String bbs_likeCheck) {
		this.bbs_likeCheck = bbs_likeCheck;
	}


	public int getBbs_readcount() {
		return bbs_readcount;
	}


	public void setBbs_readcount(int bbs_readcount) {
		this.bbs_readcount = bbs_readcount;
	}


	public String getBbs_date() {
		return bbs_date;
	}


	public void setBbs_date(String bbs_date) {
		this.bbs_date = bbs_date;
	}


	
	

}
