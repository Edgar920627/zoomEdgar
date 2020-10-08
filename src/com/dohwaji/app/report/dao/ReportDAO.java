package com.dohwaji.app.report.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.app.bbs.dao.BbsBean;
import com.dohwaji.config.SqlMapConfig;





public class ReportDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;

	public ReportDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	
	
	
	
	
	
	
	// 신고 글 삭제
	public void deleteReport(ReportBean r_bean) {
		sqlsession.update("Report.deleteReport", r_bean);
	}

	
	// 신고글  통과 
	public void passReport(ReportBean r_bean) {
		sqlsession.update("Report.passReport", r_bean);
	}

	
	// 신고 글  여부 확인 체크
	public boolean resultCheck(ReportBean r_bean) {
		boolean check = false;
		if((Integer)sqlsession.selectOne("Report.resultCheck", r_bean) > 0) {
			check = true;
		}
		return check;
	}
	
	
	// report 중복 체크
	public boolean checkReport(ReportBean r_bean) {
		boolean check = false;
		if((Integer)sqlsession.selectOne("Report.checkReport", r_bean) == 1) {
			check = true;
		}
		return check;
	}
	
	
	// 신고 중복 접수 갯수
	public void checkReportCnt(ReportBean r_bean) {
		sqlsession.update("Report.checkReportCnt", r_bean);
	}


	// 신고 접수 갯수
	public int reportCnt(ReportBean r_bean) {
		return sqlsession.selectOne("Report.reportCnt",r_bean);
	}
	
	
	// 선택한  확인중 게시글 갯수
	public int reportDivCnt(String report_result) {
		return sqlsession.selectOne("Report.reportDivCnt",report_result);
	}
	
	

	// 게시글 [이전] [다음] 10개씩 표시		<!-- 신고 전체목록 조회 -->
	public List<ReportBean> listAll(int startRow, int endRow) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		List<ReportBean> reportList = sqlsession.selectList("Report.listAll", pageMap);
		return reportList;
	}
	
	
	// 게시글 [이전] [다음] 10개씩 표시		<!-- 신고  hold 목록 조회 -->
	public List<ReportBean> listResult(int startRow, int endRow, String report_result) {
		HashMap<String, String> pageMap = new HashMap<>();
		pageMap.put("startRow", String.valueOf(startRow));
		pageMap.put("endRow", String.valueOf(endRow));
		pageMap.put("report_result", report_result);
		List<ReportBean> reportList = sqlsession.selectList("Report.listResult", pageMap);
		return reportList;
	}
	
	
	// 게시글 [이전] [다음] 10개씩 표시		<!-- 신고 필터 리스트     (준비중)-->
	public List<ReportBean> listFilter(int startRow, int endRow, String report_result, String report_type, String report_div) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		List<ReportBean> reportList = sqlsession.selectList("Report.listFilter", pageMap);
		return reportList;
	}
	



	// 게시글 등록
	public boolean insertReport(ReportBean r_bean) {
		boolean check = false;
		if (sqlsession.insert("Report.insertReport", r_bean) == 1) {
			check = true;
		}
		return check;
	}
	




}
