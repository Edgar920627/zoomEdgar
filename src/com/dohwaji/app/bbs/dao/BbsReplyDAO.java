package com.dohwaji.app.bbs.dao;

import java.util.HashMap;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import com.dohwaji.config.SqlMapConfig;

public class BbsReplyDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;

	public BbsReplyDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	
	
	
	
	// 댓글 일련번호 목록
	public List<BbsReplyBean> listReply_num(String user_id) {	
		List<BbsReplyBean> reply_numList = sqlsession.selectList("BbsReply.listReply_num",user_id);
		return reply_numList;
	}
	
	
	
	// 추천 카운터
	public void likeCnt(BbsReplyBean bbsReplyBean) {
		sqlsession.update("BbsReply.likeCnt", bbsReplyBean);
	}
	
	
	
	// 댓글 추천여부 검사
	public int like_check(Map<String, Object> m) {
		int result = 0;
		result = (Integer) sqlsession.selectOne("BbsReply.like_check", m);
		return result;
	}

	// 댓글 추천
	public void like_update(Map<String, Object> m) {
		sqlsession.insert("BbsReply.like_update", m);
	}

	
	
	
	// id 로 댓글 삭제 
	public void idReplydel(String user_id) {
		sqlsession.delete("BbsReply.idReplydel", user_id);
	}
	
	// 게시글 추천 전체 삭제
	public void bbs_delete(int bbs_num) {
		sqlsession.delete("BbsReply.bbs_delete", bbs_num);
	}
	
	// 댓글 추천  삭제
	public void replyLikeDel(int reply_num) {
		sqlsession.delete("BbsReply.replyLikeDel", reply_num);
	}
	

	
	// 댓글 추천 전체 삭제
	public void reply_delete(Map<String, Object> m) {
		sqlsession.delete("BbsReply.reply_delete", m);
	}
	
	
	// 댓글 추천 제거
	public void like_delete(Map<String, Object> m) {
		sqlsession.delete("BbsReply.like_delete", m);
	}

	
	// 댓글 추천수
	public int like_count(int reply_num) {
		int count = 0;
		count = (Integer) sqlsession.selectOne("BbsReply.like_count", reply_num);
		return count;
	}
	
	
	//  [이전] [다음] 10개씩   + 댓글 리스트 + 별점 순
	public List<BbsReplyBean> replyStarList(int startRow, int endRow, int bbs_num) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("bbs_num", bbs_num);
		List<BbsReplyBean> replyStarList = sqlsession.selectList("BbsReply.replyStarList", pageMap);
		return replyStarList;
	}
	
	
	//  [이전] [다음] 10개씩   + 댓글 리스트 + 추천순
	public List<BbsReplyBean> replyLikeCntList(int startRow, int endRow, int bbs_num) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("bbs_num", bbs_num);
		List<BbsReplyBean> replyLikeList = sqlsession.selectList("BbsReply.replyLikeCntList", pageMap);
		return replyLikeList;
	}
	
	
	
	//  [이전] [다음] 10개씩   + 댓글 리스트 + 최신순
	public List<BbsReplyBean> getBbsReplyList(int startRow, int endRow, int bbs_num) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("bbs_num", bbs_num);
		List<BbsReplyBean> bbsReplyList = sqlsession.selectList("BbsReply.getBbsReplyList", pageMap);
		return bbsReplyList;
	}


	
	// 댓글 전체 삭제
	public void deleteReply(int bbs_num) {
		sqlsession.delete("BbsReply.deleteReply", bbs_num);
	}
	
	
	// 댓글 한개 삭제
	public void deleteOneReply(int reply_num) {
		sqlsession.delete("BbsReply.deleteOneReply", reply_num);
	}

	// 댓글 갯수
	public int getBbsReplyCnt(int bbs_num) {
		return sqlsession.selectOne("BbsReply.getBbsReplyCnt",bbs_num);
	}
	
	
	
	// 별점 별 0점
	public int starZeroCnt(int bbs_num) {
		return sqlsession.selectOne("BbsReply.starZeroCnt",bbs_num);
	}
	// 별점 별 1점
	public int starOneCnt(int bbs_num) {
		return sqlsession.selectOne("BbsReply.starOneCnt",bbs_num);
	}
	// 별점 별 2점
	public int starTwoCnt(int bbs_num) {
		return sqlsession.selectOne("BbsReply.starTwoCnt",bbs_num);
	}
	// 별점 별 3점
	public int starThreeCnt(int bbs_num) {
		return sqlsession.selectOne("BbsReply.starThreeCnt",bbs_num);
	}
	// 별점 별 4점
	public int starFourCnt(int bbs_num) {
		return sqlsession.selectOne("BbsReply.starFourCnt",bbs_num);
	}
	// 별점 별 5점
	public int starFiveCnt(int bbs_num) {
		return sqlsession.selectOne("BbsReply.starFiveCnt",bbs_num);
	}
	
	
	
	// 댓글 리스트 
	public List<BbsReplyBean> getBbsReply(int bbs_num) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		pageMap.put("bbs_num", bbs_num);
		List<BbsReplyBean> replyList = sqlsession.selectList("BbsReply.getBbsReply", pageMap);
		return replyList;
	}
	
	
	
	
	// 댓글 등록
	public boolean insertBbsReply(BbsReplyBean bbsReplyBean) {
		boolean check = false;
		if(sqlsession.insert("BbsReply.insertBbsReply", bbsReplyBean) == 1) {
			check = true;
		}
		return check;
	}
	
	

	
	
	
	

}
