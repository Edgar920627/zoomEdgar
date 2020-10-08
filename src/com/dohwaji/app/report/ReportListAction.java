package com.dohwaji.app.report;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.report.dao.ReportBean;
import com.dohwaji.app.report.dao.ReportDAO;


public class ReportListAction implements Action{



	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		ReportBean r_bean = new ReportBean();
		ReportDAO r_dao = new ReportDAO();
		
		HttpSession session = request.getSession();

		String temp = request.getParameter("page");
		
 		String report_result = "확인중";
 		
 		
 		
 		
 		
 		
 		
 		
		
		int page = temp == null ? 1 : Integer.parseInt(temp);
		int pageSize = 10;
		int totalCnt = r_dao.reportDivCnt(report_result);
		
		int endRow = page * 10;
		int startRow = endRow - 9;
		
		int startPage = ((page - 1) / pageSize) * pageSize + 1;
		int endPage = startPage + 9;
		int totalPage = (totalCnt - 1) / pageSize + 1;
		
		
		endPage = endPage > totalPage ? totalPage : endPage;

		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("reportList", r_dao.listResult(startRow, endRow, report_result));
		
		
		
		


		
		forward.setRedirect(false);
		forward.setPath("/app/report/reportList.jsp");
		
		return forward;
	}

}
