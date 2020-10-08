package com.dohwaji.app.bbs.dao;

import java.util.HashMap;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import com.dohwaji.config.SqlMapConfig;

public class BbsDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;

	public BbsDAO() {
		sqlsession = sessionf.openSession(true);
	}

	
	
	// 게시글 일련번호 목록
	public List<BbsBean> listBbs_num(String user_id) {	
		List<BbsBean> bbs_numList = sqlsession.selectList("Bbs.listBbs_num",user_id);
		return bbs_numList;
	}
	
	
// 게시판 별점
	public void bbsStars(BbsBean bbsBean) {
		sqlsession.update("Bbs.bbsStars", bbsBean);
	}

	
	
	// 게시글 수정
	public void updateBbs(BbsBean bbsBean) {
		sqlsession.update("Bbs.updateBbs", bbsBean);
	}

	
	// 공지사항 글 갯수
	public int noticeCnt() {
		return sqlsession.selectOne("Bbs.noticeCnt");
	}
	
	
	
	// 선택한 '대 분류' 게시글 갯수
	public int getBbsMainDivCnt(String bbs_maindiv) {
		return sqlsession.selectOne("Bbs.getBbsMainDivCnt",bbs_maindiv);
	}

	
	// 전체 게시글 갯수
	public int getBbsCnt() {
		return sqlsession.selectOne("Bbs.getBbsCnt");
	}
	
	
	
	
//	공지사항 목록
	public List<BbsBean> noticeBbs() {
		List<BbsBean> noticeList = sqlsession.selectList("Bbs.noticeBbs");
		return noticeList;
	}
	
//	(대+소 분류, 제목+내용+글쓴이 , 조회순) 
	public List<BbsBean> divAllRead(int startRow, int endRow, String bbs_maindiv, String bbs_smalldiv, String bbs_title, String bbs_explanation, String user_id) {
		HashMap<String, String> pageMap = new HashMap<>();
		pageMap.put("startRow", String.valueOf(startRow));
		pageMap.put("endRow", String.valueOf(endRow));
		pageMap.put("bbs_maindiv", bbs_maindiv);
		pageMap.put("bbs_smalldiv", bbs_smalldiv);
		pageMap.put("bbs_title", bbs_title);
		pageMap.put("bbs_explanation", bbs_explanation);
		pageMap.put("user_id", user_id);
		List<BbsBean> divAllReadList = sqlsession.selectList("Bbs.divAllRead", pageMap);
		return divAllReadList;
	}
	
	
//	(대+소 분류, 제목+내용+글쓴이 , 조회순) 
	public List<BbsBean> divRead(int startRow, int endRow, String bbs_maindiv, String bbs_smalldiv, String bbs_title, String bbs_explanation, String user_id) {
		
		HashMap<String, String> pageMap = new HashMap<>();
		pageMap.put("startRow", String.valueOf(startRow));
		pageMap.put("endRow", String.valueOf(endRow));
		pageMap.put("bbs_maindiv", bbs_maindiv);
		pageMap.put("bbs_smalldiv", bbs_smalldiv);
		pageMap.put("bbs_title", bbs_title);
		pageMap.put("bbs_explanation", bbs_explanation);
		pageMap.put("user_id", user_id);
		List<BbsBean> divReadList = sqlsession.selectList("Bbs.divRead", pageMap);
		return divReadList;
	}
	
	
	
	
	
//	(대+소 분류, 제목+내용+글쓴이 , 최신순) 
	public List<BbsBean> divAllLatest(int startRow, int endRow, String bbs_maindiv, String bbs_smalldiv, String bbs_title, String bbs_explanation, String user_id) {
		HashMap<String, String> pageMap = new HashMap<>();
		pageMap.put("startRow", String.valueOf(startRow));
		pageMap.put("endRow", String.valueOf(endRow));
		pageMap.put("bbs_maindiv", bbs_maindiv);
		pageMap.put("bbs_smalldiv", bbs_smalldiv);
		pageMap.put("bbs_title", bbs_title);
		pageMap.put("bbs_explanation", bbs_explanation);
		pageMap.put("user_id", user_id);
		List<BbsBean> divAllReadList = sqlsession.selectList("Bbs.divAllLatest", pageMap);
		return divAllReadList;
	}
	
	
