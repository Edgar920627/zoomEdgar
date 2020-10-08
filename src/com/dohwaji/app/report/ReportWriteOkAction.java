package com.dohwaji.app.report;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bbs.dao.BbsBean;
import com.dohwaji.app.bbs.dao.BbsDAO;
import com.dohwaji.app.bbs.dao.BbsFilesDAO;
import com.dohwaji.app.bbs.dao.BbsReplyBean;
import com.dohwaji.app.bbs.dao.BbsReplyDAO;
import com.dohwaji.app.report.dao.ReportBean;
import com.dohwaji.app.report.dao.ReportDAO;


public class ReportWriteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();

		
		BbsBean b_bean = new BbsBean();
		BbsDAO b_dao = new BbsDAO();
		BbsFilesDAO bf_dao = new BbsFilesDAO();
		BbsReplyBean br_bean = new BbsReplyBean();
		BbsReplyDAO br_dao = new BbsReplyDAO();
		
		ReportBean r_bean = new ReportBean();
		ReportDAO r_dao = new ReportDAO();
		
		boolean r_result = false;
		boolean f_result = false;

		
		
		// reuest
		String report_id = (String) request.getSession().getAttribute("session_id");
		String user_id = request.getParameter("user_id");
		int bbs_num = Integer.parseInt(request.getParameter("bbs_num"));
		int pk_num = Integer.parseInt(request.getParameter("pk_num"));
		String report_type = request.getParameter("report_type");
		String report_div = request.getParameter("report_div");

		
		// 삭제 패스 보류  선택
		String report_result = "확인중";
		
		
		
		// 데이터  set 입력 
		r_bean.setPk_num(pk_num);
		r_bean.setReport_div(report_div);
		r_bean.setReport_type(report_type);
		r_bean.setReport_id(report_id);
		r_bean.setReport_result(report_result);
		r_bean.setUser_id(user_id);
		

		r_dao.checkReport(r_bean);
		
		
		
		
		
		

		
		System.out.println(" [ r_bean.getPk_num() ] = "+r_bean.getPk_num());
		System.out.println(" [ r_bean.getReport_div() ] = "+r_bean.getReport_div());
		System.out.println(" [ r_bean.getReport_id() ] = "+r_bean.getReport_id());
		System.out.println(" [ r_bean.getReport_type() ] = "+r_bean.getReport_type());
		System.out.println(" [ r_bean.getReport_result() ] = "+r_bean.getReport_result());

		System.out.println(r_dao.checkReport(r_bean));
		
		

		
		if(r_dao.checkReport(r_bean)) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('이미 신고 했습니다.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		
		
		
		// 신고당한자 id 없음
		if(r_bean.getUser_id() == "") {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('신고 실패  ID 없습니다.');history.back();");
			out.println("</script>");
			out.close();
			return null;
	
		}
		
		// 신고자 id 없음
		if(r_bean.getReport_id() == "") {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('신고 실패  신고자 없습니다.');history.back();");
			out.println("</script>");
			out.close();
			return null;
	
		}

		
		
		// 신고 등록
		r_result = r_dao.insertReport(r_bean);
		


		
		if (!r_result) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('게시글 수정 실패. 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
			return null;

		}
		
		
		
		// 신고 중복 접수글 갯수 
		System.out.println(report_type);
		System.out.println(pk_num);
		int report_cnt = r_dao.reportCnt(r_bean);
		
		
		// 신고 중복 접수 갯수
		r_bean.setReport_cnt(report_cnt);
		
		
		// 신고 중복 접수 갯수
		r_dao.checkReportCnt(r_bean);
		

		
		

		
		// 관리자 admin 경로 
		if(report_id.equals("admin")) {
			
			
			System.out.println("admin report_id = " + report_id);
			
         forward.setRedirect(true);
         forward.setPath(request.getContextPath() + "/report/ReportList.re");
			
		}
		
		
		
		
		forward.setRedirect(true);
	    forward.setPath(request.getContextPath() + "/bbs/BbsView.bb?bbs_num=" + bbs_num);
		

//		forward.setRedirect(false);
//		forward.setPath("/index.jsp");

		return forward;
	}

}