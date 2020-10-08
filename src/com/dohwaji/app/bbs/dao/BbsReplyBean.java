package com.dohwaji.app.bbs.dao;

public class BbsReplyBean {
	
//	댓글 번호	reply_num
//	게시글번호	bbs_num
//	아이디		user_id
//	댓글 내용	reply_write
//	댓글 날짜	reply_date
//	댓글 별점	reply_stars
//	댓글 추천	reply_likeCnt
//	댓글 비추천	reply_hateCnt
//	댓글추천여부	reply_check
//	COMMENT_POINT	별점 점수

	
	private int reply_num;
	private int bbs_num;
	private String user_id;
	private String reply_write;
	private String reply_date;
	private int reply_point;
	private int reply_likeCnt;
	private int reply_hateCnt;
	private String reply_likeCheck;
	private String reply_stars;
	
	
	public String getReply_stars() {
		return reply_stars;
	}


	public void setReply_stars(String reply_stars) {
		this.reply_stars = reply_stars;
	}


	public BbsReplyBean() {;}


	public int getReply_num() {
		return reply_num;
	}


	public void setReply_num(int reply_num) {
		this.reply_num = reply_num;
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


	public String getReply_write() {
		return reply_write;
	}


	public void setReply_write(String reply_write) {
		this.reply_write = reply_write;
	}


	public String getReply_date() {
		return reply_date;
	}


	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}



	public int getReply_likeCnt() {
		return reply_likeCnt;
	}


	public void setReply_likeCnt(int reply_likeCnt) {
		this.reply_likeCnt = reply_likeCnt;
	}


	public int getReply_hateCnt() {
		return reply_hateCnt;
	}


	public void setReply_hateCnt(int reply_hateCnt) {
		this.reply_hateCnt = reply_hateCnt;
	}


	public int getReply_point() {
		return reply_point;
	}


	public void setReply_point(int reply_point) {
		this.reply_point = reply_point;
	}


	public String getReply_likeCheck() {
		return reply_likeCheck;
	}


	public void setReply_likeCheck(String reply_likeCheck) {
		this.reply_likeCheck = reply_likeCheck;
	}



	
	
	

}