//	(대+소 분류, 제목+내용+글쓴이 , 최신순) 
	public List<BbsBean> divLatest(int startRow, int endRow, String bbs_maindiv, String bbs_smalldiv, String bbs_title, String bbs_explanation, String user_id) {
		HashMap<String, String> pageMap = new HashMap<>();
		pageMap.put("startRow", String.valueOf(startRow));
		pageMap.put("endRow", String.valueOf(endRow));
		pageMap.put("bbs_maindiv", bbs_maindiv);
		pageMap.put("bbs_smalldiv", bbs_smalldiv);
		pageMap.put("bbs_title", bbs_title);
		pageMap.put("bbs_explanation", bbs_explanation);
		pageMap.put("user_id", user_id);
		List<BbsBean> divReadList = sqlsession.selectList("Bbs.divLatest", pageMap);
		return divReadList;
	}
	
	
	
	
	
	
	
//	(대+소 분류, 제목+내용+글쓴이 , 추천순) 
	public List<BbsBean> divAllLikeCount(int startRow, int endRow, String bbs_maindiv, String bbs_smalldiv, String bbs_title, String bbs_explanation, String user_id) {
		HashMap<String, String> pageMap = new HashMap<>();
		pageMap.put("startRow", String.valueOf(startRow));
		pageMap.put("endRow", String.valueOf(endRow));
		pageMap.put("bbs_maindiv", bbs_maindiv);
		pageMap.put("bbs_smalldiv", bbs_smalldiv);
		pageMap.put("bbs_title", bbs_title);
		pageMap.put("bbs_explanation", bbs_explanation);
		pageMap.put("user_id", user_id);
		List<BbsBean> divAllReadList = sqlsession.selectList("Bbs.divAllLikeCount", pageMap);
		return divAllReadList;
	}
	
	
//	(대+소 분류, 제목+내용+글쓴이 , 추천순) 
	public List<BbsBean> divLikeCount(int startRow, int endRow, String bbs_maindiv, String bbs_smalldiv, String bbs_title, String bbs_explanation, String user_id) {
		HashMap<String, String> pageMap = new HashMap<>();
		pageMap.put("startRow", String.valueOf(startRow));
		pageMap.put("endRow", String.valueOf(endRow));
		pageMap.put("bbs_maindiv", bbs_maindiv);
		pageMap.put("bbs_smalldiv", bbs_smalldiv);
		pageMap.put("bbs_title", bbs_title);
		pageMap.put("bbs_explanation", bbs_explanation);
		pageMap.put("user_id", user_id);
		List<BbsBean> divReadList = sqlsession.selectList("Bbs.divLikeCount", pageMap);
		return divReadList;
	}
	
	
	

	
	

	// 게시글 [이전] [다음] 10개씩 표시
	// 대 분류 게시물 리스트
	public List<BbsBean> listMainDivAll(int startRow, int endRow, String bbs_maindiv) {

		HashMap<String, String> pageMap = new HashMap<>();
		pageMap.put("startRow", String.valueOf(startRow));
		pageMap.put("endRow", String.valueOf(endRow));
		pageMap.put("bbs_maindiv", bbs_maindiv);		
		List<BbsBean> bbsMainDiv = sqlsession.selectList("Bbs.listMainDivAll", pageMap);

		return bbsMainDiv;
	}
	
	

	// 게시글 [이전] [다음] 10개씩 표시
	public List<BbsBean> getBbsList(int startRow, int endRow, String bbs_title, String bbs_explanation, String user_id) {
		HashMap<String, String> pageMap = new HashMap<>();
		pageMap.put("startRow", String.valueOf(startRow));
		pageMap.put("endRow", String.valueOf(endRow));
		pageMap.put("bbs_title", bbs_title);
		pageMap.put("bbs_explanation", bbs_explanation);
		pageMap.put("user_id", user_id);
		List<BbsBean> bbsList = sqlsession.selectList("Bbs.listAll", pageMap);

		return bbsList;
	}

	// 내림차순으로 게시글 보기
	public int getBbsSeq() {
		return sqlsession.selectOne("Bbs.getBbsSeq");
	}

	// 게시글 등록
	public boolean insertBbs(BbsBean bbsBean) {
		boolean check = false;
		if (sqlsession.insert("Bbs.insertBbs", bbsBean) == 1) {
			check = true;
		}
		return check;
	}

	// 해당 게시글 상세보기
	public BbsBean getBbsDetail(int bbs_num) {
		return sqlsession.selectOne("Bbs.getBbsDetail", bbs_num);
	}
	
	

	// 게시글 클릭시 조회수 +1 증가
	public void readCount(int bbs_num) {
		sqlsession.update("Bbs.readCount", bbs_num);
	}

	// 삭제
	public void deleteBbs(int bbs_num) {
		sqlsession.delete("Bbs.deleteBbs", bbs_num);
	}
	
	// 회원탈퇴  게시글 전체 삭제
	public void deleteMemberBbs(String user_id) {
		sqlsession.delete("Bbs.deleteMemberBbs", user_id);
	}

}
